import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

public class jdbc_pool {
    public static void main(String[] args) throws Exception
    {
        Properties pro =new Properties();pro.load(new FileReader("D:\\javaPro\\webProject\\src\\fw.properties"));
        DataSource ds=DruidDataSourceFactory.createDataSource(pro);
        Connection conn=ds.getConnection();
        System.out.println(conn);


    }

}
