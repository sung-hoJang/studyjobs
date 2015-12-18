
-- 만들기 1
-- CU_MEMBER 테이블( 회원 )
create table cu_member(
   id varchar2(50) primary key,
   password varchar2(50) not null,
   name varchar2(50) not null,
   location varchar2(50) not null,
   tel varchar2(50) not null,
   gender varchar2(50) not null,
   birthdate date not null
)

drop table cu_member;
delete from cu_member;
select * from cu_member;

   insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('khj','1111','김혜진','서울','010','여',to_date('1991-09-04','yyyy-mm-dd'));
   insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('go','1234','고대원','서울','0109734','남',to_date('1988-01-25','yyyy-mm-dd'));
   insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('neung','1234','이능균','지방','010','남',to_date('1987-08-27','yyyy-mm-dd'));
   insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('gogosing','1234','고대','천안','010','남',to_date('2015-07-23','yyyy-mm-dd'));
    insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('kjy','1234','주예','미쿡','010','여',to_date('1990-07-23','yyyy-mm-dd'));
 insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('gg','1234','장어','부산','010','남',to_date('1990-07-23','yyyy-mm-dd'));
 insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('ggg','1234','오리','충남','010','남',to_date('1990-07-23','yyyy-mm-dd'));
 insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('rrr','1234','장성호','경북','010','남',to_date('1990-10-20','yyyy-mm-dd'));
 insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('jsh','1111','쿤타','경북','010','남',to_date('1990-10-20','yyyy-mm-dd'));
insert into CU_MEMBER(id,password,name,location,tel,gender,birthdate)
values('hhh','1111','킨테','서울','010','남',to_date('1990-10-20','yyyy-mm-dd'));

select id, password, name, location, tel, gender, substr(to_char(birthdate, 'yyyy.mm.dd HH24:MI:SS'), 1, 10)as birthdate from cu_member;
select id, password, name, location, tel, gender, birthdate from cu_member;
update cu_member set tel='0107'
where id='khj';

update cu_member set location='서울'
where id='khj';


-----------------------------------------------------------------------------------------------------

-- 만들기 2
-- CU_BOARD 테이블( 자유 게시판 )
create table cu_board(
   no number primary key,
   category varchar2(50) not null,
   content clob not null,
   title varchar2(50) not null,
   id varchar2(50) not null,
   mydate date not null,
   hits number default 0 not null,
   ref number not null,
   restep number not null,
   relevel number not null,
   parent number default 1 not null,
   foreign key (id) references cu_member(id)
)
create sequence cu_board_seq;

drop sequence cu_board_seq;
drop table cu_board;
select * from cu_board;


insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(cu_board_seq.nextval,'일반','대원오빠마마마마마마','영어정보','kjy',sysdate,8,3,0,0);

insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(4,'강호동','대원오빠마마마마마마','수학정보','kjy',sysdate,1004,3,1,1);

insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(1,'손연재','대원오빠마마마마마마','영어정보','kjy',sysdate,8,1,0,0);

insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(6,'김국진','대원오빠마마마마마마','수학정보','kjy',sysdate,1004,1,1,1);

insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(7,'윤종신','대원오빠마마마마마마','영어정보','kjy',sysdate,8,1,2,2);

insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(2,'김연아','대원오빠마마마마마마','수학정보','kjy',sysdate,1004,1,3,1);

insert into CU_BOARD(no,category,content,title,id,mydate,hits,ref,restep,relevel)
values(5,'김구라','대원오빠마마마마마마','영어정보','kjy',sysdate,8,1,4,2);





-----------------------------------------------------------------------------------------------------

-- 만들기 3
-- CU_SUBJECT_CATEOGRY 테이블(스터디 과목)
create table cu_subject_category(
   subject varchar2(50) primary key,
   subject_category varchar2(50) not null,
   category_image varchar2(300) not null
)

insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('토익','영어','subimg/english.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('토익스피킹','영어','subimg/english.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('토플','영어','subimg/english.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('오픽','영어','subimg/english.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('텝스','영어','subimg/english.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('JAVA','프로그래밍','subimg/programming.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('C/C++','프로그래밍','subimg/programming.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('Android','프로그래밍','subimg/programming.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('빅데이터','프로그래밍','subimg/programming.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('웹프로그래밍','프로그래밍','subimg/programming.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('데이터베이스','프로그래밍','subimg/programming.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('인적성','취업','subimg/getjob.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('면접','취업','subimg/getjob.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('자기소개서','취업','subimg/getjob.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('대외활동','취업','subimg/getjob.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('공모전','취업','subimg/getjob.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('자격증','취업','subimg/getjob.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('회계','금융','subimg/finance.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('주식','금융','subimg/finance.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('재테크','금융','subimg/finance.jpg');
insert into CU_SUBJECT_CATEGORY(subject,subject_category,category_image) 
values('부동산','금융','subimg/finance.jpg');

select * from CU_SUBJECT_CATEGORY;
drop table cu_subject_category;

update CU_SUBJECT_CATEGORY set category_image = 'subimg/english.jpg' where subject='토익';



-----------------------------------------------------------------------------------------------------

-- 만들기 4
-- CU_STUDY_LOCATION 테이블
create table cu_study_location(
	glocation varchar2(50) primary key
)

drop table cu_study_location;
select * from cu_study_location;

insert into cu_study_location(glocation) values('강원');
insert into cu_study_location(glocation) values('경기');
insert into cu_study_location(glocation) values('경남');
insert into cu_study_location(glocation) values('경북');
insert into cu_study_location(glocation) values('광주');
insert into cu_study_location(glocation) values('대구');
insert into cu_study_location(glocation) values('대전');
insert into cu_study_location(glocation) values('부산');
insert into cu_study_location(glocation) values('서울');
insert into cu_study_location(glocation) values('세종');
insert into cu_study_location(glocation) values('울산');
insert into cu_study_location(glocation) values('인천');
insert into cu_study_location(glocation) values('전남');
insert into cu_study_location(glocation) values('전북');
insert into cu_study_location(glocation) values('제주');
insert into cu_study_location(glocation) values('충남');
insert into cu_study_location(glocation) values('충북');




-----------------------------------------------------------------------------------------------------


-- 만들기 5
-- CU_GROUP 테이블 ( 그룹 )
create table cu_group(
   gleader_id varchar2(50) primary key,
   gname varchar2(50) not null,
   gsubject varchar2(50) not null,      
   ginfo clob not null,
   gmember_count number not null,
   glocation varchar2(50) not null,
   gdate date not null,
   cur_member number not null,
   foreign key(gsubject) references cu_subject_category(subject),
   foreign key(glocation) references cu_study_location(glocation)
)

insert into cu_group values('go','고대원','토익','토익스터디',6,'서울', to_date('2015-12-01 17:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('neung','이능균','JAVA','자바스터디',6,'부산',  to_date('2015-12-02 18:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('gogosing','고대','인적성','취업스터디',6,'경남',  to_date('2015-12-03 17:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('kjy','금융스터디하자!','회계','금융스터디 열심히 할 사람만 ',6,'경북',  to_date('2015-12-04 16:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('khj', '토플합시다', '토플', '토플을 열심히', 6, '강원',  to_date('2015-12-05 17:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('gg','고대원','토익','토익스터디',6,'충남',  to_date('2015-12-06 17:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('ggg','고대원','토익','토익스터디',6,'서울',  to_date('2015-12-07 17:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('rrr','취업을 합시다','인적성','취업스터디',6,'충북',  to_date('2015-12-08 17:00:30', 'yyyy-mm-dd hh24:mi:ss'), 1);
insert into cu_group values('yyyy','취업을 합시다','인적성','취업스터디',6,'충북',  to_date(sysdate, 'yyyy-mm-dd hh24:mi:ss'), 1);

drop table cu_group;

select * from cu_group;
delete from cu_group where gleader_id ='yyyy';

alter table cu_group drop column ginfo;
alter table cu_group add ginfo clob not null;

delete from cu_group where gleader_id='yyyy';
update cu_group set glocation='부산' where gname='이능균';
update cu_group set glocation='경남' where gname='고대';
update cu_group set gname='토익만점' where gleader_id='go';
update cu_group set gname='자바왕이 됩시다' where gleader_id='neung';
update cu_group set gname='토익열심' where gleader_id='gg';
update cu_group set ginfo='토익왕이 됩시다aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa' where gleader_id='ggg';
-----------------------------------------------------------------------------------------------------

-- 만들기 6
-- CU_CART (찜하기)

create table cu_cart(
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id),
   constraint pk_cu_cart primary key (id, gleader_id)
)

select * from cu_cart;
drop table cu_cart;
delete from cu_cart where gleader_id='asdf' and id='khj';

insert into cu_cart values('khj', 'rrr');





-----------------------------------------------------------------------------------

-- 만들기 7
-- CU_GROUP_MEMBER 테이블 ( 그룹원 )

create table cu_group_member(
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id),
   constraint pk_cu_group_member primary key (id, gleader_id)
)

drop table cu_group_member;

select * from cu_group_member;

insert into cu_group_member values('khj', 'go');
insert into cu_group_member values('khj', 'neung');
insert into cu_group_member values('khj', 'gogosing');
insert into cu_group_member values('khj', 'kjy');
insert into cu_group_member values('khj', 'gg');
insert into cu_group_member values('khj', 'ggg');
insert into cu_group_member values('khj', 'khj');

delete from cu_group_member where gleader_id='yyyy';


-----------------------------------------------------------------------------------------------------


-- 만들기 8
-- CU_SCHEDULE (스케줄)

create table cu_schedule(
	no number primary key,
	id varchar2(50) not null,
	gleader_id varchar2(50) not null,
	schedule_date date not null,
	schedule_info clob not null,
	foreign key(id, gleader_id) references cu_group_member(id, gleader_id)
)

create sequence cu_schedule_seq;
select to_char(sysdate, 'dd') from dual;
select to_char(schedule_date, 'dd')-to_char(sysdate, 'dd') from cu_schedule;
select no, id, gleader_id, to_char(schedule_date, 'yyyy-mm-dd hh24:mi'), schedule_info from cu_schedule;

drop table cu_schedule;
drop sequence cu_schedule_seq;


insert into cu_schedule values(cu_schedule_seq.nextval, 'khj', 'go', to_date('2015-12-03 18:30', 'yyyy-mm-dd hh24:mi'), '단어외우기');
insert into cu_schedule values(cu_schedule_seq.nextval, 'khj', 'neung', to_date('2015-12-06 13:03', 'yyyy-mm-dd hh24:mi'), '단어외우기');
insert into cu_schedule values(cu_schedule_seq.nextval, 'khj', 'kjy', to_date('2015-12-24 19:00', 'yyyy-mm-dd hh24:mi'), '강남역 카페');
insert into cu_schedule values(cu_schedule_seq.nextval, 'khj', 'kjy', to_date('2015-12-09 19:00', 'yyyy-mm-dd hh24:mi'), '강남역 카페');
insert into cu_schedule values(cu_schedule_seq.nextval, 'khj', 'kjy', to_date('2015-12-19 19:00', 'yyyy-mm-dd hh24:mi'), '강남역 카페');
insert into cu_schedule values(cu_schedule_seq.nextval, 'khj', 'khj', to_date('2015-12-19 19:00', 'yyyy-mm-dd hh24:mi'), '강남역 카페');
--------------------------------------------------------------------------------------------------


-- 만들기 9
-- CU_LAST_SCHEDULE (스케줄)

create table cu_last_schedule(
	no number primary key,
	id varchar2(50) not null,
	gleader_id varchar2(50) not null,
	schedule_date date not null,
	schedule_info clob not null,
	foreign key(id, gleader_id) references cu_group_member(id, gleader_id)
)
create sequence cu_last_schedule_seq;
select * from cu_last_schedule;

drop table cu_last_schedule;
drop sequence cu_last_schedule_seq;


--------------------------------------------------------------------------------------------------

-- 만들기 10
-- CU_GROUP_JOIN ( 그룹 가입 신청 )
create table cu_group_join (
   gjno number primary key,
   id varchar2(50) not null,
   gjtitle varchar2(50) not null,
   gjcontent clob not null,
   gleader_id varchar2(50) not null,
   constraint fk_cu_member foreign key(id) references cu_member(id),
   constraint fk_cu_group foreign key(gleader_id) references cu_group(gleader_id)
)

----- 그룹 가입 신청 시퀀스 만들기 -------- 혜진

create sequence cu_group_join_seq;
---------------------------------------------


drop table cu_group_join;
drop sequence cu_group_join_seq;
select * from cu_group_join;
delete from cu_group_join where id='aaa' and gleader_id='asdf';

insert into cu_group_join values(cu_group_join_seq.nextval, 'khj', '가입하고싶어요', '열심히하겠습니다','gg');
insert into cu_group_join values(cu_group_join_seq.nextval, 'khj', '가입하고싶어요', '열심히하겠습니다','ggg');

-----------------------------------------------------------------------------------------------------


-- 만들기 10 --> 쓸모 없어짐(드가지 않음)
-- CU_GROUP_BOARD ( 그룹 게시판 )
create table cu_group_board(
   gbno number primary key,
   gbcategory varchar2(50) not null,
   gbtitle varchar2(50) not null,
   gbcontent clob not null,
   gbdate date not null,
   gbhits number not null,
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   ref number not null,
   restep number not null,
   relevel number not null,
   parent number default 1 not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id)
)

create sequence cu_group_board_seq;

drop table cu_group_board;
drop sequence cu_group_board_seq;

select * from cu_group_board;
select * from yyyy;
drop table yyyy;
drop sequence yyyy_seq;

-----------------------------------------------------------------------------------------------------

-- 만들기 11
-- CU_KEYWORD_FREQUENCY ( 검색순위 ) 
create table cu_keyword_frequency(
   keyword varchar2(50) primary key,
   count number not null
)

drop table cu_keyword_frequency;
select * from cu_keyword_frequency;


insert into cu_keyword_frequency values('토익스터디', 5);
insert into cu_keyword_frequency values('오픽', 3);
insert into cu_keyword_frequency values('서울 오픽스터디', 10);
insert into cu_keyword_frequency values('안동에도 스터디 있나요', 14);
insert into cu_keyword_frequency values('안동스터디 구함', 9);



-----------------------------------------------------------------------------------------------------

-- 만들기 12
-- CU_DELETE_MEMBER ( 삭제회원 ) 
create table cu_delete_member(
	id varchar2(50) primary key,
	password varchar2(50) not null,
	name varchar2(50) not null,
    location varchar2(50) not null,
    tel varchar2(50) not null,
    gender varchar2(50) not null,
    birthdate date not null
)

select * from cu_delete_member;
drop table cu_delete_member;

insert into CU_DELETE_MEMBER(id,password,name,location,tel,gender,birthdate)
values('bbb','1111','강남이','서울','010','여',to_date('1991-09-04','yyyy-mm-dd'));


-----------------------------------------------------------------------------------------------------

-- 만들기 13
-- CU_DELETE_GROUP ( 삭제그룹 ) 
create table cu_delete_group(
   gleader_id varchar2(50) primary key,
   gname varchar2(50) not null,
   gsubject varchar2(50) not null,      
   ginfo varchar2(50) not null,
   gmember_count number not null,
   glocation varchar2(50) not null,
   gdate date not null,
   foreign key(gsubject) references cu_subject_category(subject),
   foreign key(glocation) references cu_study_location(glocation)
)

drop table cu_delete_group;
select * from cu_delete_group;

-----------------------------------------------------------------------------------------------------
 -- 만들기 14
-- CU_CART_FREQUENCY ( 찜한 그룹 순위 ) 
create table cu_cart_frequency(
   gleader_id varchar2(50) primary key,
   count number not null
)

drop table cu_cart_frequency;
select * from cu_cart_frequency;

---------------------------------------------------------------------------------------------------

-- 만들기 15
-- CU_SEARCH_COUNT ( 검색 횟수 )  
create table cu_search_count(
   count number not null
)

drop table cu_search_count;
select * from cu_search_count;
insert into CU_SEARCH_COUNT values(10);

-----------------------------------------------------------------------------------------------------

-- 만들기 16
-- CU_TOTAL_VISITOR
create table cu_total_visitor(
   count number not null
)

drop table cu_total_visitor;
select * from cu_total_visitor;
insert into cu_total_visitor values(1);

-------------------------------------------------------------------------------------------------------

-- 만들기 17
-- CU_LEAVE_REASON (탈퇴 이유)
create table cu_leave_reason(
	no number primary key,
	reason varchar2(200) not null,
	detailreason clob not null
)

create sequence cu_leave_reason_seq;

drop table cu_leave_reason;
select * from cu_leave_reason;


-----------------------------------------------------------------------------------------------------

-- 연습해본 SQL
select g.gleader_id as gleader_id, g.gname as gname, g.ginfo as ginfo, g.gmember_count as gmember_count, g.glocation as glocation, 
      g.gsubject as gsubject, s.subject_category as subject_category, c.name as name, s.category_image as category_image
      from cu_member c, cu_group g, cu_subject_category s
      where c.id = g.gleader_id and g.gsubject = s.subject
      
      select g.gleader_id as gleader_id, g.gname as gname, g.ginfo as ginfo, g.gmember_count as gmember_count, 
      g.glocation as glocation, g.gsubject as gsubject, s.subject_category as subject_category, c.name as name, 
      s.category_image as category_image, g.gdate as gdate, g.cur_member as cur_member
      from cu_member c, cu_group g, cu_subject_category s
       where c.id = g.gleader_id and g.gsubject = s.subject order by g.gdate desc;
      
      
  		select g.gname as gname, g.ginfo as ginfo, g.gmember_count as gmember_count, g.glocation as glocation,
   		g.gsubject as gsubject, s.subject_category as subject_category, s.category_image as category_image
   		from  cu_group g, cu_subject_category s
   		where g.gsubject=s.subject and g.gleader_id='khj';    
      
     		select g.gname as gname, g.ginfo as ginfo, g.gmember_count as gmember_count, g.glocation as glocation,
   		g.gsubject as gsubject, s.subject_category as subject_category, s.category_image as category_image
   		from cu_group_join cgj, cu_group g, cu_subject_category s
   		where cgj.gleader_id=g.gleader_id and g.gsubject=s.subject and cgj.id='khj'; 
      

  select g.gleader_id as gleader_id, g.gname as gname, g.ginfo as ginfo, g.gmember_count as gmember_count,
   	   g.glocation as glocation, g.gsubject as gsubject, s.subject_category as subject_category, s.category_image as category_image
   	  from cu_group_member cgm, cu_group g, cu_subject_category s
   	  where cgm.gleader_id = g.gleader_id and g.gsubject=s.subject and s.subject='토익';
   	  
   	  
   	  
 select cs.no as no, cs.gleader_id as gleader_id, to_char(cs.schedule_date, 'yyyy-mm-dd hh24:mi') as schedule_date, 
 cs.schedule_info as schedule_info, g.gname as gname, s.category_image as category_image
 from cu_schedule cs, cu_group g, cu_subject_category s  
 where cs.gleader_id = g.gleader_id and g.gsubject=s.subject;

 
 	 select cs.no as no, cs.gleader_id as gleader_id, to_char(cs.schedule_date, 'yyyy-mm-dd hh24:mi') as schedule_date, 
 		 cs.schedule_info as schedule_info, g.gname as gname, s.category_image as category_image, 
 		 cs.schedule_date-sysdate as deadline
 		 from cu_schedule cs, cu_group g, cu_subject_category s  
 		 where cs.gleader_id = g.gleader_id and g.gsubject=s.subject and id='khj'
 		 order by cs.schedule_date asc;
 
 
 select * from khj;
 drop table hhh;
 drop table test_group;
 
 create table jsh(
 			gbno number primary key,
 			gbcotegory varchar2(50) not null,
 			gbtitle varchar2(50) not null,
 			gbcontent clob not null,
 			gbdate date not null,
 			gbhits number not null,
 			id varchar2(50) not null,
 			gleader_id varchar2(50) not null,
 			foreign key(id) references cu_member(id),
  		    foreign key(gleader_id) references cu_group(gleader_id)
 		) 
 
 
 select sysdate from dual;
 
 select to_char(sysdate, 'yyyy-mm-dd hh24:mi:ss') from dual
 
 
 	    select g.gleader_id as gleader_id, g.gname as gname, g.ginfo as ginfo, g.gmember_count as gmember_count, 
        g.glocation as glocation, g.gsubject as gsubject, s.subject_category as subject_category, 
        s.category_image as category_image,  to_char(g.gdate, 'yyyy-mm-dd') as gdate, g.cur_member as cur_member
	    from cu_cart c, cu_group g, cu_subject_category s
	    where c.gleader_id = g.gleader_id and g.gsubject = s.subject and id='khj';
 
	    
	    
 -- 그룹삭제 sql문 연습
create sequence go_seq;
create table go(
   gbno number primary key,
   gbcategory varchar2(50) not null,
   gbtitle varchar2(50) not null,
   gbcontent clob not null,
   gbdate date not null,
   gbhits number not null,
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   ref number not null,
   restep number not null,
   relevel number not null,
   parent number default 1 not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id)
)

<!-- 그룹 가입신청 삽입 --> 
insert into cu_group_join values(cu_group_join_seq.nextval, 'hhh', '꼭 하고 싶습니다', '꼭하고 싶습니다 저는 어렸을때.부터..', 'go')

<!-- hhh를 go그룹원으로 추가 -->
insert into cu_group_member values('hhh', 'go');
insert into cu_group_member values('go', 'go');


<!-- 지난 스케쥴 삽입 -->
insert into cu_last_schedule(
     no,id,gleader_id,schedule_date,schedule_info
  )  values(cu_schedule_seq.nextval,'go','go',to_date('2015-11-30 14;30', 'yyyy-mm-dd hh24:mi'),'프로젝트프로젝트')
<!-- 스케쥴 삽입 -->
insert into cu_schedule(
     no,id,gleader_id,schedule_date,schedule_info
  )  values(cu_schedule_seq.nextval,'go','go',sysdate,'눈누난나 수료일일일일일')

  
insert into cu_schedule values(cu_schedule_seq.nextval, 'go', 'go', to_date('2015-12-19 19:00', 'yyyy-mm-dd hh24:mi'), '강남역 카페');

  
  <!-- 그룹멤버 삭제인데 아직 안됨 (무결성)-->
         delete cu_group_member where gleader_id='go'
       <!-- 그룹 삭제  아직 안됨(무결성)
         delete cu_group where gleader_id='go'

	    
	    
	    
select * from testid2;	    
	    
select * from cu_group where gleader_id='testid';	    
	    
	    
select to_char(schedule_date, 'yyyy/mm/dd hh24:mi') as schedule_date, schedule_info, to_char(schedule_date, 'dd')-to_char(sysdate, 'dd') as deadline from cu_schedule where gleader_id='aa';    
	    
select * from aa

select * from grouptest
create sequence grouptest_seq;
select * from cu_group where gleader_id='grouptest'
	    
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


drop table cu_leave_reason;
drop table cu_total_visitor;
drop table cu_search_count;
drop table cu_cart_frequency;
drop table cu_delete_group;
drop table cu_delete_member;
drop table cu_keyword_frequency;
drop table cu_group_join;
drop sequence cu_group_join_seq;
drop sequence cu_last_schedule_seq;
drop table cu_last_schedule;
drop table cu_schedule;
drop sequence cu_schedule_seq;
drop table cu_group_member;
drop table cu_cart;
drop table cu_group;
drop table cu_study_location;
drop table cu_subject_category;
drop sequence cu_board_seq;
drop table cu_board;
drop table cu_member;


업그레이드 크리에이트 순서

create table cu_member(
   id varchar2(50) primary key,
   password varchar2(50) not null,
   name varchar2(50) not null,
   location varchar2(50) not null,
   tel varchar2(50) not null,
   gender varchar2(50) not null,
   birthdate date not null
)

create table cu_board(
   no number primary key,
   category varchar2(50) not null,
   content clob not null,
   title varchar2(50) not null,
   id varchar2(50) not null,
   mydate date not null,
   hits number default 0 not null,
   ref number not null,
   restep number not null,
   relevel number not null,
   parent number default 1 not null,
   foreign key (id) references cu_member(id)
)


create sequence cu_board_seq;

create table cu_subject_category(
   subject varchar2(50) primary key,
   subject_category varchar2(50) not null,
   category_image varchar2(300) not null
)

create table cu_study_location(
   glocation varchar2(50) primary key
)

create table cu_group(
   gleader_id varchar2(50) primary key,
   gname varchar2(50) not null,
   gsubject varchar2(50) not null,      
   ginfo clob not null,
   gmember_count number not null,
   glocation varchar2(50) not null,
   gdate date not null,
   cur_member number not null,
   foreign key(gsubject) references cu_subject_category(subject),
   foreign key(glocation) references cu_study_location(glocation)
)

create table cu_cart(
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id),
   constraint pk_cu_cart primary key (id, gleader_id)
)

create table cu_group_member(
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id),
   constraint pk_cu_group_member primary key (id, gleader_id)
)

create table cu_schedule(
   no number primary key,
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   schedule_date date not null,
   schedule_info clob not null,
   foreign key(id, gleader_id) references cu_group_member(id, gleader_id)
)

create sequence cu_schedule_seq;


create table cu_last_schedule(
   no number primary key,
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   schedule_date date not null,
   schedule_info clob not null,
   foreign key(id, gleader_id) references cu_group_member(id, gleader_id)
)


create sequence cu_last_schedule_seq;

create table cu_group_join (
   gjno number primary key,
   id varchar2(50) not null,
   gjtitle varchar2(50) not null,
   gjcontent clob not null,
   gleader_id varchar2(50) not null,
   constraint fk_cu_member foreign key(id) references cu_member(id),
   constraint fk_cu_group foreign key(gleader_id) references cu_group(gleader_id)
)

create sequence cu_group_join_seq;

create table cu_group_board(
   gbno number primary key,
   gbcategory varchar2(50) not null,
   gbtitle varchar2(50) not null,
   gbcontent clob not null,
   gbdate date not null,
   gbhits number not null,
   id varchar2(50) not null,
   gleader_id varchar2(50) not null,
   ref number not null,
   restep number not null,
   relevel number not null,
   parent number default 1 not null,
   foreign key(id) references cu_member(id),
   foreign key(gleader_id) references cu_group(gleader_id)
)

drop table cu_group_board;
create sequence cu_group_board_seq;

create table cu_keyword_frequency(
   keyword varchar2(50) primary key,
   count number not null
)


create table cu_delete_member(
   id varchar2(50) primary key,
   password varchar2(50) not null,
   name varchar2(50) not null,
    location varchar2(50) not null,
    tel varchar2(50) not null,
    gender varchar2(50) not null,
    birthdate date not null
)


create table cu_delete_group(
   gleader_id varchar2(50) primary key,
   gname varchar2(50) not null,
   gsubject varchar2(50) not null,      
   ginfo varchar2(50) not null,
   gmember_count number not null,
   glocation varchar2(50) not null,
   gdate date not null,
   foreign key(gsubject) references cu_subject_category(subject),
   foreign key(glocation) references cu_study_location(glocation)
)


create table cu_cart_frequency(
   gleader_id varchar2(50) primary key,
   count number not null
)


create table cu_search_count(
   count number not null
)

insert into cu_search_count values(0);

create table cu_total_visitor(
   count number not null
)

insert into cu_total_visitor values(0);

create table cu_leave_reason(
   no number primary key,
   reason varchar2(200) not null,
   detailreason clob not null
)


create sequence cu_leave_reason_seq;
