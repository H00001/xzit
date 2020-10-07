package com.example.sql;

import java.sql.*;

public class MysqlConnection {
    static {
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // jdbc:mysql 协议
        // 127.0.0.1 ip地址，根据你们自己的来改
        // mydb 数据库名称
        // 创建一个连接

    }
    Connection con;
    public MysqlConnection() throws SQLException {
        con = DriverManager.
getConnection("jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false",
        "root","root");
    }
    public ResultSet select(String sql) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        // st.close();
        // rs 失效了，不能使用了，给调用着无效
        // 不关闭 st永远释放不了
        // st返回的话，封装没有了意义
        return rs;
    }
    public int update(String sql) throws SQLException{
        return con.createStatement().executeUpdate(sql);
    }

}
