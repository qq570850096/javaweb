package utils;


import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.sql.*;

public class DButils {
    static final String USER = "youzan6";
    static final String PASSWORD = "Youzan666";
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_youzan?useSSL=false&serverTimezone=GMT";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static void ssh() {
        String user = "root";//SSH连接用户名
        String password = "Yonglun1003";//SSH连接密码
        String host = "114.115.214.89";//SSH服务器
        int port = 22;//SSH访问端口
        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
            int assinged_port = session.setPortForwardingL(3306, host, 3306);
            System.out.println("localhost:" + assinged_port + " -> " + host + ":" + 3306);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DButils(){
        ssh();
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //创建Statement对象
            stmt=conn.createStatement();
            //建立结果集
            ResultSet rs=stmt.executeQuery("SELECT id,username FROM userdetails");
            System.out.println("查询成功!");
            while(rs.next()) {
                System.out.println(rs.getString(1)+" "+rs.getString("username"));
            }
            //关闭结果集
            rs.close();
            //关闭Statement对象
            stmt.close();
            //关闭数据库
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        DButils dButils = new DButils();
    }
}
