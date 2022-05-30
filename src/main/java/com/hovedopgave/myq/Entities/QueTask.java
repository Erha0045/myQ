package com.hovedopgave.myq.Entities;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
//@Table(name = "climate_data_task",schema = "public")
//following line is for postgreSql
@Table(name = "climate_data_task",schema = "polygon")
public class QueTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parameter_id")
    private Parameter parameter;

    @Column(name = "from_date")
    private ZonedDateTime fromDate;
    @Column(name = "to_date")
    private ZonedDateTime toDate;
    @Column(name = "valuetype")
    private int valueType;
    @Column(name = "num_tries")
    private int numTries;
    private int status;
    private String username;
    @Column(name = "userlocation")
    private String userLocation;
    @Column(name = "depends_on")
    private Long dependsOn;
    private String progress;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ZonedDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(ZonedDateTime from_date) {
        this.fromDate = from_date;
    }

    public ZonedDateTime getToDate() {
        return toDate;
    }

    public void setToDate(ZonedDateTime to_date) {
        this.toDate = to_date;
    }

    public int getValueType() {
        return valueType;
    }

    public void setValueType(int valuetype) {
        this.valueType = valuetype;
    }

    public int getNumTries() {
        return numTries;
    }

    public void setNumTries(int num_tries) {
        this.numTries = num_tries;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userlocation) {
        this.userLocation = userlocation;
    }

    public Long getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(Long depends_on) {
        this.dependsOn = depends_on;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameterId) {
        this.parameter = parameterId;
    }
}
