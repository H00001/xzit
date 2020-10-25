package new1.com.example.sql.dao;

import new1.com.example.sql.MysqlConnection;
import new1.com.example.sql.data.Account;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        String s = "insert into account" +
                "(id,name,math,english,class) values"+
                "(null,?,?,?,?)";
        PreparedStatement st = con.update(s);
        st.setString(1,a.getName());
        st.setInt(2,a.getMath());
        st.setInt(3,a.getEnglish());
        st.setInt(4,a.get_class());
        return con.commit(st)==1;
    }
    public boolean deleteById(int id) throws SQLException {
        PreparedStatement st = con.update("delete from account where id=?");
        st.setInt(1,id);
        return con.commit(st)==1;
    }

}
