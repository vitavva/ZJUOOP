package user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import menu.Menu;

public class ChangeNickname {

	@SuppressWarnings("resource")
	public static void changeNickname(String[] profile) throws SQLException, IOException
	{
		Scanner input=new Scanner(System.in);
		String newNickname;
		System.out.print("请输入新昵称：");
		newNickname=input.next();
		profile[2]=newNickname;
		
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "update user set nickname = '" + newNickname + "'  where username = '"+profile[0] + "'";  
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
		Menu.menu(profile);
	}
}
