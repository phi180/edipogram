create schema if not exists enigmiseguiti_schema;

create table if not exists enigmiseguiti_schema.enigma (
    id bigint primary key not null,
    autore varchar(100),
    tipo varchar(100),
    tipo_specifico varchar(100),
    titolo varchar(100),
    testo bytea
);

create table if not exists enigmiseguiti_schema.connessione (
    id bigint primary key not null,
    utente varchar(100),
    tipo varchar(100)
);

create table if not exists enigmiseguiti_schema.enigmiseguiti (

    utente varchar(100) not null,
    id_enigma bigint not null,

    autore_enigma varchar(100),
    tipo_enigma varchar(100),
    tipo_specifico_enigma varchar(100),
    titolo_enigma varchar(100),
    testo_enigma bytea,

    primary key (utente,id_enigma),
    constraint enigma_fkey
        foreign key (id_enigma)
            references enigmiseguiti_schema.enigma
);

create sequence if not exists enigmiseguiti_schema.enigma_seq start 1 increment 1 owned by enigmiseguiti_schema.enigma.id;
create sequence if not exists enigmiseguiti_schema.connessione_seq start 1 increment 1 owned by enigmiseguiti_schema.connessione.id;