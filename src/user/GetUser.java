package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetUser {

	public static String[] getUser(String username) throws SQLException
	{
		String[] userprofile = new String[5];
		
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select * from user where username = \""+username + "\"";  
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            userprofile[0]=rs.getString(1); 
            userprofile[1]=rs.getString(2); 
            userprofile[2]=rs.getString(3); 
            userprofile[3]=String.valueOf(rs.getInt(4)); 
            userprofile[4]=String.valueOf(rs.getInt(5)); 
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
		
		return userprofile;
	}
}
