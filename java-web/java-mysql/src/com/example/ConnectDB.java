package com.example;

import java.sql.*;

public class ConnectDB {

    public static void main(String[] args) throws Exception{
        Query.Init();
        Query.Update("delete from account where math=19");
        Query.Update("insert into account(id,name,math,english) values(null,'xiaoming',80,10)");
        Query.Update("update account set english=100 where name='xiaoming'");
        Query.execute("select * from account",ResultSet.class);
        Query.execute("update account set english=100 where name='xiaoming'",boolean.class);
        ResultSet rs = Query.Query("select * from account");
        System.out.println("id\t|name\t|math");
        while (rs.next()){
            System.out.print(rs.getInt("id")+"\t|");
            System.out.print(rs.getString("name")+"\t|");
            System.out.println(rs.getInt("english")+"\t|");
        }
        rs.close();
    }
}
