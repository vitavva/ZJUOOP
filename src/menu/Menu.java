package menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import user.ChangeNickname;
import book.BorrowBook;
import book.ReturnBook;
import book.SearchBook;
import book.SelectBook;
import book.SelectPersonalRecord;

public class Menu {

	@SuppressWarnings("resource")
	public static void menu(String[] profile) throws IOException, SQLException
	{
		Scanner input=new Scanner(System.in);
		boolean loop = true;
		System.out.print("欢迎您，");
		if(profile[3].equals("2")) System.out.print("管理员");
		System.out.print(profile[2]);
		System.out.println("!");
		while(loop)
		{
			System.out.println("【1】 借书");
			System.out.println("【2】 还书");
			System.out.println("【3】 查询书籍状态");
			System.out.println("【4】 查询个人记录");
			System.out.println("【5】 书籍检索");
			System.out.println("【6】 修改昵称");
			if(profile[3].equals("2"))System.out.println("【7】 管理员菜单");
			System.out.println("【0】 退出登录");
			System.out.print("请输入命令（仅输入数字）：");
			
			String res = input.next();
			
			if(res.equals("1"))
			{
				BorrowBook.borrowBook(profile);
			}
			else if(res.equals("2"))
			{
				ReturnBook.returnBook(profile);
			}
			else if(res.equals("3"))
			{
				SelectBook.selectBook();
			}
			else if(res.equals("4"))
			{
				SelectPersonalRecord.selectPersonalRecord(profile);
			}
			else if(res.equals("5"))
			{
				SearchBook.searchBook();
			}
			else if(res.equals("6"))
			{
				ChangeNickname.changeNickname(profile);
			}
			else if((res.equals("7"))&&profile[3].equals("2"))
			{
				AdminMenu.adminMenu(profile);
			}
			else if(res.equals("0"))
			{
				Main.main(null);
			}
			else 
			{
				System.out.println("输入错误，请重试！");
			}
		}
	}
}
