package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Reg {

	@SuppressWarnings("resource")
	public static int reg() throws IOException, SQLException
	{
		Scanner input=new Scanner(System.in);
		String username,password,nickname;
		System.out.print("请输入用户名:");
		username=input.next();
		System.out.print("请输入密码:");
		password=input.next();
		System.out.print("请输入昵称:");
		nickname=input.next();
		return RegConnect.regConnect(username, password,nickname);
	}
	
}
