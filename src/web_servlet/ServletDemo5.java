package web_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet( "/demo5")
public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
        Map<String,String[]>map=request.getParameterMap();
        Set<String>set=map.keySet();
        for(String name :set)
        {
            System.out.print(name+": ");
            String[]value=map.get(name);
            for(String v:value)
            {
                System.out.println(v);
            }
            System.out.println("-----------------");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      this.doPost(request,response);

    }
}
