# 封装 DAO

```java
Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root"); // 创建连接，jdbc => java去连接任意的数据库，mysql 特定的mysql mydb=>数据库名。用户名，密码
Statement st = con.createStatement(); // 创建查询
// 1. select
ResultSet rs = st.executeQuery("  ");
// 2.update delete insert
int r = st.executeUpdate("  ");

st.close();
con.close();
```

## Dao

dbhelper.java

```java
public class DBHelper implements Closeable {
    static  {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 加载驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    final Connection con;
    public DBHelper() throws Exception {
        String url = Configure.read().toString();
        // 构造函数创建一个java-mysql连接
        con = DriverManager.getConnection(url,"root","root");
    }
    public int Update(String sql) throws Exception{
        // update，delete，insert
        Statement st = con.createStatement();
        // 执行 update 语句
        int c = st.executeUpdate(sql);
        st.close();
        return c;
    }

    public <T> T Query(String sql, SqlExecutor<T> exc) throws SQLException{
        Statement st = con.createStatement();
        // 执行查询语句
        ResultSet rs = st.executeQuery(sql);
        // 这里为啥不返回result set主要原因是rs在关闭之后不能使用
        // 而如果不关闭那么永远没有办法关闭，所以这里用了一个接口
        // 让用户来实现，将rs转换成所需要的对象，这样rs就没有必要
        // 存在了，所以就可以关闭掉了。
        T o = exc.exec(rs);
        rs.close();
        return o;
    }

    @Override
    public void close() throws IOException {
        try {
            con.close();
        } catch (SQLException throwable) {
            throw new IOException(throwable);
        }
    }
}

```

AccountDao.java

```java
package com.example.dao;

import com.example.DBHelper;
import com.example.data.Account;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountDao {
    // 获取执行数据库语句的对象
    private final DBHelper helper;
    public AccountDao() throws Exception{
        helper = new DBHelper();
    }
    public Account queryById(int id) throws SQLException {
        // 查询，通过id
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
```

