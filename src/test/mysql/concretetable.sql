create database concretepage;
use concretepage;
create table article (
	id int not null auto_increment,
    article_id varchar(20),
    title varchar(200),
    category varchar(200),
    primary key (id));

insert into article (article_id, title, category) values (
	'1122', 'Start coding in java spring jpa', 'java/spring/jpa');

insert into article (article_id, title, category) values (
	'1123', 'Start coding in java', 'java');

insert into article (article_id, title, category) values (
	'1124', 'Start coding in jpa', 'jpa');

insert into article (article_id, title, category) values (
	'1125', 'Start coding in hql', 'jpa');

insert into article (article_id, title, category) values (
	'1126', 'Start coding in native java', 'java');

insert into article (article_id, title, category) values (
	'1127', 'Start coding in patterns', 'code');

insert into article (article_id, title, category) values (
	'1128', 'Start coding in MySQL', 'mysql');

insert into article (article_id, title, category) values (
	'1129', 'Start coding in .NET', 'microsoft');

insert into article (article_id, title, category) values (
	'1130', 'Start coding in perl', 'script');

insert into article (article_id, title, category) values (
	'1131', 'Start coding in batch commands', 'windows');

--select * from article;