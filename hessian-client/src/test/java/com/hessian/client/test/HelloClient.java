package com.hessian.client.test;

import com.caucho.hessian.client.HessianProxyFactory;
import com.ibm.hessian.service.HelloService;

public class HelloClient {

    // Hessian服务的url
    private static final String url = "http://localhost:8080/hessian-service/hessian/hello";

    public static void main(String[] args) throws Exception {
        
        // 创建HessianProxyFactory实例
        HessianProxyFactory factory = new HessianProxyFactory();
        // 获得Hessian服务的远程引用
        HelloService service = (HelloService) factory.create(HelloService.class, url);
        
        System.out.println(service.sayHello("sunfx"));
        
    }
}
