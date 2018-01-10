package com.ibm.hessian.service.impl;

import com.ibm.hessian.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String username) {
        return "Hello," + username;
    }

}
