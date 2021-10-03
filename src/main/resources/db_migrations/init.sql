create table productEntity
(
    id bigserial not null,
    name varchar,
    code varchar not null,
    price int
);

create unique index product_code_uindex
	on productEntity (code);

create unique index product_id_uindex
	on productEntity (id);

alter table productEntity
    add constraint product_pk
        primary key (id);