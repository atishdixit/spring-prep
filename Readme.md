###MySQL Related stuff
MySql Database Triggers: SQL statement that are automatically Run when a specific table is changes
###The Syntax
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
###Example
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
###Example 2
###Step 1. create employee table
```
create table employees(
 firstname varchar(100),
 lastName varchar(100),
 employeeNumber int
);
```
###Step 2. Insert record in employee table
```
insert into employees(firstname, lastName, employeeNumber) value("Rahul", "Kumar", 1056);
```

###Step 3. Create new table employees_audit to hold the audit details
```
CREATE TABLE employees_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employeeNumber INT NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    changedat DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);
```
###Step 4. Create trigger to add entry for every update happen on employee table
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
###To see the trigger entry
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


###MySQL Error Codes
1. <div style="color:green"><i><b>1175</b></i></div>
I tried to updated row using workbench, Got this error code.
###Solution
a.Go to Edit --> Preferences<br>
b. Click "SQL Editor" tab and uncheck "Safe Updates" check box<br>
c. Query --> Reconnect to Server // logout and then login<br>
d. Now execute your SQL query<br>

###What is Latency?
Latency is a synonym for delay. In telecommunications, low latency is associated with a positive user experience (UX) while high latency is associated with poor UX. In computer networking, latency is an expression of how much time it takes for a data packet to travel from one designated point to another.

###What is Scalability?
Scalability is the ability for IT systems – such as applications, storage, databases and networking – to continue to function properly when changed in size or volume. It often refers to increasing or decreasing resources as needed to meet the higher or lower demands of a business.
###1. Vertical (scale-up) scalability
Increases the capacity of hardware or software by adding resources to a physical system, such as adding processing power to a server to make it faster

###2. Horizontal (scale-out) scalability
Connects multiple items in order to work as a single logical unit.

###Multi-Tenant Architecture(Multi-tenancy)
In multi-tenant software architecture—also called software multitenancy—a single instance of a software application (and its underlying database and hardware) serves multiple tenants (or user accounts). A tenant can be an individual user, but more frequently, it’s a group of users—such as a customer organization—that shares common access to and privileges within the application instance. Each tenant’s data is isolated from, and invisible to, the other tenants sharing the application instance, ensuring data security and privacy for all tenants

Multi-tenant architecture, more commonly referred to as multi-tenancy, is a software architecture where multiple instances of an application run on the same physical serve
https://www.datamation.com/cloud/what-is-multi-tenant-architecture

####Types Of Multi-Tenant Databases
1.  Shared Database, Shared Schema
2. Shared Database, Multiple Schemas
3. Multiple Databases, Multiple Schemas



### N+1 problem in Hibernate & Spring Data JPA
N+1 problem is a performance issue in Object Relational Mapping that fires multiple select queries (N+1 to be exact, where N = number of records in table) in database for a single select query at application layer. Hibernate & Spring Data JPA provides multiple ways to catch and address this performance problem.

###N+1 Resolution(Spring Data JPA Approach)
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



###Troubleshoot Production performance issue in Web application
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


Check in browser dev tool and see, cross browser(Browser engine)
Check UI logs(Traansection logs and try toidentify) if not available then see network tab and identify the time taken in request and response.
Case 1 if latency problem in API calls
Then check network and identify network latency
How? Ping the systm and validated MIN MAX and AVG.
Case 2 No Latency issue in API response
Request and Response work as aspected.
Then the issue FE, in this case we can check in other browser to verify if engine issue.
otherwise will check with UI person, here problem can be lib issue, Business log, loading(Eager,Lazy),Paginnation, Ineasted of loading whole data in we can plan other ways.

###Troubleshoot production issue
1. If production application is slow/some of the functionality does not work or down
   Then
2. When the user submit the form server responds with HTTP error code with 500 series
3. When user reported issue for production, ther will be ticket JIRA/BUGZilla/Rally/TRello/
   which contains issue details, impact, priorit and severity and there will be SLA for this
4. First step to identify the logs for your application, Some of the application recordeach and every transaction you have to verify in your application itself
   If log are not available in app then you must be connect to application server using putty/WINSCP and collect the logs, if your application using loadbalancer then need to collect logs of instance
   5 From the logs developer will be able to find the stack trace for 500 code and identify the life code  where axcetly issue occured

###How to detect/avoid DeadLock and handle deadlocks in Java application

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

###Solution:
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
###Memory Management in Java & Garbage Collection


###Security vulnerabilities in java based applications


##Code quality
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
###Principles:
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