package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowUser {

	public static void showUser() throws SQLException
	{
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select * from user ";  
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("用户名 昵称 用户等级 已借书数"); 
            
            while(rs.next())
            {
            System.out.print(rs.getString(1)); 
            System.out.print(" ");
            System.out.print(rs.getString(3)); 
            if(rs.getInt(4)==1) System.out.print(" 普通用户 ");
            else System.out.print(" 管理员 ");
            System.out.println(rs.getString(5)); 
            }

            System.out.println("所有用户输出完毕！"); 
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
	}
}
