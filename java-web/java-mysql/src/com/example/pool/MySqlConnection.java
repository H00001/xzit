package com.example.pool;

import java.sql.Connection;

public class MySqlConnection {
    // 释放他的池子
    final private MysqlConnectionPool pool;
    // 具体的连接对象
    final private Connection con;

    public MySqlConnection(MysqlConnectionPool pool, Connection con) {
        this.pool = pool;
        this.con = con;
    }

    public void release(){
        pool.release(this);
    }
    public Connection con(){
        return con;
    }
}
