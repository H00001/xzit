import com.example.sql.MysqlConnection;


import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, SQLException {
        MysqlConnection mc = new MysqlConnection();
        select(mc.select("select * from account"));
        select(mc.select("select * from account"));
    }

    private static void select(ResultSet rs) throws SQLException {
        // 具体的查询
        // 按行输出
        while (rs.next()){
            // 每一次循环，选择一行
            // 获取某行列的内容，通过列明
            // id = rs.getInt(1)
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int math =  rs.getInt("math");
            int english =  rs.getInt("english");
            System.out.printf("id=%d,name=%s,math=%d,english=%d",id,name,math,english);
            System.out.println();
        }
    }
}
