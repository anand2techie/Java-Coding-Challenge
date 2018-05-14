# Java-Coding-Challenge
This is a repository containing coding challenge solved

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.ad.reporting.ReportingApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Launching the application
After application started, navigate to localhost:8080/reports to view the metrics data and pass request param if needed like: 
```
localhost:8080/reports?month=1&site=iOS
localhost:8080/reports?month=1 for aggregate report
localhost:8080/reports?site=iOS for aggregate report



