alter table route
    add column created timestamp not null default now(),
    add column calculated timestamp