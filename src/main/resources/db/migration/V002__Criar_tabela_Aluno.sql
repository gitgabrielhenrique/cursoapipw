Create Table Aluno(
id int not null primary key auto_increment,
nomealuno VARCHAR(300),
cursoid BigIint not null,
cidadeid BigIint not null



)
Alter table Aluno add constraint FK_aluno_curso FOREIGN key (cursoid) references curso(id);
Alter table Aluno add constraint FK_aluno_cidade FOREIGN key (cidadeid) references cidade(id);

insert into Aluno(nomealuno) values('gabriel');
insert into Aluno(nomealuno) values('monique');
insert into Aluno(nomealuno) values('mirella');
insert into Aluno(nomealuno) values('sarah');