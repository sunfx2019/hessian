package com.ibm.hessian.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.caucho.hessian.server.HessianServlet;

@WebServlet(value = "/hessian/hello", initParams = {@WebInitParam(name = "service-class", value = "com.ibm.hessian.service.impl.HelloServiceImpl")})
public class HelloServlet extends HessianServlet {
    private static final long serialVersionUID = 1L;

    public void init() throws ServletException {
        super.init();
    }

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
