## Spring-boot annotations.
### What Is Spring Boot and What Are Its Main Features?
It's a Framework build on top of Spring Framework with autoconfiguration and embedded application server support.

### How to Disable a Specific Auto-Configuration?
// other annotations
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }<br>
OR<br>
// other annotations
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
<br>

### How to Register a Custom Auto-Configuration?
To register an auto-configuration class, we must have its fully qualified name listed under the EnableAutoConfiguration key in the META-INF/spring.factories file:
<br>
```
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.baeldung.autoconfigure.CustomAutoConfiguration
```

### What Are Possible Sources of External Configuration?
Spring Boot provides support for external configuration, allowing us to run the same application in various environments. We can use properties files, YAML files, environment variables, system properties and command-line option arguments to specify configuration properties.
<br>
We can then gain access to those properties using the @Value annotation, a bound object via the @ConfigurationProperties annotation, or the Environment abstraction.
### Q12. What Does It Mean That Spring Boot Supports Relaxed Binding?
Relaxed binding in Spring Boot is applicable to the type-safe binding of configuration properties.
With relaxed binding, the key of a property doesn't need to be an exact match of a property name. Such an environment property can be written in camelCase, kebab-case, snake_case, or in uppercase with words separated by underscores.
For example, if a property in a bean class with the @ConfigurationProperties annotation is named myProp, it can be bound to any of these environment properties: myProp, my-prop, my_prop, or MY_PROP.

### SpringBoot Annotations. 
1. @SpringBootApplication (No need to add by default  these will be covered @Configuration, @ComponentScan, and @EnableAutoConfiguration.)
2. @Configuration
3. @ComponentScan
4. @EnableAutoConfiguration

5. @GetMapping
6. @RequestMapping
7. @RequestParam

8. @Component
9. @Service
10. @Repository
11. @Controller
12. @RestController

13. @SpringBootTest
14. @MockBean
15. @Validated

## Java Performance - Memory and Runtime Analysis
1. How Java use the heap and the stack
2. Performance factors:
   Important influence factors to the performance of a Java program can be separated into two main parts:<br>
   1. Memory Consumption of the Java program<br>
   2. Total runtime of a program<br>
### Memory handling in Java<br>
 ### Native Memory:<br>
   Native memory is the memory which is available to a process, e.g. the Java process. Native memory is controlled by the operating system (OS) and based on physical memory and other physical devices, e.g. disks, flash memory, etc.

##JProfiler

##JMeter

##DataDogs



### What is VisualVM?
It allows you to trace a running Java program and see its the memory and CPU consumption. You can also use it to create a memory heap dump to analyze the objects in the heap.


### MySQL Related stuff
MySql Database Triggers: SQL statement that are automatically Run when a specific table is changes
### Syntax
```
CREATE TRIGGER trigger_name 
    trigger_time trigger_event ON table_name FOR EACH ROW
    BEGIN
    ...
    END;
    
#Explanation   
1.trigger_time  
BEFORE
AFTER

2.trigger_event 
INSERT
UPDATE
DELETE

3.table_name
photos
users 
```
### Example
```
DELIMITER $$
CREATE TRIGGER must_be_adult
     BEFORE INSERT ON users FOR EACH ROW
     BEGIN
          IF NEW.age < 18
          THEN
              SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Must be an adult!';
          END IF;
     END;
$$
DELIMITER ;
```
### Example 2
### Step 1. create employee table
```
create table employees(
 firstname varchar(100),
 lastName varchar(100),
 employeeNumber int
);
```
### Step 2. Insert record in employee table
```
insert into employees(firstname, lastName, employeeNumber) value("Rahul", "Kumar", 1056);
```

### Step 3. Create new table employees_audit to hold the audit details
```
CREATE TABLE employees_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);
```
### Step 4. Create trigger to add entry for every update happen on employee table
```
CREATE TRIGGER before_employee_update 
    BEFORE UPDATE ON employees
    FOR EACH ROW 
 INSERT INTO employees_audit
 SET action = 'update',
     employeeNumber = OLD.employeeNumber,
     lastname = OLD.lastname,
     changedat = NOW();
 ```
