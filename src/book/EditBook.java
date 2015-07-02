package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EditBook {

	@SuppressWarnings("resource")
	public static void editBook() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		String isbn;
		System.out.print("请输入要操作的ISBN:");
		isbn=input.next();
		String[] bookprofile = GetBook.getBook(isbn);
		if(bookprofile[1].equals("0000000000000"))
		{
			System.out.println("该图书不存在！");
			return ;
		}
		System.out.println("您要修改的图书信息如下：");
		System.out.println("(1)书名："+bookprofile[0]);
		System.out.println("(2)ISBN："+bookprofile[1]);
		System.out.println("(3)出版社："+bookprofile[2]);
		System.out.println("(4)作者："+bookprofile[3]);
		System.out.println("(5)价格："+bookprofile[4]);
		System.out.println("(6)总馆藏："+bookprofile[5]);
		System.out.println("(7)剩余库存："+bookprofile[6]);
		String no=null;
		while(true)
		{
			System.out.print("请输入要修改的项目编号，若修改完毕输入Y进行更改：");
			no=input.next();
			if(no.equals("Y")||no.equals("y")) break;
			System.out.print("请输入该项目修改后的值：");
			bookprofile[Integer.parseInt(no)-1]=input.next();
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
            sql = "insert into book(name,isbn,publisher,author,price,total,remain) "
            		+ "values('"+bookprofile[0]+"','"+bookprofile[1]+"','"+bookprofile[2]+"','"+bookprofile[3]+"','"+bookprofile[4]+"','"+bookprofile[5]+"','"+bookprofile[6]+"')";
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
