package com.hovedopgave.myq.model;

public class QueTaskRequest {

    private String fromDate;
    private String toDate;
    private Long parameterId;
    private Long valueType;
    private String fullDate;

    public String getFullDate() {
        return fullDate;
    }

    public void setFullDate(String fullDate) {
        this.fullDate = fullDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getValueType() {
        return valueType;
    }

    public void setValueType(Long valueType) {
        this.valueType = valueType;
    }
}
