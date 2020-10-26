package com.example.pool;

import com.example.util.Configure;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MysqlConnectionPool {
    static  {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    final private Queue<MySqlConnection> q = new ConcurrentLinkedQueue<>();

    public MysqlConnectionPool(int n) throws SQLException, IOException, URISyntaxException {
        for (int i = 0; i < n; i++) {
            // 预热的过程
            q.offer(creatNewConnection());
        }
    }

    public void destroy(){
        q.forEach(v->{
            try {
                v.con().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public void release(MySqlConnection c){
        q.offer(c);
        // 将连接对象，放入连接池中
        System.out.println("释放到池中");
        // 释放连接对象
    }

    public MySqlConnection acquire() throws IOException, URISyntaxException, SQLException {
        MySqlConnection c;
        System.out.println("从池中获取");
        if ((c = q.poll())!= null){
            // 从队列头中拿出连接
            //池子里面还有连接
            return c;
        }
        // 如果没有连接了，那么就创建新的
        return creatNewConnection();
        // 获取连接对象
    }

    private MySqlConnection creatNewConnection() throws SQLException, URISyntaxException, IOException {
        System.out.println("产生新的连接");
        return new MySqlConnection(this, DriverManager.getConnection(
                Configure.read().toString(), "root", "root"));
    }
}
