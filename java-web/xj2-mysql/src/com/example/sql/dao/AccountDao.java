package com.example.sql.dao;

import com.example.sql.MysqlConnection;
import com.example.sql.data.Account;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
    // 连接辅助对象 MysqlConnection
    final private MysqlConnection con;
    public AccountDao() throws SQLException, IllegalAccessException, NoSuchFieldException, IOException {
        con = new MysqlConnection();
    }
    public Account queryById(int id) throws SQLException {
        ResultSet rs = con.
                select("select * from account where id="+id);
         if (!rs.next()) {
            // 没有任何的数据
            return null;
        }
        return new Account(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("math"),
                rs.getInt("english"),
                rs.getInt("class")
        );

    }
    public boolean insert(Account a) throws SQLException {
        String s = "insert into account" +
                "(id,name,math,english,class) values"+
                "(null,?,?,?,?)";
       s= s
               .replace("${1}",a.getName())
               .replace("${2}",a.getMath()+"")
               .replace("${3}",a.getEnglish()+"")
               .replace("${4}",a.get_class()+"");
        return con.update(s) ==1;
    }
    public boolean deleteById(int id) throws SQLException {
        return con.update("delete from account where id="+id)==1;
    }

    }
