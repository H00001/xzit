public class Main {
    static {
        // 加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // jdbc:mysql 协议
        // 127.0.0.1 ip地址，根据你们自己的来改
        // mydb 数据库名称
        // 创建一个连接
    }
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.
                getConnection("jdbc:mysql://127.0.0.1:3306/mydb?useSSL=false","root","root");
        // 创建查询
        Statement st = con.createStatement();
        //select(st);
       // st.executeUpdate("delete from account where id=101");
       // int v=  st.executeUpdate("update account set name='zhang4' where id=101");
        //int v = st.executeUpdate("insert into account(id,name,math,english,class) values(null,'zhang3',10,20,1)");
        st.close();
        con.close();
       /// System.out.println(v);
    }

    private static void select(Statement st) throws SQLException {
        // 具体的查询
        ResultSet rs = st.executeQuery("select * from account");
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