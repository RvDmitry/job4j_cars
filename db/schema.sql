create table users(
    id serial primary key,
    name text not null,
    phone text unique not null,
    email text unique not null,
    password text not null
);

create table photos(
    id serial primary key
);

create table engines(
    id serial primary key,
    name text,
    power int not null,
    volume real not null
);

create table body(
    id serial primary key,
    name text unique not null
);

create table brands(
    id serial primary key,
    name text unique not null
);

create table models(
    id serial primary key,
    name text not null,
    brand_id int references brands(id) not null
);

create table cars(
    id serial primary key,
    year int not null,
    model_id int references models(id) not null,
    body_id int references body(id) not null,
    engine_id int references engines(id) not null
);

create table announcements(
    id serial primary key,
    description text not null,
    created timestamp not null,
    status boolean not null,
    photo_id int references photos(id) unique,
    car_id int references cars(id) unique not null,
    user_id int references users(id) not null
);