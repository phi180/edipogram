create schema if not exists enigmi_schema;

create table if not exists enigmi_schema.enigma (
    id bigint primary key not null,
    autore varchar(100),
    tipo varchar(100),
    tipo_specifico varchar(100),
    titolo varchar(100),
	testo bytea,
	soluzione bytea
);

create sequence if not exists enigmi_schema.enigma_seq start 1 increment 1 owned by enigmi_schema.enigma.id;