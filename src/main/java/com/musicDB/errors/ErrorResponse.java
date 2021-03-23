package com.musicDB.errors;

import java.util.Date;

public class ErrorResponse {

    private String message;
    private long timeStamp;

    public ErrorResponse() {
        this.timeStamp = (new Date()).getTime();
    }

    public ErrorResponse(String message) {
        this.message = message;
        this.timeStamp = (new Date()).getTime();
    }

    public ErrorResponse(String message, long timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
