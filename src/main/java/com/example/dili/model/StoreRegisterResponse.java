package com.example.dili.model;

public class StoreRegisterResponse {
    private int id;
    private ResponseStatus status;

    public StoreRegisterResponse() {
    }

    public StoreRegisterResponse(int id, ResponseStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
