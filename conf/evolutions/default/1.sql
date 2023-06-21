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


# --- !Downs

-- drop all
drop table if exists user;

