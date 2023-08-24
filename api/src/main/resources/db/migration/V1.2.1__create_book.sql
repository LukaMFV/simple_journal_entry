use simple_journal_entry_db;

create table books
(
    id         bigint  not null primary key auto_increment,
    name       varchar(20)  not null,
    author_id  bigint not null,
    description    varchar(100),
    foreign key fk_author (author_id) references authors (id)
);