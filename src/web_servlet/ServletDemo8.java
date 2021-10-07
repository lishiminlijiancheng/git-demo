package web_servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/demo8")
public class ServletDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        Graphics g=image.getGraphics();
        g.setColor(Color.PINK);
        g.drawRect(0,0,width,height);
        g.setColor(Color.WHITE);
        g.drawRect(0,0,width-1,height-1);
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random ran=new Random();
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=4;i++)
        {
            int index=ran.nextInt(str.length());
            char ch=str.charAt(index);
            sb.append(ch);
            g.drawString(ch+"",width/5*i,height/2);
        }
        String checkcode=sb.toString();
        HttpSession session=request.getSession();
        session.setAttribute("checkcode",checkcode);
        g.setColor(Color.GREEN);
        for(int i=0;i<10;i++)
        {
            int x1=ran.nextInt(width);
            int x2=ran.nextInt(width);
            int y1=ran.nextInt(height);
            int y2=ran.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
