create table product_type_discount
(
    id               int primary key auto_increment,
    product_type     varchar(50) not null,
    discount_percent int         not null default 0
);

create table product
(
    id           int primary key auto_increment,
    name         varchar(150)   not null,
    description  varchar(2000)  null,
    product_type varchar(50)    not null,
    price        decimal(10, 2) not null default 0.00,
    foreign key (product_type) references product_type_discount (product_type)
);


create table product_stats
(
    id          int primary key auto_increment,
    product_id  int not null,
    visit_count int not null default 0,
    foreign key (product_id) references product (id)
);

