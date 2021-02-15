drop table if exists employee cascade; 
drop table if exists department cascade; 
drop table if exists project cascade; 
drop table if exists employee_project_mapping cascade;

create table employee 
(
 employee_number  serial   not null
 ,job_title    character varying(20) not null
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
   
