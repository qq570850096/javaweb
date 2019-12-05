package com.xxx.bean;

import java.sql.*;

public class BeanTest {

    public BeanTest(){}
    /**
     *
     * @return
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public Connection getConnection() throws SQLException,
            InstantiationException, IllegalAccessException,
            ClassNotFoundException {
        Connection conn = null;
        /**

         * Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver"
         * ).newInstance();
         */
        Class.forName("com.mysql.cj.jdbc.Driver");

        /**
         *
         * String url =
         * "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=Northwind";
         */
        String url = "jdbc:mysql://localhost:3306/bookstore?useSSL=false&serverTimezone=GMT";

        String user = "root";

        String password = ")Yonglun1003";
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     *
     *
     * @param sql
     * @return
     * @throws Exception
     */
    public ResultSet select(String sql) throws Exception {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException sqle) {
            throw new SQLException("select data exception: "
                    + sqle.getMessage());
        } catch (Exception e) {
            throw new Exception("System e exception: " + e.getMessage());
        }

    }

    /**
     *
     *
     * @param sql
     * @throws Exception
     */
    public void insert(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("insert data exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }

    /**
     *
     *
     * @param sql
     * @throws Exception
     */
    public void update(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("update exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }

    /**
     *
     *
     * @param sql
     * @throws Exception
     */
    public void delete(String sql) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new Exception("delete data exception: " + sqle.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                throw new Exception("ps close exception: " + e.getMessage());
            }
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception("connection close exception: " + e.getMessage());
        }
    }
}