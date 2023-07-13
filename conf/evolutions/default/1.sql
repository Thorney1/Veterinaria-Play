# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

-- apply changes
create table animal (
  id                            integer not null,
  animal_nombre                 varchar(255),
  tipo_animal_id                integer not null,
  raza                          varchar(255),
  edad                          varchar(255),
  chip                          varchar(255),
  descripcion                   varchar(255),
  ingreso                       timestamp,
  cliente_id                    integer not null,
  estado_animal_id              integer not null,
  constraint pk_animal primary key (id)
);

create table cliente (
  id                            integer not null,
  name                          varchar(255),
  apellido                      varchar(255),
  cli_rut                       varchar(255),
  telefono                      integer not null,
  direccion                     varchar(255),
  email                         varchar(255),
  constraint pk_cliente primary key (id)
);

create table diagnostico (
  id                            integer not null,
  animal_id                     integer not null,
  veterinaria_id                integer not null,
  descripcion                   varchar(255),
  medicamento                   varchar(255),
  uuid                          varchar(255),
  constraint pk_diagnostico primary key (id)
);

create table estado_animal (
  id                            integer not null,
  estado                        varchar(255),
  constraint pk_estado_animal primary key (id)
);

create table tipo_animal (
  id                            integer not null,
  tipo                          varchar(255),
  constraint pk_tipo_animal primary key (id)
);

create table user (
  id                            integer not null,
  rut                           varchar(255),
  pass                          varchar(255),
  tipo_usuario                  integer not null,
  constraint pk_user primary key (id)
);


# --- !Downs

-- drop all
drop table if exists animal;

drop table if exists cliente;

drop table if exists diagnostico;

drop table if exists estado_animal;

drop table if exists tipo_animal;

drop table if exists user;

