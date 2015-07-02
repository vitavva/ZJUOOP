package user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginConnect {

	public static boolean loginConnect(String username , String password) throws SQLException {
		String backpass = null;
		//连接数据库
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select password from user where username = \""+username + "\"";  
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next())
            {
            	backpass = rs.getString(1); 
            }
            else {
            	System.out.print("用户名不存在，");
            	return false;
			}
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        
        if(backpass.equals(password))return true;
        else 
        {
        	System.out.print("密码错误，");	
        	return false;
        }
        
        
		}
		
	}
