create schema if not exists connessioni_schema;

create table if not exists connessioni_schema.connessione (
    id bigint primary key not null,
    utente varchar(100),
    tipo varchar(100)
);

create sequence if not exists connessioni_schema.connessione_seq start 1 increment 1 owned by connessioni_schema.connessione.id;