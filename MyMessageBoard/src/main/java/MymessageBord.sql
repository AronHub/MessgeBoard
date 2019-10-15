--�û���  
create table users(
   usr_id number primary key,
   name varchar2(13) unique not null ,
   pssword varchar2(100) not null,
   email varchar2(30),
   telep varchar2(20),
   addr  varchar2(50)
);
 

--�û�����
create sequence seq_user
minvalue 1
maxvalue 99999999999999
start with 1
increment by 1

select * from users
delete from users
--����û���Ϣ
insert into users values(seq_user.nextval,'fujt','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','�Ϻ�' );
insert into users values(seq_user.nextval,'tt','202cb962ac59075b964b07152d234b70','416926039@qq.com','189888','�Ϻ�' );
insert into users values(seq_user.nextval,'ff','202cb962ac59075b964b07152d234b70','416926039@qq.com','189000','����' );
insert into users values(seq_user.nextval,'jj','202cb962ac59075b964b07152d234b70','416926039@qq.com','18934543','����' );
insert into users values(seq_user.nextval,'kk','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','������' );
insert into users values(seq_user.nextval,'aa','202cb962ac59075b964b07152d234b70','416926039@qq.com','189888','�Ϻ�' );
insert into users values(seq_user.nextval,'bb','202cb962ac59075b964b07152d234b70','416926039@qq.com','189000','����' );
insert into users values(seq_user.nextval,'cc','202cb962ac59075b964b07152d234b70','416926039@qq.com','18934543','����' );
insert into users values(seq_user.nextval,'dd','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','������' );
insert into users values(seq_user.nextval,'����','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','����' );
insert into users values(seq_user.nextval,'ll','202cb962ac59075b964b07152d234b70','416926039@qq.com','183435','�Ϻ�' );

--������ɫ��
create table role(
   role_id number,
   name nvarchar2(30),
   levl nchar(2)

);
alter table role add constraint pk_rid  primary key(role_id);


--��ɫ_����
create sequence seq_role
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1


--��ӽ�ɫ����
insert into role values(seq_role.nextval,'����Ա','��');
insert into role values(seq_role.nextval,'��ͨ�û�','��');
insert into role values(seq_role.nextval,'�鳤','��');
insert into role values(seq_role.nextval,'����','��');




--�����û���ɫ��
create table user_role(
   id number,
   role_id  number,
   user_id  number,
   constraint pk_fork foreign key(role_id) references role(role_id),
   constraint pk_forein foreign key(user_id) references users(usr_id)

);


--�����û���ɫ-����
create sequence seq_userrole
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1











--������Ŀ��
create table projects(
   id     number primary key ,
   name   nvarchar2(30),
   manager nvarchar2(20),--����
   members nvarchar2(20)--��Ա
);

--��Ŀ����
create sequence seq_project
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1


insert into projects values(seq_project.nextval,'��ӯ����','aa','bb');
insert into projects values(seq_project.nextval,'��������ƽ̨','aa','bb');
insert into projects values(seq_project.nextval,'������ƽ̨','aa','bb');
insert into projects values(seq_project.nextval,'���ܼ�','aa','bb');
insert into projects values(seq_project.nextval,'��ӯ����','aa','bb');
insert into projects values(seq_project.nextval,'��������ƽ̨','aa','bb');
insert into projects values(seq_project.nextval,'������ƽ̨','aa','bb');
insert into projects values(seq_project.nextval,'���ܼ�','aa','bb');
insert into projects values(seq_project.nextval,'���ܼ�','aa','bb');
insert into projects values(seq_project.nextval,'��ӯ����','aa','bb');
insert into projects values(seq_project.nextval,'��������ƽ̨','aa','bb');
insert into projects values(seq_project.nextval,'������ƽ̨','aa','bb');
insert into projects values(seq_project.nextval,'���ܼ�','aa','bb');


--���԰���Ϣ��
create table Message(
messge_id number  primary key ,
conetent varchar2(30),
message_time timestamp,
getter_id number,--�����û�id
sender_id number--�����û�id

)

create  sequence seq_Message
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1

insert into Message values(seq_Message.Nextval,'���!',to_date('2011-11-11','yyyy-mm-dd'),'101','102')


select * from Message
