package com.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
    String greet;
    public HelloWorldBean(String greet) {
        this.greet = greet;
    }

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "greet='" + greet + '\'' +
                '}';
    }
}
