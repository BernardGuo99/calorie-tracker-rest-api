/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Ning
 * Created: 28-Mar-2019
 */
create table app_user 
(
    user_id varchar(50) not null,
    firstname varchar(50),
    surname varchar(50),
    email varchar(50),
    date_of_birth date,
    height double,
    weight double,
    gender varchar(50),
    address varchar(500),
    postcode varchar(50),
    level_of_activity integer,
    steps_per_mile integer
);

alter table app_user
add constraint pk_user primary key (user_id);

create table food
(
    food_id varchar(50) not null,
    food_name varchar(50),
    category varchar(50),
    calorie_amount double,
    service_unit varchar(50),
    fat integer
);

alter table food
add constraint pk_food primary key (food_id);

create table credential
(
    credential_id varchar(50) not null,
    user_id varchar(50),
    user_name varchar(50),
    password_hash varchar(100),
    sign_up_date date
);

alter table credential 
add constraint pk_credential primary key (credential_id);

alter table credential 
add constraint fk_credential_user foreign key(user_id) references app_user(user_id) on delete cascade;

create table report 
(
    report_id varchar(50) not null,
    user_id varchar(50),
    report_date date,
    calories_consumed double,
    calories_burned double,
    steps_taken integer,
    calorie_goal double
);

alter table report
add constraint pk_report primary key (report_id);

alter table report 
add constraint fk_report_user foreign key(user_id) references app_user(user_id) on delete cascade;

create table consumption
(
    consumption_id varchar(50) not null,
    user_id varchar(50),
    food_id varchar(50),
    consumption_date date,
    quantity integer
);

alter table consumption
add constraint pk_consumption primary key(consumption_id);

alter table consumption 
add constraint fk_consumption_user foreign key(user_id) references app_user(user_id) on delete cascade;

alter table consumption 
add constraint fk_consumption_food foreign key(food_id) references food(food_id) on delete cascade;

