package com.example.dao;

import com.example.data.Account;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface AccountDao extends Dao {
    Account queryById(int id) throws SQLException, IOException, URISyntaxException;
    List<Account> queryAll() throws SQLException, IOException, URISyntaxException;
}

