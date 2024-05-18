create table cliente(
	id 			uuid			primary key,
	nome		varchar(100)	not null,
	email		varchar(50)		not null,
	telefone	varchar(15)		not null
	);