package cn.util;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JDBC tool, Durid connection pool
 */
public class JDBCUtils {
    private static DataSource ds;
    static {
        //1. load properties file
        Properties pro = new Properties();
        //2. use ClassLoad加载配置文件，获取字节输入流
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        //3.initialize connection pool object
        try {
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


    /**
     * get connection pool object
     */
    public static DataSource getDataSource(){
        return ds;
    }
}
