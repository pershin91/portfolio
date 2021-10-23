create table if not exists product
(
    id    bigserial not null
        constraint product_pk
            primary key,
    name  varchar,
    code  varchar   not null,
    price int
);

create unique index if not exists product_code_uindex
    on product (code);

create unique index if not exists product_id_uindex
    on product (id);