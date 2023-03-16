Create table Cidade(
id int not null primary key auto_increment,
uf VARCHAR(45),
nomecidade VARCHAR(150)



)

insert into Cidade(nomecidade) values ('Lencois paulista');
insert into Cidade(nomecidade) values ('Bauru');
insert into Cidade(nomecidade) values ('Sao Paulo');
insert into Cidade(nomecidade) values ('Macatuba');

Create table Curso(
id int not null primary key auto_increment,
nomecurso VARCHAR(150)


)
insert into Curso(nomecurso) values ('Desenvolvimento de Sistemas');
insert into Curso(nomecurso) values ('adiministracao');
insert into Curso(nomecurso) values ('quimica');
insert into Curso(nomecurso) values ('marketing');

