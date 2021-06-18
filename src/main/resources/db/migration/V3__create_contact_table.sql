create table contact
(
    id uuid not null
        constraint contact_pkey
            primary key,
    details_mail_address varchar(255),
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    middle_name varchar(255),
    details_phone_number varchar(255),
    partner_id uuid
        constraint fk_partner_contact
            references partner
);

