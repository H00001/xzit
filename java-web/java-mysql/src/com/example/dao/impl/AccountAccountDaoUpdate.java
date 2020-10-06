package com.example.dao.impl;

import com.example.DBHelperUpdate;
import com.example.dao.AccountDao;
import com.example.data.Account;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountAccountDaoUpdate implements AccountDao {
    private final DBHelperUpdate helper;
    public AccountAccountDaoUpdate() throws Exception{
        helper = new DBHelperUpdate();
    }

    public boolean insert(final Account a) throws Exception {
        // 构建插入语句
        final String s= "insert into account(id,name,math,english,class) " +
                "values(null,?,?,?,?)";
        // 执行插入
        return helper.Update(s, ps -> {
            // 设置？的值
            ps.setString(1,a.getName());
            ps.setInt(2,a.getMath());
            ps.setInt(3,a.getEnglish());
            ps.setInt(4,a.getClazz());
            return null;
        })==1;
    }

    public boolean deleteById(final int id) throws Exception {
        // 封装删除语句，进行删除
        return helper.Update("delete from account where id=?", ps -> {
            ps.setInt(1,id);
            return null;
        })==1;
    }

    public boolean updateById(final int id,final Account a) throws Exception{
        //构造更新语句
        final String s = "update account set name=?,math=?,english=?,class=? where id=?";
        return helper.Update(s, ps -> {
            ps.setString(1,a.getName());
            ps.setInt(2,a.getMath());
            ps.setInt(3,a.getEnglish());
            ps.setInt(4,a.getClazz());
            ps.setInt(5,id);
            return null;
        })==1;
    }

    public Account queryById(int id) throws SQLException, IOException, URISyntaxException {
        return helper.Query("select * from account where id="+id,
                rs -> rs.next()==true ? mapToAccount(rs):null);
    }

    public List<Account> queryAll() throws SQLException, IOException, URISyntaxException {
        List<Account> acc = new ArrayList<>();
        return helper.Query("select * from account", rs -> {
            while (rs.next()) {
                // 判断是否有数据
                acc.add(mapToAccount(rs));
        }
        return acc;
    });
    }
    private Account mapToAccount(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int math = rs.getInt("math");
        int english = rs.getInt("english");
        int clazz = rs.getInt("class");
        return new Account(id, name, math, english, clazz);
    }
}