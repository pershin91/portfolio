create table product
(
    id bigserial not null,
    name varchar,
    code varchar not null,
    price int
);

create unique index product_code_uindex
	on product (code);

create unique index product_id_uindex
	on product (id);

alter table product
    add constraint product_pk
        primary key (id);