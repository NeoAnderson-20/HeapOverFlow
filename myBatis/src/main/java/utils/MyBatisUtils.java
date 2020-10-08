package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {

        try {
            //固定格式
            String resource = "config.xml";
            InputStream in = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();

    }
}
