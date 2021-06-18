create table partner
(
    id uuid not null
        constraint partner_pkey
            primary key,
    description varchar(255),
    logo_url varchar(255),
    name varchar(255)
);
