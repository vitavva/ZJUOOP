package book;

import java.sql.SQLException;
import java.util.Scanner;

public class ManageBook {

	@SuppressWarnings("resource")
	public static void manageBook() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		boolean loop = true;
		while(loop)
		{
			System.out.println("【1】 添加图书");
			System.out.println("【2】 删除图书");
			System.out.println("【3】 编辑图书");
			System.out.println("【4】 返回上一级菜单");
			System.out.print("请输入命令（仅输入数字）：");
			
			String res = input.next();
			
			if(res.equals("1"))
			{
				AddBook.addBook();
			}
			else if(res.equals("2"))
			{
				DeleteBook.deleteBook();
			}
			else if(res.equals("3"))
			{
				EditBook.editBook();
			}
			else if(res.equals("4"))
			{
				return ;
			}
			else 
			{
				System.out.println("输入错误，请重试！");
			}
		}
	
	}
}
