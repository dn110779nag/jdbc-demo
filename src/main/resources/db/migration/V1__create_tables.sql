
create table items(
    id serial primary key,
    name varchar(32),
    description text
);

create table json_data(
    id bigserial primary key,
    val1 json
);