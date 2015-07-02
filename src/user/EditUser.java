package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EditUser {

	@SuppressWarnings("resource")
	public static void editUser() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		String username;
		String level;
		System.out.print("请输入要修改权限的用户名:");
		username=input.next();
		System.out.print("请输入修改后的用户等级（1为普通用户，2为管理员）：");
		level=input.next();
		
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "update user set level = '" + level + "'  where username = '"+username + "'";  
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        

		System.out.println("修改完毕！");
		
	}
}
