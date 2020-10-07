package com.example;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface SqlExecutor<T,R> {
    T exec(R rs) throws SQLException;
}
