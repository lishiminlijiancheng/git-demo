package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies=request.getCookies();
        response.setContentType("text/html;charset=utf-8");
        boolean flag=false;
        if(cookies!=null&&cookies.length>0)
        {
            Date time=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str_date=simpleDateFormat.format(time);
            str_date= URLEncoder.encode(str_date,"utf-8");
            Cookie cookie=new Cookie("lastTime",str_date);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            Cookie[]cookies1=request.getCookies();
            for(Cookie c:cookies1)
            {
                if(c.getName().equals("lastTime"))
                {   flag=true;
                    String last_time=c.getValue();
                    last_time= URLDecoder.decode(last_time,"utf-8");
                    response.getWriter().write("欢迎回来，您上次的访问时间为："+last_time);
                    break;
                }
            }

        }
        else if(cookies==null||cookies.length==0||flag==false)
        {
            Date time=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str_date=simpleDateFormat.format(time);
            str_date= URLEncoder.encode(str_date,"utf-8");
            Cookie cookie=new Cookie("lastTime",str_date);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            response.getWriter().write("欢迎新人!");

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
