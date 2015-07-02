package user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {

	@SuppressWarnings("resource")
	public static String login() throws IOException, SQLException
	{
		Scanner input=new Scanner(System.in);
		String username,password;
		System.out.println("请输入用户名和密码登陆：");
		System.out.print("login as:");
		username=input.next();
		System.out.print("password:");
		password=input.next();
		if(LoginConnect.loginConnect(username, password)==true)
		{
			return username;
		}
		else
		{
			return "FAILED19940531";
		}
	}
	
}
