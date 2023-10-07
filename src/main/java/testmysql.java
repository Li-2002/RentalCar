import org.junit.Test;

import java.sql.*;

public class testmysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection
                ("jdbc:mysql://localhost:3306/rental?serverTimezone=Asia/Shanghai", "root", "6723770abc");

        Statement statement = conn.createStatement();

        String sql = "select money from account";
        //执行查询sql语句 并把数据库表中记录返回到ResultSet对象中进行保存。
        ResultSet rs = statement.executeQuery(sql);

        //取出ResultSet中表的记录。rs.next() 判断指针是否可以移动。如果可以移动则返回true,否则返回false
        while (rs.next()) {
            int id = rs.getInt("money"); //指针移动并获取指定列的值。
            System.out.println(id);
        }
    }}
