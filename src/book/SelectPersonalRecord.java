package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectPersonalRecord {

	public static void selectPersonalRecord(String[] profile) throws SQLException
	{
		System.out.println("以下是您最新的十条借书记录：");
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select * from record where username = '"+profile[0]+"'";
            ResultSet rs = stmt.executeQuery(sql);
            int nn=10;
            if(rs.last())
            {
            	while(nn>0)
            	{
            		nn--;
            		System.out.print("您于"+rs.getString(5)+"借阅了"+rs.getString(2)+",");
                	if(rs.getString(6)==null||rs.getString(6).length() <= 0)
                	{
                		System.out.println("尚未归还；");
                	}
                	else
                	{
                		System.out.println("于"+rs.getString(6)+"归还；");
                	}
                	if(!rs.previous()) return ;
            	}
            }
            else
            {
            	System.out.println("您没有任何借书记录！");
            	return ;
            }
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
