. The application is a simple Springboot rest api application for allowing a client to make CRUD operations on a list of 
employees. The code is written by using Chad Darby's Udemy course on Spring framework (https://www.udemy.com/spring-hibernate-tutorial/)

. A Mysql DB and workbench should be installed to the local machine which the application is going to run. (MySQL can be 
downlaoded from http://dev.mysql.com/downloads)

. Open MySql workbench and run these two scripts respectively; 
    01-create-user.sql, 
    02-employee-directory.sql

These scripts would create a db user called springstudent, create the DB schema called employee_directory 
create a Employee table and populate the Employee table.

. Open the source code for the appropriate version

. Run the application: 

    a. Select the root project folder
    
    b. SpringbootCrudDemoApplication.java
    
    c. If you have Postman installed, you may make the following HTTP requests (Do not forget to enter the credentials as
    susan, test123 in the authorization tab); 
   
   
    GET http://localhost:8080/springboot-crud-demo/api/employees (Selects all employees)
    GET http://localhost:8080/springboot-crud-demo/api/employees/1 (Select the employee  with having the id 1)
    POST http://localhost:8080/springboot-crud-demo/api/employees (Insert a new employee)
   
    Body;
   
    {
   	  "id":0,
      "firstName": "Gorkem",
      "lastName": "Turan",
      "email": "gorkem@luv2code.com"
    }
   
    PUT http://localhost:8080/springboot-crud-demo/api/employees (Update the customer with having the id 6)
      
    Body;
    
    {
      "id":6,
      "firstName": "Gorkem",
      "lastName": "Turan",
      "email": "gorkem.turan@luv2code.com"
    }
    
    DELETE http://localhost:8080/springboot-crud-demo/api/employees/6 (Delete the customer with the id 6)


