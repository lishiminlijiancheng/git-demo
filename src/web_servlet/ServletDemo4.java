package web_servlet;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/d4","/dd4"})
public class ServletDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
//        System.out.println("demo4±ª∑√Œ ¡À£°");
//        Object name=req.getAttribute("name");
//        System.out.println(name);
      try{resp.sendRedirect("/login.html");}
      catch (IOException e)
      {
          e.printStackTrace();
      }


    }

}
