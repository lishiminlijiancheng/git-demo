package web_servlet;


import users.User;
import org.apache.commons.beanutils.BeanUtils;
import users.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
//        String username=request.getParameter("username");
//        String password=request.getParameter("password");
        Map<String ,String[]>map=request.getParameterMap();
        User loginUser=new User();
        try{
            BeanUtils.populate(loginUser,map);
        }
        catch ( InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();;
        }
        UserDao userDao=new UserDao();
        User user=userDao.login(loginUser);
        String checkcode=request.getParameter("checkcode");
        HttpSession session=request.getSession();
        String  rel_checkcode=(String)session.getAttribute("checkcode");
        if( rel_checkcode!=null&&rel_checkcode.equalsIgnoreCase(checkcode))
        {
            if(user!=null)
            {
                session.setAttribute("username",user.getName());
                response.sendRedirect("/success.jsp");
            }
            else
            {
                request.setAttribute("login_error","用户名或密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
        else{
            request.setAttribute("cc_error","验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
