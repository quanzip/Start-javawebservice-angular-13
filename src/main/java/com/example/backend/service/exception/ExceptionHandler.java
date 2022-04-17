package com.example.backend.service.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;

@RestControllerAdvice
@ConditionalOnProperty(value = "period",
        havingValue = "12 years",
        matchIfMissing = true)
public class ExceptionHandler {

    String name = "ExceptionHandler";

    String requireProperty = "period";

    @Value("${server.port:100}")
    int requireValue ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequireProperty() {
        return requireProperty;
    }

    public void setRequireProperty(String requireProperty) {
        this.requireProperty = requireProperty;
    }

    public int getRequireValue() {
        return requireValue;
    }

    public void setRequireValue(int requireValue) {
        this.requireValue = requireValue;
    }

    public ExceptionHandler() {
        System.out.println(this.getClass().getName() + " created because period = 12 years");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(FileNotFoundException.class)
    public String catchException(Exception exception, WebRequest webRequest) {
        System.out.println("Catch FileNotFoundException ");
        return "FileNotFoundException";
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)
    public String catchNullPointerExcpetion(Exception e, WebRequest request) {
        System.out.printf("Catch NullPointerException");
        return "NullPointerException";
    }

    @Override
    public String toString() {
        return "ExceptionHandler{" +
                "name='" + name + '\'' +
                ", requireProperty='" + requireProperty + '\'' +
                ", requireValue=" + requireValue +
                '}';
    }
}
