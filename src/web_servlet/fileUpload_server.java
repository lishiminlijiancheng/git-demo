package web_servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet("/fileUpload_server")
public class fileUpload_server extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String item_name=request.getParameter("item_name");
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try{
            List<FileItem> parseRequest=upload.parseRequest(request);
            String book_name="";
            for(FileItem fileItem:parseRequest)
            {
//                String name=fileItem.getName();
               String fieldName=fileItem.getFieldName();
//                System.out.println("name"+name);
//                System.out.println("filedName"+fieldName);

                if(fileItem.isFormField())
                {
                     book_name=fileItem.getString("utf-8");
                    System.out.print(fieldName+": ");
                    System.out.println(book_name);
                }
                else
                {  System.out.println(fieldName+":"+fileItem.getName());
                    InputStream ips=fileItem.getInputStream();
                File file=new File("D:/javapro/webProject/web/upload",book_name+".jpg");
                FileOutputStream ops=new FileOutputStream(file);
                byte[]date=new byte[2048];
                int read =0;
                try{
                    while((read=ips.read(date ,0,date.length))!=-1)
                    {
                        ops.write(date,0,read);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    if(ips!=null)
                    {
                        ips.close();
                    }
                    if(ops!=null)
                    {
                        ops.close();
                    }
                }
            }

        }}
        catch (FileUploadException e)
        {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
