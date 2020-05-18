create database if not exists dili

create table if not exists Store
(
  ID         int auto_increment,
  store_name tinytext not null,
  password   tinytext not null,
  constraint Store_ID_uindex
  unique (ID)
);

alter table Store
  add primary key (ID);

create table if not exists Item
(
  ID          int auto_increment,
  store_id    int      not null,
  item_name   tinytext not null,
  image       longtext null,
  price       double   null,
  description longtext null,
  constraint Item_ID_uindex
  unique (ID),
  constraint Item_Store_ID_fk
  foreign key (store_id) references Store (ID)
);

alter table Item
  add primary key (ID);

create table if not exists User
(
  ID       int auto_increment,
  email    tinytext not null,
  username tinytext not null,
  password text     not null,
  constraint User_ID_uindex
  unique (ID)
);

alter table User
  add primary key (ID);
