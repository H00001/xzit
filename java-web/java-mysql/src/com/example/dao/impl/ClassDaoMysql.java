package com.example.dao.impl;

import com.example.DBHelper;
import com.example.dao.ClassDao;
import com.example.data.Account;
import com.example.data._Class;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDaoMysql implements ClassDao {
    private final DBHelper helper;
    public ClassDaoMysql() throws Exception{
        helper = new DBHelper();
    }
    public List<_Class> queryAll() throws SQLException, IOException, URISyntaxException {
        List<_Class> acc = new ArrayList<>();
        return helper.Query("select * from class", rs -> {
            while (rs.next()) {
                acc.add(new _Class(rs.getInt("id"), rs.getString("name")));
            }
            // 判断是否有数据
            return acc;
        });
    }
}
