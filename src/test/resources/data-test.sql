insert into product_type_discount(product_type, discount_percent) values ('MALE', 5);
insert into product_type_discount(product_type, discount_percent) values ('FEMALE', 5);
insert into product_type_discount(product_type, discount_percent) values ('KID', 10);

insert into PRODUCT(name, description, product_type, price)
values ('T-shirt', 'Man t-shirt', 'MALE', 100.00);
insert into PRODUCT(name, description, product_type, price)
values ('Coat', 'Winter woman coat', 'FEMALE', 200.00);
insert into PRODUCT(name, description, product_type, price)
values ('Shoes', 'Kids shoes', 'KID', 150.00);

insert into product_stats (product_id) values (1);
insert into product_stats (product_id) values (2);
insert into product_stats (product_id) values (3);