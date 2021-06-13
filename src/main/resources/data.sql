create table cliente
(
    nome     int not null,
    endereco char not null,
    email    char not null,
    telefone char not null
);
insert into cliente (nome, endereco, email, telefone)
values ('Carlos Fernandes', 'Avenida Andradina', 'Carlosfernandes_@patrilarm.com.br', '993496988');