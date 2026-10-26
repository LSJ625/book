package com.dao;

import com.bean.User;
import com.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    //登录校验
    public User login(String username, String password){
        User user = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select id,username,password from `user` where username=? and password=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
        return user;
    }

    //注册判重+插入，新增控制台打印调试
    public boolean register(String username, String password){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            System.out.println("===== 注册判重，输入用户名：" + username);
            String checkSql = "select id from `user` where username=?";
            pstmt = conn.prepareStatement(checkSql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            boolean hasUser = rs.next();
            System.out.println("===== 查询结果 hasUser = " + hasUser);

            if(hasUser){
                System.out.println("===== 用户名重复，返回false");
                return false;
            }
            //插入新用户
            String insertSql = "insert into `user`(username,password) values(?,?)";
            pstmt = conn.prepareStatement(insertSql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            int row = pstmt.executeUpdate();
            System.out.println("===== 插入影响行数 row = " + row);
            return row > 0;
        }catch (Exception e){
            System.out.println("===== register异常！");
            e.printStackTrace();
            return false;
        }finally {
            DBUtil.close(conn,pstmt,rs);
        }
    }
}
