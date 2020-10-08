package util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.sql.*;
import java.util.Iterator;
import java.util.Map;

public class JDBCUtils {
    public static final String DRIVERCLASS = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/javatest?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "suda12034512";
    static {
        try {
            Class.forName(DRIVERCLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 3.连接方法getConnection()
    public  Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

        //通过全局作用域来获取connection
    public  Connection getConnection(HttpServletRequest request) {
        //将请求对象作为参数,获取全局作用域
        ServletContext application = request.getServletContext();
        //获取作用域中的对象,Obj类型
        Connection con = null;
        Map map = (Map) application.getAttribute("k1");
        Iterator it = map.keySet().iterator();
        while (it.hasNext()){
            con = (Connection)it.next();
            if((boolean)map.get(con) == true){
                map.put(con, false);
                break;
            }
        }
        return  con;


    }

    public PreparedStatement createStatement(String sql) throws SQLException {
        PreparedStatement ps = null;
        Connection con = getConnection();
        ps = con.prepareStatement(sql);


        return  ps;

    }

    public PreparedStatement createStatement(String sql,HttpServletRequest request) throws SQLException {
        PreparedStatement ps = null;
        Connection con = getConnection();
        ps = con.prepareStatement(sql);

        return  ps;
    }

    //4.关闭连接close（ResultSet rs,Statemment st，Connection connection）
    public  void close(ResultSet resultset, Statement statement, Connection connection) {
        if (resultset != null) {
            try {
                resultset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    // 5.重写close（Statemment st，Connection connection）（声明：不重写，也可以将rs设为NULL）；
    public  void close(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

