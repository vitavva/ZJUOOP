package menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import book.BookDetail;
import book.ManageBook;

public class AdminMenu {
	@SuppressWarnings("resource")
	public static void adminMenu(String[] profile) throws IOException, SQLException
	{
		Scanner input=new Scanner(System.in);
		boolean loop = true;
		System.out.print("欢迎您，管理员");
		System.out.print(profile[2]);
		System.out.println("!");
		while(loop)
		{
			System.out.println("【1】 书籍管理");
			System.out.println("【2】 用户管理");
			System.out.println("【3】 书籍动态查询");
			System.out.println("【4】 返回用户菜单");
			System.out.print("请输入命令（仅输入数字）：");
			
			String res = input.next();
			
			if(res.equals("1"))
			{
				ManageBook.manageBook();
			}
			else if(res.equals("2"))
			{
				ManageUser.manageUser();
			}
			else if(res.equals("3"))
			{
				BookDetail.bookDetail();
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
