use simple_journal_entry_db;

create table authors
(
    id         bigint  not null primary key auto_increment,
    name       varchar(20)  not null,
    age        int not null,
    address    varchar(100)
);