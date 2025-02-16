# HIBERNATE
HIBERNATE

## 1. Definition:
Hibernate is an object-relational mapping (ORM) framework for Java applications, facilitating the mapping of Java objects to database tables.

## 2. Main Features:

Automatic Table Creation: Hibernate can automatically create database tables based on Java class definitions.

SQL Generation: Hibernate generates SQL queries automatically, reducing the need for manual query writing.

Caching Mechanism: It supports multiple levels of caching (first-level and second-level) to improve performance.

Transaction Management: Integrates seamlessly with Java Transaction API (JTA) and Java Database Connectivity (JDBC).

Lazy Loading: It supports lazy loading, which improves performance by loading only necessary data.

## 3. Advantages:

Database Independence: Hibernate provides database independence, meaning it can work with any database.

Reduced Boilerplate Code: By handling the creation and execution of SQL queries, it reduces the amount of boilerplate code.

Scalability: Hibernate is scalable and suitable for large-scale applications.

## 4. Core Components:

Configuration: Reads the configuration settings and initializes Hibernate.

SessionFactory: Creates and provides instances of Session.

Session: Manages the connection and provides methods to create, read, update, and delete operations.

Transaction: Manages transactions to ensure data consistency.

## 5. How It Works:

Mappings: Defined in XML files or using annotations, mappings connect Java classes to database tables.

Entity Classes: Java classes annotated to represent database entities.

HQL (Hibernate Query Language): Hibernate's powerful query language similar to SQL but object-oriented.

<br>


<br>

# Folder Structure :


``` bash
HIBERNATE
|-- src
|   |-- main
|       |-- java
|           |-- org.example
|                   |-- Alien.java
|                   |-- Main.java
|    |-- resources
|       |-- hibernate.cfg.xml
|--test
-- target
|   |-- classes
|-- pom.xml


```
# pom.xml

```cs

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>HIBERNATE</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>

        <maven.compiler.source>23</maven.compiler.source>
        <maven.compiler.target>23</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>

    </properties>

    <!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->

    <dependencies> <!-- Write this -->

    <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.7.4</version>
    </dependency>

    <!-- https://mvnrepository.com/artifact/org.hibernate.orm/hibernate-core -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>7.0.0.Beta4</version>
    </dependency>

    </dependencies>

    <!--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->

</project>

```
# Alien.java

```cs
package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// The @Entity annotation specifies that the class is an entity and is mapped to a database table.
@Entity // The @Table annotation specifies the name of the database table to be used for mapping.
@Table(name = "alien_data") // Table name in the database
public class Alien {

    // The @Id annotation specifies the primary key of an entity.
    @Id // The @Column annotation specifies the name of the column in the database table.
    @Column(name = "a_id")  // Column name for the primary key
    private int aid;

    // Column name for the alien name, changing field name to match database column name.
    @Column(name = "a_name") // Column name in the database
    private String aname;

    // No @Column annotation, so this field will be mapped to a column with the same name as the field.
    private String tech;

    // Getter method for aid
    public int getAid() {
        return aid;
    }

    // Setter method for aid
    public void setAid(int aid) {
        this.aid = aid;
    }

    // Getter method for aname
    public String getAname() {
        return aname;
    }

    // Setter method for aname
    public void setAname(String aname) {
        this.aname = aname;
    }

    // Getter method for tech
    public String getTech() {
        return tech;
    }

    // Setter method for tech
    public void setTech(String tech) {
        this.tech = tech;
    }

    // Overriding the toString() method to display Alien object details
    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}


```
# Main.java

```cs
package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        Alien a1 = new Alien();
        a1.setAid(105);
        a1.setAname("Soumik");
        a1.setTech("JAVA");

        SessionFactory factory = new Configuration().addAnnotatedClass(Alien.class).configure().buildSessionFactory();
        Session session = factory.openSession();

        // Transaction to create an entry
        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();

        // Commented out: Update operation
        /*
        Transaction transactionUpdate = session.beginTransaction();
        a1.setAname("Updated Name");
        session.update(a1);
        transactionUpdate.commit();
        */

        // Commented out: Delete operation
        /*
        Transaction transactionDelete = session.beginTransaction();
        session.delete(a1);
        transactionDelete.commit();
        */

        // Commented out: Read operation
        /*
        Transaction transactionRead = session.beginTransaction();
        Alien retrievedAlien = session.get(Alien.class, 104);
        System.out.println(retrievedAlien);
        transactionRead.commit();
        */

        session.close();
        factory.close();
    }
}



```

# hibernate.cfg.xml

```cs
<hibernate-configuration xmlns="http://www.hibernate.org/xsd/orm/cfg">
    <session-factory>
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/hndatabase</property>
        <property name="hibernate.connection.username">postgres</property>
        <property name="hibernate.connection.password">123</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.show_sql">true</property>

    </session-factory>
</hibernate-configuration>
```