### To see the trigger entry
```
 SHOW TRIGGERS;
```

### Update the employee record
```
UPDATE employees 
SET 
  firstname='Aman',  lastname = 'Phan'
WHERE employeeNumber = 1056;
```
### you will see record in employees_audit table
```
SELECT * FROM employees_audit;
```


### MySQL Error Codes
1. <div style="color:green"><i><b>1175</b></i></div>
I tried to updated row using workbench, Got this error code.
### Solution
a.Go to Edit --> Preferences<br>
b. Click "SQL Editor" tab and uncheck "Safe Updates" check box<br>
c. Query --> Reconnect to Server // logout and then login<br>
d. Now execute your SQL query<br>

### What is Latency?
Latency is a synonym for delay. In telecommunications, low latency is associated with a positive user experience (UX) while high latency is associated with poor UX. In computer networking, latency is an expression of how much time it takes for a data packet to travel from one designated point to another.

### What is Scalability?
Scalability is the ability for IT systems – such as applications, storage, databases and networking – to continue to function properly when changed in size or volume. It often refers to increasing or decreasing resources as needed to meet the higher or lower demands of a business.
### 1. Vertical (scale-up) scalability
Increases the capacity of hardware or software by adding resources to a physical system, such as adding processing power to a server to make it faster

### 2. Horizontal (scale-out) scalability
Connects multiple items in order to work as a single logical unit.

### Multi-Tenant Architecture(Multi-tenancy)
In multi-tenant software architecture—also called software multitenancy—a single instance of a software application (and its underlying database and hardware) serves multiple tenants (or user accounts). A tenant can be an individual user, but more frequently, it’s a group of users—such as a customer organization—that shares common access to and privileges within the application instance. Each tenant’s data is isolated from, and invisible to, the other tenants sharing the application instance, ensuring data security and privacy for all tenants

Multi-tenant architecture, more commonly referred to as multi-tenancy, is a software architecture where multiple instances of an application run on the same physical serve
https://www.datamation.com/cloud/what-is-multi-tenant-architecture

#### Types Of Multi-Tenant Databases
1.  Shared Database, Shared Schema
2. Shared Database, Multiple Schemas
3. Multiple Databases, Multiple Schemas



### N+1 problem in Hibernate & Spring Data JPA
N+1 problem is a performance issue in Object Relational Mapping that fires multiple select queries (N+1 to be exact, where N = number of records in table) in database for a single select query at application layer. Hibernate & Spring Data JPA provides multiple ways to catch and address this performance problem.

### N+1 Resolution(Spring Data JPA Approach)
```
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAllBy();   //1         

    @Query("SELECT p FROM User p LEFT JOIN FETCH p.roles")  // 2
    List<User> findWithoutNPlusOne();

    @EntityGraph(attributePaths = {"roles"})                //3 
    List<User> findAll();
}

1. N+1 queries are issued at database level
2. using left join fetch, we resolve the N+1 problem
3. using attributePaths, Spring Data JPA avoids N+1 problem

```

### Logging in Spring Boot
Logback is used for logging by default. Spring Boot preconfigures it with patterns and ANSI colors to make the standard output more readable.

### Log4j2 Configuration Logging
While Apache Commons Logging is at the core, and Logback is the reference implementation provided.<br>

NOTE In order to use any logging library other than Logback, though, we need to exclude it from our dependencies.

```<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```

### Important terms
1. Infrastructure-as-a-service (IaaS)
2. Platform-as-a-service (PaaS)
3. Software-As -a-service a(SaaS)



### Troubleshoot Production performance issue in Web application
1. Does you application uses load balancer>
2. Check all Instances of JVMs are up and running?
3. Is there any network latency issue?
4. Is there any recent deployment?
5. Monitor memory and CPU utilization?
6. Identify any deadlocks and memory leaks in application usih JConsole(In case of Java) or any other tool.
7. Identify which part of functionality experience the latency.
8. measure the latency either from transaction log or from the browser dev tool.
9. if application logs maintain properly then we can identify which part of code causing the latency.
10. If latency issue due to SQL queries then we can troubleshoot using the explain  plan for the queries and need optimize queries.
11. if latency issue due to code then nees to rewrite and optimized the latency.


