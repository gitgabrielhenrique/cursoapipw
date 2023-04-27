Create Table aluno(
id bigint not null primary key auto_increment,
nomealuno VARCHAR(300),
idcurso int not null,
idcidade int not null


);


Alter table aluno add constraint FK_aluno_curso FOREIGN key (idcurso) references curso(id);
Alter table aluno add constraint FK_aluno_cidade FOREIGN key (idcidade) references cidade(id);

insert into aluno(id,nomealuno,idcurso,idcidade) values(1,'gabriel',1,1);
insert into aluno(id,nomealuno,idcurso,idcidade) values(2,'monique',2,2);
insert into aluno(id,nomealuno,idcurso,idcidade) values(3,'mirella',3,3);
insert into aluno(id,nomealuno,idcurso,idcidade) values(4,'sarah',4,4);
