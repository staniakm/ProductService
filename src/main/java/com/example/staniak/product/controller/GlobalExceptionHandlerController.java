package com.example.staniak.product.controller;

import com.example.staniak.product.exception.ApiErrorResponse;
import com.example.staniak.product.exception.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandlerController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({ProductNotFoundException.class})
    public ResponseEntity<ApiErrorResponse> handleEntityNotFoundException(Exception ex, WebRequest request) {

        return prepareResponse(new ApiErrorResponse.ApiErrorResponseBuilder()
                .withStatus(HttpStatus.NOT_FOUND)
                .withError_code(HttpStatus.NOT_FOUND.toString())
                .withMessage(ex.getMessage())
                .withDetail(request.getDescription(false)).build());
    }

    private ResponseEntity<ApiErrorResponse> prepareResponse(ApiErrorResponse apiErrorResponse) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        return new ResponseEntity<>(apiErrorResponse, headers, apiErrorResponse.getStatus());
    }


}
