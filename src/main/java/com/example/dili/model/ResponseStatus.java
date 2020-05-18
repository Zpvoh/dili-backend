package com.example.dili.model;

public class ResponseStatus {
    private boolean isSucceed;
    private String message;

    public ResponseStatus() {
    }

    public ResponseStatus(boolean isSucceed, String message) {
        this.isSucceed = isSucceed;
        this.message = message;
    }

    public boolean isSucceed() {
        return isSucceed;
    }

    public void setSucceed(boolean succeed) {
        isSucceed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
