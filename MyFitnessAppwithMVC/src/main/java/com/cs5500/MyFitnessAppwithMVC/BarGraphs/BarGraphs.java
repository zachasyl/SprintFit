package com.cs5500.MyFitnessAppwithMVC.BarGraphs;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class represents the data object for the bar graphs page. It is tagged with the Spring
 * Boot @Entity tag, indicating to Spring that this object should be mapped onto our activities
 * table.
 */
@Entity
public class BarGraphs {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String content;

    public BarGraphs() {

    }

    public BarGraphs(String name) {
        this.id = -1;
        this.content = name;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
