create table coin
(
    id     integer not null
        constraint coin_pk
            primary key,
    symbol text    not null,
    price  numeric
);

create table usr
(
    id       integer not null
        constraint usr_pk
            primary key,
    username text    not null
);

create table coin_to_user
(
    coin_id            integer not null
        constraint to_coin_fk
            references coin,
    usr_id             integer not null
        constraint to_user_fk
            references usr,
    id                 integer not null,
    registration_price double precision,
    constraint coin_to_user_pk
        primary key (usr_id, coin_id)
);