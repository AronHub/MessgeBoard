--用户表  
create table users(
   usr_id number primary key,
   name varchar2(13) unique not null ,
   pssword varchar2(100) not null,
   email varchar2(30),
   telep varchar2(20),
   addr  varchar2(50)
);
 

--用户序列
create sequence seq_user
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1

select * from users
delete from users
--添加用户信息
insert into users values(seq_user.nextval,'fujt','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','上航' );
insert into users values(seq_user.nextval,'tt','202cb962ac59075b964b07152d234b70','416926039@qq.com','189888','上海' );
insert into users values(seq_user.nextval,'ff','202cb962ac59075b964b07152d234b70','416926039@qq.com','189000','北京' );
insert into users values(seq_user.nextval,'jj','202cb962ac59075b964b07152d234b70','416926039@qq.com','18934543','东京' );
insert into users values(seq_user.nextval,'kk','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','哈尔滨' );
insert into users values(seq_user.nextval,'aa','202cb962ac59075b964b07152d234b70','416926039@qq.com','189888','上海' );
insert into users values(seq_user.nextval,'bb','202cb962ac59075b964b07152d234b70','416926039@qq.com','189000','北京' );
insert into users values(seq_user.nextval,'cc','202cb962ac59075b964b07152d234b70','416926039@qq.com','18934543','东京' );
insert into users values(seq_user.nextval,'dd','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','哈尔滨' );
insert into users values(seq_user.nextval,'建涛','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','龙岩' );
insert into users values(seq_user.nextval,'ll','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','上航' );

--创建角色表
create table role(
   role_id number,
   name nvarchar2(30),
   levl nchar(2)

);
alter table role add constraint pk_rid  primary key(role_id);


--角色_序列
create sequence seq_role
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1


--添加角色数据
insert into role values(seq_role.nextval,'管理员','高');
insert into role values(seq_role.nextval,'普通用户','低');
insert into role values(seq_role.nextval,'组长','中');
insert into role values(seq_role.nextval,'经理','中');




--创建用户角色表
create table user_role(
   id number,
   role_id  number,
   user_id  number,
   constraint pk_fork foreign key(role_id) references role(role_id),
   constraint pk_forein foreign key(user_id) references users(usr_id)

);


--创建用户角色-序列
create sequence seq_userrole
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1











--创建项目表
create table projects(
   id     number primary key ,
   name   nvarchar2(30),
   manager nvarchar2(20),--经理
   members nvarchar2(20)--组员
);

--项目序列
create sequence seq_project
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1


insert into projects values(seq_project.nextval,'佰盈核心','aa','bb');
insert into projects values(seq_project.nextval,'基础服务平台','aa','bb');
insert into projects values(seq_project.nextval,'大数据平台','aa','bb');
insert into projects values(seq_project.nextval,'富管家','aa','bb');
insert into projects values(seq_project.nextval,'佰盈核心','aa','bb');
insert into projects values(seq_project.nextval,'基础服务平台','aa','bb');
insert into projects values(seq_project.nextval,'大数据平台','aa','bb');
insert into projects values(seq_project.nextval,'富管家','aa','bb');
insert into projects values(seq_project.nextval,'富管家','aa','bb');
insert into projects values(seq_project.nextval,'佰盈核心','aa','bb');
insert into projects values(seq_project.nextval,'基础服务平台','aa','bb');
insert into projects values(seq_project.nextval,'大数据平台','aa','bb');
insert into projects values(seq_project.nextval,'富管家','aa','bb');


--留言板信息表
create table Message(
messge_id number  primary key ,
conetent varchar2(30),
message_time timestamp,
getter_id number,--接收用户id
sender_id number--发生用户id

)

create  sequence seq_Message
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1

insert into Message values(seq_Message.Nextval,'你好!',to_date('2011-11-11','yyyy-mm-dd'),'101','102')


select * from Message
