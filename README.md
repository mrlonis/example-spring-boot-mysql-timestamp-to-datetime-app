# example-spring-boot-mysql-timestamp-to-datetime-app

## Table of Contents

<!-- TOC -->
* [example-spring-boot-mysql-timestamp-to-datetime-app](#example-spring-boot-mysql-timestamp-to-datetime-app)
  * [Table of Contents](#table-of-contents)
  * [Description](#description)
  * [Motivation](#motivation)

<!-- TOC -->

## Description

This is a simple Spring Boot application that demonstrates how to convert a MySQL `TIMESTAMP` column to a MySQL
`DATETIME` column. This is done on two identical tables, but with different Java data types for the datetime columns.

For [TestEntity1](./src/main/java/com/mrlonis/time/entity/TestEntity1.java), the `createdAt` and `updatedAt` fields are
of type `java.sql.Timestamp`.

For [TestEntity2](./src/main/java/com/mrlonis/time/entity/TestEntity2.java), the `createdAt` and `updatedAt` fields are
of type `java.time.ZonedDateTime`.

What is interesting to note, is that regardless of the underlying MySQL column type, the Java data type used in the
Spring Boot application is the same. This is because the MySQL JDBC driver handles the conversion between the two
data types.

## Motivation

The motivation for this project is to demonstrate how to convert a MySQL `TIMESTAMP` column to a MySQL `DATETIME` to
avoid the MySQL `TIMESTAMP` column type's limitation of only being able to store dates in the range of
`1970-01-01 00:00:01 UTC` to `2038-01-19 03:14:07 UTC`.

This is a problem for applications that need to store dates outside of this range, such as historical data or future
dates. The `DATETIME` column type does not have this limitation and can store dates from `1000-01-01 00:00:00` to
`9999-12-31 23:59:59`.
