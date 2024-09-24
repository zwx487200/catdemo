package com.example.catdemo.utils;

import lombok.Data;

/**
 * @author jennyzhuzhu
 */
@Data
public class Response {
    String code;
    String message;
    Object data;
    long count;

    public Response(String code, String message, Object data, long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public Response(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response() {

    }

    public static Response noDateSuccess() {
        return new Response("0", "Success");
    }

    public static Response success(Object data) {
        return new Response("0", "Success", data);
    }

    public static Response success(Object data, long count) {
        return new Response("0", "Success", data, count);
    }

    public static Response error(String code, String message) {
        return new Response(code, message, null);
    }
}
