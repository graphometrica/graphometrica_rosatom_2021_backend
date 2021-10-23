create table route
(
    route_id varchar(36) not null
        constraint route_pk
            primary key,
    stations jsonb,
    payload jsonb,
    status int not null default 0,
    route jsonb,
    total_time int,
    route_csv varchar(10000),
    qubo_matrix_csv varchar(10000),
    adjacency_matrix_csv varchar(10000),
    solution_type varchar(100),
    ham_energy double precision,
    solver_type varchar(100)
);