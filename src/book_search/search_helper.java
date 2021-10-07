package book_search;
import java.sql.*;

import jdbc_tool.JDBCUtils;
import jdbc_tool.jdbcUtil;
public class search_helper {

    public static ResultSet getAllTuple()
    {
        Connection cnnt=null;
       try {
           cnnt= JDBCUtils.getConnection();
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
        String sql="select *from books";
        try
        {PreparedStatement pst=cnnt.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            return rs;
        }
        catch (Exception e) {
            // TODO: handle exception
            System.out.println("error:"+e);
            return null;
        }
    }
}
