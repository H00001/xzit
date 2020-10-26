package com.example;

// 配置具体信息类
public class Conf {
    public int port;
    public String host;
    public String db_name;
    public String db_type;
    public String username;
    public String password;

    @Override
    public String toString() {
        return "jdbc:"+this.db_type+"://"+this.host+":"+this.port+"/"+db_name;
    }
}
