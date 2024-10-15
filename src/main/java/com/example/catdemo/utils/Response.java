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
    String token;

    public Response(String code, String message, Object data, long count) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    public Response(String code, String message, Object data, String token) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.token = token;
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

    public static Response success(Object data, String token) {
        return new Response("0", "Success", data, token);
    }


    public static Response error(String code, String message) {
        return new Response(code, message, null);
    }

    public static Response error( String message) {
        return new Response("-1", message, null);
    }

    public static boolean isSuccess(Response response) {
        return "0".equals(response.getCode());
    }
}
