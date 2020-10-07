package com.example;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

public class DBHelper implements Closeable {
    static  {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    final Connection con;
    public DBHelper() throws Exception {
        String url = Configure.read().toString();
        // 构造函数创建一个java-mysql连接
        // jdbc:mysql://ip:3306/mydb
        con = DriverManager.getConnection(url,"root","root");
    }
    public int Update(String sql) throws Exception{
        // update，delete，insert
        Statement st = con.createStatement();
        // 执行 update 语句
        int c = st.executeUpdate(sql);
        st.close();
        return c;
    }

    public <T> T Query(String sql, SqlExecutor<T,ResultSet> exc) throws SQLException{
        Statement st = con.createStatement();
        // 执行查询语句
        ResultSet rs = st.executeQuery(sql);
        // 这里为啥不返回result set主要原因是rs在关闭之后不能使用
        // 而如果不关闭那么永远没有办法关闭，所以这里用了一个接口
        // 让用户来实现，将rs转换成所需要的对象，这样rs就没有必要
        // 存在了，所以就可以关闭掉了。
        T o = exc.exec(rs);
        rs.close();
        return o;
    }

    @Override
    public void close() throws IOException {
        try {
            con.close();
        } catch (SQLException throwable) {
            throw new IOException(throwable);
        }
    }
}
