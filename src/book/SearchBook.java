package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SearchBook {
	
	public static void searchBook() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		String keyword;
		System.out.println("请输入书籍名关键词（输入q返回，ALL展示所有书籍）：");
		keyword=input.next();
		if(keyword.equals("q")||keyword.equals("Q"))
		{
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
            sql = "select * from book where name like '%" + keyword +"%'";  
            if(keyword.equals("ALL"))
            {
            	sql = "select * from book";
            }
            ResultSet rs = stmt.executeQuery(sql);
            
            System.out.println("书名 ISBN 出版社 作者 价格 总馆藏 在库数量"); 
            
            while(rs.next())
            {
            System.out.print(rs.getString(1)); 
            System.out.print(" ");
            System.out.print(rs.getString(2)); 
            System.out.print(" ");
            System.out.print(rs.getString(3)); 
            System.out.print(" ");
            System.out.print(rs.getString(4)); 
            System.out.print(" ");
            System.out.print(rs.getString(5)); 
            System.out.print(" ");
            System.out.print(rs.getString(6)); 
            System.out.print(" ");
            System.out.println(rs.getString(7)); 
            }

            System.out.println("搜索结果输出完毕！"); 
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
