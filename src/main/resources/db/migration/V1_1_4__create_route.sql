create table route
(
    route_id serial
        constraint route_pk
            primary key,
    stations text,
    payload text,
    status int not null default 0,
    route text,
    total_time int,
    route_csv varchar(10000),
    qubo_matrix_csv varchar(10000),
    adjacency_matrix_csv varchar(10000),
    solution_type varchar(100),
    ham_energy double precision,
    solver_type varchar(100)
);