package com.example.demo.aop;

public class ProxyTestCase {

    public static void main(String[] args){
        // jdk dynamic proxy
        System.out.println("******** jdk dynamic proxy ******** ");
        Speakable jdkProxy = PersonProxyFactory.newJdkProxy();
        jdkProxy.sayHi();
        jdkProxy.sayBye();

        System.out.println("******** cglib proxy ******** ");
        Person cglibProxy = PersonProxyFactory.newCglibProxy();
        cglibProxy.sayHi();
        cglibProxy.sayBye();
    }
}
