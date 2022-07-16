package se325.example03.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//uses apache tomcat to run. configured via web.xml
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //MIME: e.g., application/json
        resp.setContentType("text/plain");

        PrintWriter out = resp.getWriter();
        out.println("Hello, world!");
        //can also set status code
    }
}