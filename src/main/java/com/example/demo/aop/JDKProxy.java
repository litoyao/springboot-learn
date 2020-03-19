package com.example.demo.aop;

import com.example.demo.service.UserService;
import com.example.demo.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    private Object targetObj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法之前...");

        Object ret = method.invoke(targetObj, args);

        System.out.println("执行方法之后...");

        return ret;
    }

    public Object getProxy(Object targetObj) {
        this.targetObj=targetObj;
        return Proxy.newProxyInstance(targetObj.getClass().getClassLoader(),
                targetObj.getClass().getInterfaces(),
                this);
    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();

        UserService userService=(UserService)jdkProxy.getProxy(new UserServiceImpl());

        userService.sayHi("you");


    }
}
