package com.example.staniak.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ProductApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldFetchProductsById() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/api/product/1")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name", is("T-shirt")))
                .andExpect(jsonPath("productType", is("MALE")))
                .andExpect(jsonPath("price", is(95.00)));
    }

    @Test
    public void shouldFetchProductVisitCount() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        List<Callable<ResultActions>> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            tasks.add(
                    () -> mvc.perform(MockMvcRequestBuilders
                            .get("/api/product/2")
                            .contentType(APPLICATION_JSON_VALUE)));

        }
        executor.invokeAll(tasks);
        executor.shutdown();

        mvc.perform(MockMvcRequestBuilders
                .get("/api/product/2/stats")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("visitCount", is(10)));
    }

    @Test
    public void shouldThrowExceptionWhenProductNotExists() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/api/product/10")
                .contentType(APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("message", is("Product id: 10 not found")));
    }

}