package com.example.dao.impl;

import com.example.dao.AccountDao;
import com.example.data.Account;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public class AccountDaoSqlServer implements AccountDao {
    @Override
    public Account queryById(int id) throws SQLException, IOException, URISyntaxException {
        return null;
    }

    @Override
    public List<Account> queryAll() {
        return null;
    }
}
