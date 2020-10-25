package com.example.sql.dao;

import com.example.sql.MysqlConnection;
import com.example.sql.data.Account;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDao {
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
        return con.update("insert into account" +
                "(id,name,math,english,class) values" +
                "(null,'"+a.getName()+"',"+ a.getMath()+
                ","+a.getEnglish()+","+a.get_class()+")")
                ==1;
    }
    public boolean deleteById(int id) throws SQLException {
        return con.update("delete from account where id="+id)==1;
    }

    }
