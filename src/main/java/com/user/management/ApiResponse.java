package com.user.management;

import lombok.Data;

@Data // getters/setters, toString, hashcode
//@NoArgsConstructor
//@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ApiResponse(){}
}
// T represents any type of data type