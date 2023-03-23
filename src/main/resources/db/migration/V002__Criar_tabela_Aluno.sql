Create Table aluno(
id bigint not null primary key auto_increment,
nomealuno VARCHAR(300),
cursoid int not null,
cidadeid int not null


);


Alter table aluno add constraint FK_aluno_curso FOREIGN key (cursoid) references curso(id);
Alter table aluno add constraint FK_aluno_cidade FOREIGN key (cidadeid) references cidade(id);

insert into aluno(id,nomealuno,cursoid,cidadeid) values(1,'gabriel',1,1);
insert into aluno(id,nomealuno,cursoid,cidadeid) values(2,'monique',2,2);
insert into aluno(id,nomealuno,cursoid,cidadeid) values(3,'mirella',3,3);
insert into aluno(id,nomealuno,cursoid,cidadeid) values(4,'sarah',4,4);