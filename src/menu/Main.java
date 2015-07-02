package menu;

import java.io.IOException;
import java.sql.SQLException;

import user.GetUser;
import user.Login;
import user.Reg;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		
		//欢迎界面
		
		boolean loop = true;
		System.out.println("欢迎使用图书管理系统！");
		while(loop)
		{
			System.out.println("【1】 登陆");
			System.out.println("【2】 注册");
			System.out.println("【3】 退出");
			System.out.print("请输入命令（仅输入数字）：");
			
			char res = (char)System.in.read();
			
			if(res=='1')
			{
				String tres = Login.login();
				if(tres.equals("FAILED19940531"))
				{
					System.out.println("登录失败！");
				}
				else 
				{
					System.out.println("登陆成功！");
					String[] profile = GetUser.getUser(tres);
					Menu.menu(profile);
				}
			}
			else if(res=='2')
			{
				int tres = Reg.reg();
				if(tres==1)
				{
					System.out.println("注册成功！");
				}
				else if(tres==-1)
				{
					System.out.println("注册失败！用户已存在！");
				}
				else 
				{
					System.out.println("注册失败！请重试或联系管理员！");
				}
			}
			else if(res=='3')
			{
				System.out.println("谢谢使用，再见！");
				System.exit(0);
			}
			else 
			{
				System.out.println("输入错误，请重试！");
			}
		}
	}

}
