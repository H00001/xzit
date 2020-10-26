package com.example.dao;

import com.example.data._Class;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface ClassDao {
    public List<_Class> queryAll() throws SQLException, IOException, URISyntaxException;
}
