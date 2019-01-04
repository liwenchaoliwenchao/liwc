package com.huawei.demo.entity;

public class SomethingToReturn {
    private String hello;
    private int test;
    public SomethingToReturn(String hello, int test) {
        this.hello = hello;
        this.test= test;
    }
    public String getHello() {
        return hello;
    }
    public void setHello(String hello) {
        this.hello = hello;
    }
    public int getTest() {
        return test;
    }
    public void setTest(int test) {
        this.test = test;
    }
    
}