Check in browser dev tool and see, cross browser(Browser engine).<br>
Check UI logs(Traansection logs and try toidentify) if not available then see network tab and identify the time taken in request and response.<br>
Case 1 if latency problem in API calls<br>
Then check network and identify network latency<br>
How? Ping the systm and validated MIN MAX and AVG.<br>
Case 2 No Latency issue in API response<br>
Request and Response work as aspected.<br>
Then the issue FE, in this case we can check in other browser to verify if engine issue.<br>
otherwise will check with UI person, here problem can be lib issue, Business log, loading(Eager,Lazy),
Paginnation, Ineasted of loading whole data in we can plan other ways.

### Troubleshoot production issue
1. If production application is slow/some of the functionality does not work or down
   Then
2. When the user submit the form server responds with HTTP error code with 500 series
3. When user reported issue for production, ther will be ticket JIRA/BUGZilla/Rally/TRello/
   which contains issue details, impact, priorit and severity and there will be SLA for this
4. First step to identify the logs for your application, Some of the application recordeach and every transaction you have to verify in your application itself
   If log are not available in app then you must be connect to application server using putty/WINSCP and collect the logs, if your application using loadbalancer then need to collect logs of instance
   5 From the logs developer will be able to find the stack trace for 500 code and identify the life code  where axcetly issue occured

### How to detect/avoid DeadLock and handle deadlocks in Java application

Here I have code with deadlock issue
```
package com.ext.prep.deadlock;

public class ThreadDemo {

    public static void main(String[] args) {
        final Object resource1 = "Resource-1";
        final Object resource2 = "Resuorce-1";

        Thread thread1 = new Thread(()->{

            synchronized (resource1){
                System.out.println("Thread 1 locked resource1 ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println("Thread 1 locked resource2 ");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (resource2){
                System.out.println("Thread 2 locked resource2 ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1){
                    System.out.println("Thread 2 locked resource1 ");
                }
            }
        });

        thread1.setName("Helper-1");
        thread2.setName("Helper-1");

        thread1.start();
        thread2.start();
    }
}
```
Step 1: Run Application.
Step 2: Go to XXXX\Java\jdk-17.0.5\bin
Step 3: Run Jconsole and select Local with you application name.
Step 4: CLick on Thread tab from Menu.
will see the all your running thread and click one by one and check the deadlock cause.

### Solution:
In this case you can just change the order in same manner
```
package com.ext.prep.deadlock;

public class ThreadDemo {

    public static void main(String[] args) {
        final Object resource1 = "Resource-1";
        final Object resource2 = "Resuorce-1";

        Thread thread1 = new Thread(()->{

            synchronized (resource1){
                System.out.println("Thread 1 locked resource 1 ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println("Thread 1 locked resource 2 ");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (resource1){
                System.out.println("Thread 2 locked resource 1 ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println("Thread 2 locked resource 2 ");
                }
            }
        });

        thread1.setName("Helper-1");
        thread2.setName("Helper-1");

        thread1.start();
        thread2.start();
    }
}
```
### Memory Management in Java & Garbage Collection


### Security vulnerabilities in java based applications
Below are the security vulnerabilities aften found in java based applications and will have high impact and severity on the application reliability.
1. SQL Injection
2. Unclosed resource/Memory leaks
3. Direct Traversal attack/Malicious file upload
4. Cross site Scripting
5. Password Management(Logging, Hard coding,weak password)
6. Poor Logging
7. Improper Exception Handling
8. improper validation on user Input

1. SQL Injection:
```
String query = "Select * from employee where empId= "+empId + " and empName='"+empName+"'";
case 1. empName=atish' or 1='1;
case 2. empName='';DROM table user'
```   
2. Unclosed resource/Memory leaks
####  Section Code quality-point 11

