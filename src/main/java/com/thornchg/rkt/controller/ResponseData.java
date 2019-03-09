package com.thornchg.rkt.controller;

import lombok.Data;

@Data
public class ResponseData {
    private int status;
    private String msg;
    private Object Data;

    public ResponseData(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        Data = data;
    }
}
