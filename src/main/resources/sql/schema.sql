
drop table if exists user;

create table user(
    id bigint auto_increment,
    name varchar(50) not null,
    primary key (id),
    unique key unq_name (name)
);
