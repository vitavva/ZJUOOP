package book;

import java.sql.SQLException;
import java.util.Scanner;

public class SelectBook {

	@SuppressWarnings("resource")
	public static void selectBook() throws SQLException
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
		System.out.println("您所查询的图书信息如下：");
		System.out.println("书名："+bookprofile[0]);
		System.out.println("ISBN："+bookprofile[1]);
		System.out.println("出版社："+bookprofile[2]);
		System.out.println("作者："+bookprofile[3]);
		System.out.println("价格："+bookprofile[4]);
		System.out.println("总馆藏："+bookprofile[5]);
		System.out.println("剩余库存："+bookprofile[6]);
		return ;
	}
}
