




# User-Manager 
### Rest APIs with JWT based authentication/authorization

[![Spring_Boot Framework](https://img.shields.io/badge/Springboot-2.3.3.RELEASE_Framework-blue.svg?style=plastic)](https://start.spring.io/) |[![Java](https://img.shields.io/badge/Java-1.8-blue.svg?style=plastic)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) | ![GitHub language count](https://img.shields.io/github/languages/count/BinayTripathi/UserManager.svg) | ![GitHub top language](https://img.shields.io/github/languages/top/BinayTripathi/UserManager.svg) |![GitHub repo size in bytes](https://img.shields.io/github/repo-size/BinayTripathi/UserManager.svg) 
| --- | ---          | ---        | ---      | ---        | 

---------------------------------------

## Repository code base
 
The repository consists of projects as below:


| # |Project Name | Project detail| Environment |
| ---| ---  | ---            | --- |
| 1 | UserManager| UserManager with JWT authentication   | [![.SpringBoot framework](https://img.shields.io/badge/Springboot-2.2.6.RELEASE_Framework-blue.svg?style=plastic)](https://start.spring.io/)|

### Summary

The overall objective of the applications :

>   A web-aware UserManagementSystem

>   Rest APIs authentication/authorization based on JWT token

>   Production-ready code with loosely coupled highly maintainable design.



### Setup detail

##### Environment Setup detail

> Download/install   	
>	1.	[![Maven](https://img.shields.io/badge/Mavan-3.6.3-blue.svg?style=plastic)](https://maven.apache.org/download.cgi) to build project and run test suite
>   
>   2.  [![Java](https://img.shields.io/badge/Java-1.8_-blue.svg?style=plastic)](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) to run the project
>   
>	3.  [![STS](https://img.shields.io/badge/Spring_Tool_Suite-STS-blue.svg?style=plastic)](https://spring.io/tools) to run/debug the applications
>	

##### Project Setup detail

>   1. Please clone or download the repository from [![github](https://img.shields.io/badge/github-BookNow-blue.svg?style=plastic)](https://github.com/BinayTripathi/UserManager)
>   
#####  To build / run the application

>   1. Open a new command prompt and browse to the root folder ( **UserManager** ) of the application 
>   
>   2. Enter following command to build the project : **mvn clean install** 
>   
>   3. Enter following command to run the project with its default configuration: **java -jar target\UserManager-0.0.1-SNAPSHOT.jar** 
>   
>   4. To check in-memory database (default is h2) browse to **http://localhost:8080/api/h2-console/login.jsp** 

     JDBC url : jdbc:h2:mem:accdet;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE;  
     User id :  test  . 
     No password.

>   
>   5. To test APIs, please import the postman collection available at https://github.com/BinayTripathi/UserManager/tree/main/PostmanCollection 
>   
>   Get *Get JWT Token - Admin* is to get JWT token for admin user and *Get JWT Token - Non-Admin* is for non admin user




##### To open the project in Spring Tool Suite (or Eclipse)
>   1. Open **Spring Tool Suite** .
>   2. Select **File** ->  **Import** and then select **Existing Maven Projects**
>   3. Browse to  **UserManager** select pom.xml and click **Finish** to import the project.
>   4. Run/Debug the project

### Support or Contact

Having any trouble? Please read out this [documentation](https://github.com/BinayTripathi/AccountBrowser/blob/master/README.md) or [contact](mailto:binay.mckv@gmail.com) and to sort it out.


[![HitCount](http://hits.dwyl.com/BinayTripathi/BookNow.svg)](http://hits.dwyl.com/BinayTripathi/BookNow)| ![GitHub contributors](https://img.shields.io/github/contributors/BinayTripathi/AccountBrowser)|
 | --- | --- |




