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
