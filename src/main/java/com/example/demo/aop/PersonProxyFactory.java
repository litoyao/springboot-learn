package com.example.demo.aop;

public class PersonProxyFactory {

    public static Speakable newJdkProxy() {
        // 代理PersonImpl
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Speakable proxy = dynamicProxy.getProxy();
        return proxy;
    }

    public static Person newCglibProxy(){
        CGLibProxy cgLibProxy= CGLibProxy.getInstance();
        Person proxy = cgLibProxy.getProxy(Person.class);

        return proxy;
    }
} 