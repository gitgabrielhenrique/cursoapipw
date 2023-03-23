Create table cidade(
id int not null primary key auto_increment,
uf VARCHAR(45),
nomecidade VARCHAR(150)



);

insert into cidade(id,uf,nomecidade) values (1,'Distrito Federal','Macatuba');
insert into cidade(id,uf,nomecidade) values (2,'Rio de Janeiro','Rio de Janeiro');
insert into cidade(id,uf,nomecidade) values (3,'Sao Paulo','Lencois Paulista');
insert into cidade(id,uf,nomecidade) values (4,'Tocantins','Palmas');

Create table curso(
id int not null primary key auto_increment,
nomecurso VARCHAR(150)


);
insert into curso(id,nomecurso) values (1,'Desenvolvimento de Sistemas');
insert into curso(id,nomecurso) values (2,'adiministracao');
insert into curso(id,nomecurso) values (3,'quimica');
insert into curso(id,nomecurso) values (4,'marketing');

