package user;

import java.sql.SQLException;
import java.util.Scanner;

public class AddUser {

	@SuppressWarnings("resource")
	public static void addUser() throws SQLException
	{
		Scanner input=new Scanner(System.in);
		String username,password,nickname;
		System.out.print("请输入用户名:");
		username=input.next();
		System.out.print("请输入密码:");
		password=input.next();
		System.out.print("请输入昵称:");
		nickname=input.next();

		int tres = RegConnect.regConnect(username, password,nickname);
		if(tres==1)
		{
			System.out.println("添加成功！");
		}
		else if(tres==-1)
		{
			System.out.println("添加失败！用户已存在！");
		}
		else 
		{
			System.out.println("添加失败！请重试或联系数据库管理员！");
		}
	}
}
