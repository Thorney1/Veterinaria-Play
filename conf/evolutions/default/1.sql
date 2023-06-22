# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- apply changes
create table user (
  id                            integer not null,
  rut                           varchar(255),
  pass                          varchar(255),
  tipo_usuario                  integer not null,
  constraint pk_user primary key (id)
);

CREATE TABLE tipo_animal (
  "id"   INTEGER,
  "tipo" VARCHAR NOT NULL,
  PRIMARY KEY ("id" AUTOINCREMENT)
);

CREATE TABLE estado_animal (
"id"	                        INTEGER,
"estado"	                    VARCHAR NOT NULL,
PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE cliente (
"id"	                        INTEGER,
"name"	                        VARCHAR NOT NULL,
"apellido"	                    VARCHAR NOT NULL,
"cli_rut"	                    VARCHAR NOT NULL,
"telefono"	                    VARCHAR NOT NULL,
"direccion"	                    VARCHAR NOT NULL,
"email"	                        VARCHAR NOT NULL UNIQUE,
PRIMARY KEY("id" AUTOINCREMENT)
);

CREATE TABLE diagnostico (
"id"	                       INTEGER,
"animal_id"	                   ,
"veterinaria_id"	           ,
"descripcion"	               VARCHAR NOT NULL,
"medicamento"	               VARCHAR NOT NULL,
"uuid"	                       TEXT NOT NULL,
FOREIGN KEY("veterinaria_id") REFERENCES "user"("id"),
FOREIGN KEY("animal_id") REFERENCES "animal"("id"),
PRIMARY KEY("id" AUTOINCREMENT)
);



# --- !Downs

-- drop all
drop table if exists user;

