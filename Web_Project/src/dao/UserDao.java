package dao;

//数据库交互

import Project_v1.User;
import util.JDBCUtils;

import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.basic.BasicDesktopPaneUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private JDBCUtils utils = new JDBCUtils();


    public int add(User user) throws SQLException {
        String sql = "insert into web(username,password)" +
                " values  (?,?) ";

        Connection con = utils.getConnection();
        PreparedStatement ps = utils.createStatement(sql);
        int result = 0;
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        result = ps.executeUpdate();

        utils.close(ps, con);
        return result;
    }
    //重载
    public int add(User user, HttpServletRequest request) throws SQLException {
        String sql = "insert into web(username,password)" +
                " values  (?,?) ";

        Connection con = utils.getConnection();
        PreparedStatement ps = utils.createStatement(sql,request);
        int result = 0;
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        result = ps.executeUpdate();

        utils.close(ps, con);
        return result;
    }


    public List findall() throws SQLException {
        String sql = "select * from web";
        List<User> userList = new ArrayList<>();

        PreparedStatement ps = utils.createStatement(sql);
        ResultSet rs = null;
        rs = ps.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            User user = new User(username, password);
            userList.add(user);
            System.out.println(user.getUsername());
        }

        return userList;


    }

    public int delete(String username) throws SQLException {
        String sql = "delete from web where username = ?";
        PreparedStatement ps = utils.createStatement(sql);
        int result = 0;
        ps.setString(1, username);
        ps.executeUpdate();
        return result;
    }

    public int login(String username,String password) throws SQLException {
        String sql = "select count(*) from web where username=? and password = ?";
        PreparedStatement ps = utils.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();

        while (rs.next()){
            result = rs.getInt("count(*)");

        }

        return result;

    }


}

