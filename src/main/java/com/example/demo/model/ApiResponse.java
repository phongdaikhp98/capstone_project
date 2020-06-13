package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = -7823237036077824442L;
    public int message;
    public Object body;

    public static ApiResponse success(Object body) {
        ApiResponse response = new ApiResponse();
        response.setMessage(0);
        response.setBody(body);
        return response;
    }

    public static ApiResponse fail(String body) {
        ApiResponse response = new ApiResponse();
        response.setMessage(1);
        response.setBody(body);
        return response;
    }
}
