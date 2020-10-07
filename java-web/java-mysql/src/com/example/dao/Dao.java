package com.example.dao;

import com.example.data.Account;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

public interface Dao {
    Account queryById(int id) throws SQLException, IOException, URISyntaxException;
}

