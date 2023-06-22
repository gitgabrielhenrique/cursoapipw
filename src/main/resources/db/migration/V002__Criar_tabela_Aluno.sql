Create Table aluno(
idalunos bigint not null primary key auto_increment,
nomealuno VARCHAR(300),
idcurso int not null,
idcidade int not null

);


Alter table aluno add constraint FK_aluno_curso FOREIGN key (idcurso) references curso(id);
Alter table aluno add constraint FK_aluno_cidade FOREIGN key (idcidade) references cidade(id);

insert into aluno(idalunos,nomealuno,idcurso,idcidade) values(100,'gabriel',10,1);
insert into aluno(idalunos,nomealuno,idcurso,idcidade) values(200,'monique',20,2);
insert into aluno(idalunos,nomealuno,idcurso,idcidade) values(300,'mirella',30,3);
insert into aluno(idalunos,nomealuno,idcurso,idcidade) values(400,'sarah',40,4);
