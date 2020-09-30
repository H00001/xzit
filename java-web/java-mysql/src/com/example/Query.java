package com.example;

import java.sql.*;

public class Query {
    static {
        try {
            // 初始化驱动，因为static快最先执行
            Class.forName("com.mysql.jdbc.Driver");  // 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static String CONN_MYSQL="jdbc:mysql://localhost:3306/mydb?useSSL=false";
    private static Connection con;
    public static void Init() throws SQLException {
        // 创建连接，全局只有一个连接
        con = DriverManager.
                getConnection(CONN_MYSQL,"root","root"); // 获得链接
    }
    private static Statement createStatement() throws SQLException{
        // 创建statement ，创建一个数据库的执行命令
       return con.createStatement();
    }
    public static ResultSet Query(String sql) throws SQLException{
        // “select 语句封装”
        return createStatement().executeQuery(sql);
    }
    public static boolean Update(String sql) throws SQLException {
        // “update 语句的封装 update delete insert
        int x = createStatement().executeUpdate(sql);
        System.out.println(x+" lines affect");
        return true;
    }
    public static <T> T execute(String s,Class<T> c) throws SQLException {
        if (s.startsWith("SELECT")||s.startsWith("select")){
            return c.cast(Query(s));
        } else{
            return c.cast(Update(s));
        }
    }
}
