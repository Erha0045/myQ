package com.hovedopgave.myq.Entities;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "climate_data_task",schema = "polygon")
public class QueTask {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long parameter_id;

    private ZonedDateTime from_date;
    private ZonedDateTime to_date;
    private int valuetype;
    private int num_tries;
    private int status;
    private String username;
    private String userlocation;
    private Long depends_on;
    private String progress;

    public QueTask() {
    }

    public QueTask(long parameter_id, ZonedDateTime from_date, ZonedDateTime to_date, int valuetype, int num_tries,
                   int status, String username, String userlocation, Long depends_on, String progress) {
        this.parameter_id = parameter_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.valuetype = valuetype;
        this.num_tries = num_tries;
        this.status = status;
        this.username = username;
        this.userlocation = userlocation;
        this.depends_on = depends_on;
        this.progress = progress;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParameter_id() {
        return parameter_id;
    }

    public void setParameter_id(long parameter_id) {
        this.parameter_id = parameter_id;
    }

    public ZonedDateTime getFrom_date() {
        return from_date;
    }

    public void setFrom_date(ZonedDateTime from_date) {
        this.from_date = from_date;
    }

    public ZonedDateTime getTo_date() {
        return to_date;
    }

    public void setTo_date(ZonedDateTime to_date) {
        this.to_date = to_date;
    }

    public int getValuetype() {
        return valuetype;
    }

    public void setValuetype(int valuetype) {
        this.valuetype = valuetype;
    }

    public int getNum_tries() {
        return num_tries;
    }

    public void setNum_tries(int num_tries) {
        this.num_tries = num_tries;
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

    public String getUserlocation() {
        return userlocation;
    }

    public void setUserlocation(String userlocation) {
        this.userlocation = userlocation;
    }

    public Long getDepends_on() {
        return depends_on;
    }

    public void setDepends_on(Long depends_on) {
        this.depends_on = depends_on;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "QueTask{" +
                "id=" + id +
                ", parameter_id=" + parameter_id +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", valuetype=" + valuetype +
                ", num_tries=" + num_tries +
                ", status=" + status +
                ", username='" + username + '\'' +
                ", userlocation='" + userlocation + '\'' +
                ", depends_on=" + depends_on +
                ", progress='" + progress + '\'' +
                '}';
    }
}
