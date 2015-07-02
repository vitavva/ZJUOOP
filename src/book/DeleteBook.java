package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteBook {

	@SuppressWarnings("resource")
	public static void deleteBook() throws SQLException
	{
		String conf;
		Scanner input=new Scanner(System.in);
		String isbn;
		System.out.print("请输入要删除的ISBN:");
		isbn=input.next();
		System.out.print("该操作不可逆！请输入Y确认，任意键取消：");
		conf=input.next();
		if(conf.equals("Y")||conf.equals("y"))
		{
			String[] bookprofile = GetBook.getBook(isbn);
			if(bookprofile[1].equals("0000000000000"))
			{
				System.out.println("该图书不存在！");
				return ;
			}
			Connection conn = null;
	        String sql;
	        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
	        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
	                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
	            conn = DriverManager.getConnection(url);
	            Statement stmt = conn.createStatement();
	            sql = "delete from book where isbn = '"+isbn + "'";  
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            System.out.println("MySQL操作错误");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            conn.close();
	        }
			
			System.out.println("删除完毕！");
			
		}
		else return ;
	}
}
