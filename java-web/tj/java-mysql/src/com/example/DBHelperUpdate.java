package com.example;

import com.example.pool.MySqlConnection;
import com.example.pool.MysqlConnectionPool;
import com.example.util.Configure;

import java.io.Closeable;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class DBHelperUpdate implements Closeable {


   // final Connection con;
    final private MysqlConnectionPool pool;
    public DBHelperUpdate() throws Exception {
        String url = Configure.read().toString();
        // 构造函数创建一个java-mysql连接
        // jdbc:mysql://ip:3306/mydb
        // 初始化连接池
        pool = new MysqlConnectionPool(10);
       // con = DriverManager.getConnection(url,"root","root");
    }
    public int Update(String sql,SqlExecutor<Void,PreparedStatement> exc) throws Exception{
        // update，delete，insert
        // 从连接池中获取
        final MySqlConnection con = pool.acquire();
        PreparedStatement st = con.con().prepareStatement(sql);
        exc.exec(st);
        // 执行 update 语句
        int c = st.executeUpdate();
        st.close();
        // 释放到连接池中
        con.release();
        // 影响的行数
        return c;
    }

    public <T> T Query(String sql, SqlExecutor<T,ResultSet> exc) throws SQLException, IOException, URISyntaxException {
        final MySqlConnection con = pool.acquire();
        Statement st = con.con().createStatement();
        // 执行查询语句
        ResultSet rs = st.executeQuery(sql);
        // 这里为啥不返回result set主要原因是rs在关闭之后不能使用
        // 而如果不关闭那么永远没有办法关闭，所以这里用了一个接口
        // 让用户来实现，将rs转换成所需要的对象，这样rs就没有必要
        // 存在了，所以就可以关闭掉了。
        T o = exc.exec(rs);
        rs.close();
        con.release();
        return o;
    }

    @Override
    public void close() throws IOException {
        try {
            pool.destroy();
        } catch (Exception throwable) {
            throw new IOException(throwable);
        }
    }
}
