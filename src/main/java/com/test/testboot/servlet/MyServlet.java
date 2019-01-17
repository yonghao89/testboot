package com.test.testboot.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet( urlPatterns ="/my/servlet",asyncSupported=true )
public class MyServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(()->{
            try {
                resp.getWriter().println("Hello World! asyncContext当前类中的asyncContext所有方法、全局常量，方法还包括形参和返回值，一");
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }




}
