package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetBook {

	public static String[] getBook(String isbn) throws SQLException
	{
		String[] bookprofile = new String[7];
		bookprofile[1]="0000000000000";
		
		Connection conn = null;
        String sql;
        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

        
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select * from book where isbn = \""+isbn + "\"";  
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
            bookprofile[0]=rs.getString(1); 
            bookprofile[1]=rs.getString(2); 
            bookprofile[2]=rs.getString(3); 
            bookprofile[3]=rs.getString(4); 
            bookprofile[4]=rs.getString(5); 
            bookprofile[5]=String.valueOf(rs.getInt(6)); 
            bookprofile[6]=String.valueOf(rs.getInt(7)); }
        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
		
		return bookprofile;
	}
}
