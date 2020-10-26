package new1.com.example.sql;



import com.example.sql.conf.Conf;

import java.io.IOException;
import java.sql.*;

public class MysqlConnection {
    static Conf c;
    static {
        // 加载驱动
        try {
            // 通过配置文件加载驱动
            c = Conf.init();
            Class.forName(c.getDriver());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // jdbc:mysql 协议
        // 127.0.0.1 ip地址，根据你们自己的来改
        // mydb 数据库名称
        // 创建一个连接

    }
    Connection con;
    public MysqlConnection() throws SQLException, IllegalAccessException, NoSuchFieldException, IOException {
        con = DriverManager.
getConnection(c.toString(), c.getUsername(),c.getPassword());
    }
    public ResultSet select(String sql) throws SQLException {
        Statement st = con.prepareStatement(sql);

        ResultSet rs = st.executeQuery(sql);
        // st.close();
        // rs 失效了，不能使用了，给调用着无效
        // 不关闭 st永远释放不了
        // st返回的话，封装没有了意义
        return rs;
    }
    public PreparedStatement update(String sql) throws SQLException{
        // 创建preparedStatement 用于做替换
        // 之所以进行返回是因为给用户st用来做替换
        return con.prepareStatement(sql);
    }

    public int commit(PreparedStatement ps) throws SQLException {
        // 用户替换完成之后，在commit
        return ps.executeUpdate();
    }
    public void close() throws SQLException {
        con.close();
    }
}
