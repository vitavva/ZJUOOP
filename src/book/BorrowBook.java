package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BorrowBook {

	@SuppressWarnings("resource")
	public static void borrowBook(String[] profile) throws SQLException
	{

		Scanner input=new Scanner(System.in);
		String isbn;
		System.out.print("请输入ISBN码（978开头的十三位数字）:");
		isbn=input.next();
		String[] bookprofile = GetBook.getBook(isbn);
		if(bookprofile[1].equals("0000000000000"))
		{
			System.out.println("ISBN输入错误，该图书不存在！");
			return ;
		}
		System.out.println("您要租借的图书信息如下：");
		System.out.println("书名："+bookprofile[0]);
		System.out.println("ISBN："+bookprofile[1]);
		System.out.println("出版社："+bookprofile[2]);
		System.out.println("作者："+bookprofile[3]);
		System.out.println("价格："+bookprofile[4]);
		System.out.println("总馆藏："+bookprofile[5]);
		System.out.println("剩余库存："+bookprofile[6]);
		System.out.print("输入Y确认租借，其他任意键取消");
		String conf = input.next();
		if(conf.equals("Y")||conf.equals("y"))
		{
			int remain = Integer.parseInt( bookprofile[6] ); 
			if(remain<=0)
			{
				System.out.println("库存不足！");
				return ;
			}
			remain--;
			
			//获取时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date date=new java.util.Date();  
			String time=df.format(date);  
			
			Connection conn = null;
	        String sql;
	        // MySQL的JDBC URL编写方式：jdbc:mysql://主机名称：连接端口/数据库的名称?参数=值
	        String url = "jdbc:mysql://115.29.221.52:3306/oop?"
	                + "user=ooppublic&password=ooppublic&useUnicode=true&characterEncoding=UTF8";

	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
	            conn = DriverManager.getConnection(url);
	            Statement stmt = conn.createStatement();
	            //检查是否已借过
	            sql = "select * from record where username = '"+profile[0]+"' and bookisbn = '"+isbn+"' and returntime is null";
	            ResultSet rs = stmt.executeQuery(sql);
	            if(rs.next())
	            {
	            	System.out.println("你已经借阅了一本相同的书籍了，不能重复借阅！");
	            	return ;
	            }
	            //修改书籍库存
	            sql = "update book set remain = '" + remain + "'  where isbn = '"+isbn + "'";  
	            stmt.executeUpdate(sql);
	            //修改个人已借阅
	            sql = "select * from user where username = '"+profile[0]+"'";
	            rs = stmt.executeQuery(sql);
	            rs.next();
	            int borrowed = rs.getInt(5);
	            borrowed++;
	            sql = "update user set borrowed = '" + borrowed + "'  where username = '"+profile[0] + "'";  
	            stmt.executeUpdate(sql);
		        //添加出借记录
	            sql = "insert into record(bookname,bookisbn,username,borrowtime) "
	            		+ "values('"+bookprofile[0]+"','"+isbn+"','"+profile[0]+"','"+time+"')";
	            stmt.executeUpdate(sql);
	        } catch (SQLException e) {
	            System.out.println("MySQL操作错误");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            conn.close();
	        }
	        
			
	        System.out.println("借书完成！");
			
			
		}
		return ;
	}
}
