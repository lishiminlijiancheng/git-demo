package web_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo6")
public class ServletDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            System.out.println("Œ“ «demo6....");
//            response.sendRedirect("http://www.itcast.cn");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw=response.getWriter();
        pw.write("<h1>ƒ„∫√—Ω£°</h1>");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
