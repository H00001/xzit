package com.example.dao;

import com.example.DBHelper;
import com.example.data.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountDao implements Dao {
    private final DBHelper helper;
    public AccountDao() throws Exception{
        helper = new DBHelper();
    }

    public void insert(Account a) throws Exception {
        // 构建插入语句
        String s= "insert into account(id,name,math,english,class) values(null,'"+a.getName()+"',"+a.getMath()+","+a.getEnglish()+","+a.getClazz()+")";
        // 执行插入
        helper.Update(s);
    }

    public void deleteById(int id) throws Exception {
        // 封装删除语句，进行删除
        helper.Update("delete from account where id="+id);
    }

    public void updateById(int id,Account a) throws Exception{
        //构造更新语句
        String s = "update account set name='"+a.getName()+"',math="+a.getMath()+",english="+a.getEnglish()+",class="+a.getClazz()+" where id="+id;
        helper.Update(s);
    }

    public Account queryById(int id) throws SQLException {
        return helper.Query("select * from account where id="+id, rs -> {
            if (!rs.next()) {
                return null;
            }
            int _id = rs.getInt("id");
            String name = rs.getString("name");
            int math = rs.getInt("math");
            int english = rs.getInt("english");
            int clazz = rs.getInt("class");
            return new Account(_id, name, math, english, clazz);
        });
    }

    public List<Account> QueryAll() throws SQLException {
        List<Account> acc = new ArrayList<>();
        return helper.Query("select * from account", rs -> {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int math = rs.getInt("math");
                int english = rs.getInt("english");
                int clazz = rs.getInt("class");
                Account a = new Account(id, name, math, english, clazz);
                acc.add(a);
        }
        return acc;
    });
    }
}