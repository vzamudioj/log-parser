log-parser
Tool that can parse and load the given log file to MySQL

The goal is to write a parser in Java that parses web server access log file, loads the log to MySQL and checks if a given IP makes more than a certain number of requests for the given duration.

Java
Create a java tool that can parse and load the given log file to MySQL. The delimiter of the log file is pipe (|)
(2) The tool takes "startDate", "duration" and "threshold" as command line arguments. "startDate" is of "yyyy-MM-dd.HH:mm:ss" format, "duration" can take only "hourly", "daily" as inputs and "threshold" can be an integer.

(3) This is how the tool works:

java -cp "parser.jar" com.ef.Parser --startDate=2017-01-01.13:00:00 --duration=hourly --threshold=100

The tool will find any IPs that made more than 100 requests starting from 2017-01-01.13:00:00 to 2017-01-01.14:00:00 (one hour) and print them to console AND also load them to another MySQL table with comments on why it's blocked.

java -cp "parser.jar" com.ef.Parser --startDate=2017-01-01.13:00:00 --duration=daily --threshold=250

The tool will find any IPs that made more than 250 requests starting from 2017-01-01.13:00:00 to 2017-01-02.13:00:00 (24 hours) and print them to console AND also load them to another MySQL table with comments on why it's blocked.
Deliverables
1- Java program that can be run from command line

Provided by Github

In order to run type the following command:

java -jar target/parser-0.0.1-SNAPSHOT.jar --startDate=yyyy-MM-dd.HH:mm:ss --duration=hourly/daily --threshold=integer

Example: java -jar target/parser-0.0.1-SNAPSHOT.jar --startDate=2017-01-01.13:00:00 --duration=daily --threshold=250

2- Source Code for the Java program

Provided by git

3- MySQL schema used for the log data

In Log- schema.sql file in root directory

4- SQL queries for SQL test

In root directory

QryLogsExample1.sql

QryLogsExample1.sql

QryCommentsExample1.sql

QryCommentsExample2.sql
