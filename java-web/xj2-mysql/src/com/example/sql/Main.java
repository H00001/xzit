package com.example.sql;

import com.example.sql.MysqlConnection;
import com.example.sql.dao.AccountDao;
import com.example.sql.data.Account;


import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, SQLException, IllegalAccessException, NoSuchFieldException, IOException {
        var a = new AccountDao();
        var u = a.insert(new Account(10090,"1223",10,40,50));
        //a.insert(new Account(0,"null",1,2,3));
       // a.deleteById(7);
       // System.out.println("name:"+u.getName());
       // System.out.println("id:"+u.getId());
       // System.out.println("math:"+u.getMath());

        // MysqlConnection mc = new MysqlConnection();
       // mc.update("update account set math=10 where id=10");
       // mc.update("delete from account where id=10");
       // mc.update("insert into account values(null,'avc',10,10,10)");
       // mc.close();
        //select(mc.select("select * from account"));
       // select(mc.select("select * from account"));
    }

    private static void select(ResultSet rs) throws SQLException {
        // 具体的查询
        // 按行输出
        while (rs.next()){
            // 每一次循环，选择一行
            // 获取某行列的内容，通过列明
            // id = rs.getInt(1)
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int math =  rs.getInt("math");
            int english =  rs.getInt("english");
            System.out.printf("id=%d,name=%s,math=%d,english=%d",id,name,math,english);
            System.out.println();
        }
    }
}