## Code quality
0 Left shift strategy
1. Avoid String Concat.
2. Avoid Multiple returns statements.
3. Follow proper Java conventions for Method, Variable, Class, Interface, and Constant names.
4. Peer review/Code review.
5. Add build checks in Git/Bitbucket.
6. Proper Unit testing/edge cases try to cover,
7. Code coverage and run report should be attached before PR Review.
8. SonarCube and SonarLint should be executed and the report attached before PR placed
9. Security check should be checked and the report attached(Snyk, OWASP)
10. Code should be loosely coupled/there must be a proper abstraction.
11. Prefer autoclosble featuer to avoid memory leaks (Use try-reource) mitigate the risk
```
public class FileConnect implements AutoCloseable{

    public void show(){
        System.out.println("Hello");
    }
    @Override
    public void close() throws Exception {
        System.out.println("I will close my self dont take bother");
    }
}

public class AutoClosableDemo {

    public static void main(String[] args)  {
        try (FileConnect fileConnect = new FileConnect()){
            fileConnect.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 ```
12. Ceanup code in each commit.
13. Dont forget commenting method level, class level.
14. Use logging properly
15. Method should be small, Unit test cases writen in such manner, the reviewer can understand in 30-60Sec.
### Principles:
1.  You Ain’t Gonna Need It (YAGNI): - Don’t implement features that may be needed in the future, they are expensive, time-consuming, and probably will be a waste of resources
2. Don’t Repeat Yourself (DRY): The modification of an element doesn’t require a change in any other logically unrelated elements in a system
3. Keep It Simple, Stupid (KISS): The simpler your code is, the more maintainable it will be in the future. Avoid fancy features and unnecessary complexity, use them only if they have huge benefits for the design.
4. SOLID Design Principles
   a. S — Single responsibility principle
   b. O — Open/closed principle
   c. L — Liskov substitution
   d. I — The interface segregation principle
   e. D – The dependency inversion principle  
   https://incora.software/insights/clean-code-principles
   

# Spring-boot Batch processing

1. Job and Step
2. Job Types
   a. TaskLet step(Like Reading from some other, Send email/push notification, etc)
   b. Chunk oriented step(Reading data from CSV having millions of record)
   
### Example:
#### CSV(Item reader)===>SpringBoot Batch(Item Processor)
#### SpringBoot Batch(Item Processor)====>(Item writer)MYSQL


# SpringBoot Architecture      

### Contexts
1. Job level context
2. Step level Context

## Cron Expression
http://www.cronmaker.com/;jsessionid=node016kv76p1fyu071kyk4f5alwz3j169137.node0?0

### Microservice:
1. What is microservices architecture and how it is different from monolithic and SOA architectures.
2. How to build production ready microservices using  Spring, SpringBoot and Spring Cloud.
3. What are cloud native apps & 12 factor principles behind them.
4. Configuration management in microservices using <b>Spring Cloud Config Server</b>.
5. <b> Service Discovery and Registration </b> pattern inside microservices and how to implement using <b>Spring Eureka server</b>.
6. Building resilient microservices using <b>RESILIENCE4J</b> framework.
7. Handling Cross cutting concerns and routing inside microservices using <b>Spring Cloud Gateway</b>.
8. Implementing <b>Distributed tracing & Log</b> aggregation in microservices using <b>Spring Sleuth and Zipkin</b>.
9. Monitoring microservices using Prometheus and Grafana.
10. Role of Docker in microservices and how to build docker images, containers.
11. Role of Docker compose and how to use it to run all the microservices inside a application.
12. Most commonly used Docker commands.
13. Role of Kubernetes in microservices as a <b>container orchestration framework</b>.
14. How to setup a Kubernetes cluster inside GCP using GKE (Google Kubernetes Engine) and deploy microservices inside it.
15. Most commonly used Kubernetes commands.
16. Microservices Security using OAuth2.
17. What is Helm & it's role in microservices world.

Note: ribbon is no under maintainace mode, no further support
