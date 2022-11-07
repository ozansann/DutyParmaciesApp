package com.od.dutyparmaciesapp.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultModel<T> {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("systemTime")
    @Expose
    private Integer systemTime;
    @SerializedName("rowCount")
    @Expose
    private Integer rowCount;
    @SerializedName("data")
    @Expose
    private T data = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getSystemTime() {
        return systemTime;
    }

    public void setSystemTime(Integer systemTime) {
        this.systemTime = systemTime;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
