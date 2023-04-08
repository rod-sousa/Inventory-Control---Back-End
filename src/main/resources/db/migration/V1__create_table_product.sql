create table product(
    id bigint not null auto_increment,
    name varchar(50) not null,
    amount double not null,
    description varchar(100),
    color varchar(50) not null,
    quantity bigint not null,
    primary key(id)
);
