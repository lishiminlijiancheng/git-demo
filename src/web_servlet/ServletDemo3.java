package web_servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet{
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
    req.setAttribute("name","李世民");
    System.out.println("demo3被访问了！");
    req.getRequestDispatcher("/d4").forward(req,resp);
}
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        super.doPost(req,resp);
        System.out.println("doPost...");
    }
}

