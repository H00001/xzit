package com.example.sql;

import com.example.sql.conf.Conf;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class MysqlConnection {
    static Conf c;
    static {
        // 加载驱动
        try {
            c = Conf.init();
            Class.forName(c.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // jdbc:mysql 协议
        // 127.0.0.1 ip地址，根据你们自己的来改
        // mydb 数据库名称
        // 创建一个连接

    }
    Connection con;
    public MysqlConnection() throws SQLException, IllegalAccessException, NoSuchFieldException, IOException {
        con = DriverManager.
getConnection(c.toString(), c.getUsername(),c.getPassword());
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
        Statement st = con.createStatement();
        int v = st.executeUpdate(sql);
        st.close();
        return v;
    }
    public void close() throws SQLException {
        con.close();
    }
}
