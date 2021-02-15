drop table if exists employee cascade; 
drop table if exists department cascade; 
drop table if exists project cascade; 
drop table if exists employee_project_mapping cascade;

create table employee 
(
 employee_number  serial   not null
 ,job_title    character varying(22) not null
 ,last_name   character varying(40) not null
 ,first_name  character varying(10) not null 
 ,gender      character varying(10) not null 
 ,date_of_birth  date               not null
 ,date_of_hire   date               not null
 ,department_number integer       not null
 ,constraint pk_employee_employee_number PRIMARY KEY(employee_number)
 )
 ;
 
 create table department 
 (
 department_number    serial     not null
 ,name                character varying(20)  not null
 ,number_of_employees  int            
 ,constraint pk_department_department_number PRIMARY KEY(department_number)
 )
 ;
  
 create table project
 (
 project_number          serial  not null
 ,name             character varying(50)  not null
 ,start_date       date           not null
 --,number_of_employees   int       not null
 ,constraint pk_project_project_number PRIMARY KEY(project_number)
 )
 ;
  create table employee_project_mapping
 (
 employee_number   int   not null
 ,project_number   int   not null
 )
 ;
 
 
 ALTER TABLE employee
    ADD FOREIGN KEY(department_number)
    REFERENCES department(department_number)
    ;
    
  ALTER TABLE employee_project_mapping
  ADD FOREIGN KEY(employee_number)
  REFERENCES employee(employee_number)
  ;
   
 ALTER TABLE  employee_project_mapping
   ADD FOREIGN KEY(project_number)
   REFERENCES project(project_number)
   ;
   
insert into department
(name)
values('Instructors')
;
insert into department
(name)
values('Marketing')
;
insert into department
(name)
values('Sales')
;  
 
insert into project
(name, start_date)
values('Module 1', '01/11/2021')
;
insert into project
(name, start_date)
values('Module 2', '02/11/2021')
;
insert into project
(name, start_date)
values('Module 3', '03/11/2021')
;
insert into project
(name, start_date)
values('Capstone', '04/11/2021')
;
   
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Senior Developer', 'Fella', 'Frank', 'Male', '02/14/1965', '02/15/2021', 1)
;
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Junior Developer', 'Howie', 'Jason', 'Male', '02/15/1990', '01,01,2021', 2)
;
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Marketing', 'Edison', 'Annie', 'female', '05/15/1989', '01,01,2021', 2)
;
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Marketing', 'Barnes', 'Troy', 'Male', '02/10/1993', '01,01,2021', 2)
;
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Sales', 'Winger', 'Jeff', 'Male', '02/15/1986', '01,01,2021', 2)
;
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Marketing Lead', 'Nadir', 'Abed', 'Male', '07/15/1990', '01,01,2021', 2)
;
insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Junior Developer', 'Perry', 'Britta', 'Female', '02/15/1986', '01,01,2021', 2)
;

insert into employee
(job_title, last_name, first_name, gender, date_of_birth, date_of_hire, department_number)
values('Sales', 'Hawthorne', 'Pierce', 'Male', '03/16/1979', '01,01,2021', 2)
;

insert into employee_project_mapping
(employee_number, project_number)
values((select employee_number from employee where first_name = 'Jeff'),(select project_number from project where name = 'Module 1'))
;

insert into employee_project_mapping
(employee_number, project_number)
values((select employee_number from employee where first_name = 'Annie'),(select project_number from project where name = 'Module 2'))
;

insert into employee_project_mapping
(employee_number, project_number)
values((select employee_number from employee where first_name = 'Britta'),(select project_number from project where name = 'Module 3'))
;

insert into employee_project_mapping
(employee_number, project_number)
values((select employee_number from employee where first_name = 'Troy'),(select project_number from project where name = 'Capstone'))
;


select * from employee;
select * from project;
select * from department;
select * from employee_project_mapping;
