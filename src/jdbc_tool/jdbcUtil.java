package jdbc_tool;
import java.io.IOException;
import java.io.Closeable;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;
import java.sql.*;
public class jdbcUtil {
        private  static String driver;
        private static String url;
        private static String user;
        private static String password;
        static {
            try {
                Properties prop=new Properties();
                ClassLoader classLoader=jdbcUtil.class.getClassLoader();
                prop.load(new FileReader("D:\\javaPro\\JDBC_practice\\fw.properties"));
                url=prop.getProperty("url");
                user=prop.getProperty("user");
                password=prop.getProperty("password");
                driver=prop.getProperty("driver");
                try {
                    Class.forName(driver);}
                catch(ClassNotFoundException e){
                    e.printStackTrace();

                }}
            catch(IOException e){
                e.printStackTrace();
            }
        }
        public  static Connection getConnection(){
            try {
                Connection cnntConnection=DriverManager.getConnection(url,user,password);
                System.out.println("数据库连接成功！");
                return cnntConnection;
            }
            catch(SQLException e) {
                e.printStackTrace();
                System.out.println("数据库连接失败!");
                return null;
            }
        }
        public static void close(Connection cnnt,Statement stm)
        {
            try {
                if(cnnt!=null)
                {
                    cnnt.close();
                }
                if(stm!=null)
                {
                    stm.close();
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }

    }


