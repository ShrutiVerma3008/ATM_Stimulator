show databases;
create database bankmanagementsystem;
 use bankmanagementsystem;
 show tables;
 create table signup(formNo varchar(20), N_ame varchar(20),Father_name varchar(20),dob varchar(20),gender varchar(20),email varchar(30),marital_status varchar(20),address varchar(50),city varchar(30),state varchar(30),pincode varchar(20
));
show tables;
show databases;
create table signuptwo(formNo varchar(20),Religion varchar(20),category varchar(20),income varchar(20),qualification varchar(20),occupation varchar(30),senior_citizen varchar(20),existingacc varchar(50),pan varchar(30),aadhar varchar(30));
use bankmanagementsystem;
create table signupthree(formNo varchar(20),account_type varchar(40),card_num varchar(20),pin varchar(20),facility varchar(200));
create table login(formno varchar(20),cardnumber varchar(25), pin varchar(20));
create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));
drop table bank;
select * from bank;
select * from bank;
select * from login;
