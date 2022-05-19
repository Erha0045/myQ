package com.hovedopgave.myq.Entities;

import javax.persistence.*;

@Entity
//@Table(name = "time_resolution", schema = "public")
//following line is for postgreSql
@Table(name = "time_resolution", schema = "polygon")
public class TimeResolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String format;

    public TimeResolution( String name, long id) {
        this.id = id;
        this.name = name;
    }

    public TimeResolution() {

    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "TimeResolution{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
