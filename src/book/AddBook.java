package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddBook {

	@SuppressWarnings("resource")
	public static void addBook() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		String name,isbn,publisher,author,price,total,remain;
		System.out.println("请输入书籍信息：");
		System.out.print("书名：");
		name=input.next();
		System.out.print("ISBN：");
		isbn=input.next();
		System.out.print("出版社：");
		publisher=input.next();
		System.out.print("作者：");
		author=input.next();
		System.out.print("价格：");
		price=input.next();
		System.out.print("总馆藏：");
		total=input.next();
		System.out.print("剩余库存：");
		remain=input.next();
		System.out.print("按Y确认添加，任意键取消：");
		String resString = input.next();
		if(resString.equals("Y")||resString.equals("y"))
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
	            
	            //检查是否存在
	            sql = "select isbn from book where isbn = \""+isbn + "\"";  
	            ResultSet rs = stmt.executeQuery(sql);
	            if(rs.next())
	            {
	            	System.out.println("该ISBN已存在！");
	            	return;
	            }
	            
	            sql = "insert into book(name,isbn,publisher,author,price,total,remain) "
	            		+ "values('"+name+"','"+isbn+"','"+publisher+"','"+author+"','"+price+"','"+total+"','"+remain+"')";
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            System.out.println("MySQL操作错误");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            conn.close();
	        }
	        
		}
		System.out.println("添加完毕！");
		return;
		
	}
}
