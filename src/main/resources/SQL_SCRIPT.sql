create database LEARN_ENGLISH_APP;
use LEARN_ENGLISH_APP;
# drop database LEARN_ENGLISH_APP;
create table vocabulary(
	id int primary key auto_increment,
    vocabulary varchar(100) not null,
    mean varchar(100) not null,
    audio varchar(255),
    image varchar(255),
    example_sentences varchar(255) not null,
    meaning_exp varchar(255) not null,
    topic_id int not null
);
create table topic(
	id int primary key auto_increment,
    represent varchar(255) not null,
    `description` varchar(225) not null,
    descriptive_meaning varchar(255) not null,
	lesson_id int not null
);

create table lesson(
	id int primary key auto_increment,
    `name` varchar(100) not null,
    target varchar(255) not null,
    `description` varchar(500)
);
create table `account`(
	id int primary key auto_increment,
    username varchar(50) not null,
    `password` varchar(64) not null,
    full_name varchar(100) not null,
    email varchar(100) not null
);
create table account_detail(
	id int primary key auto_increment,
    account_id int not null,
    vocabulary_id int not null
);
create table account_topic(
	id int primary key auto_increment,
    account_id int not null,
    topic_id int not null,
    `status` int not null
);
create table account_rank(
	id int primary key auto_increment,
    account_id int not null,
    rank_id int not null
);
create table `tbl_rank`(
	id int primary key auto_increment,
    `name` varchar(50) not null,
    `description` varchar(500),
    repersent varchar(255),
    `type` varchar(20) not null
); 


alter table `account_rank` add foreign key(account_id) references `account`(id);	
alter table `account_rank` add foreign key(rank_id) references `tbl_rank`(id);
alter table `account_detail` add foreign key(account_id) references `account`(id);	
alter table `account_detail` add foreign key(vocabulary_id) references `vocabulary`(id);	
alter table `account_topic` add foreign key(account_id) references `account`(id);	
alter table `account_topic` add foreign key(topic_id) references `topic`(id);
alter table `topic` add foreign key(lesson_id) references `lesson`(id);	
alter table `vocabulary` add foreign key(topic_id) references `topic`(id);	

#------------------------------------ add data ---------------------------------------------#

# insert into `account` values (null,"manhthanh","Thanh25102","BUi Manh THanh","manhthanh147@gmail.com"),
#                              (null,"manhthanh","Thanh25102","BUi Manh THanh","manhthanh147@gmail.com");

# insert into `lesson` values  (null,"Toeic 100","Thành thạo 1000 từ toeic","This is description t"),
#                              (null,"Ielt 100","Thành thạo 1000 từ ielt","This is description i"),
#                              (null,"Simple 100","Thành thạo 1000 từ simple","This is description s");