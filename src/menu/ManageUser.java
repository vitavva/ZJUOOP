package menu;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import user.AddUser;
import user.DeleteUser;
import user.EditUser;
import user.ShowUser;

public class ManageUser {
	@SuppressWarnings("resource")
	public static void manageUser() throws IOException, SQLException
	{
		Scanner input=new Scanner(System.in);
		boolean loop = true;
		while(loop)
		{
			System.out.println("【1】 浏览用户");
			System.out.println("【2】 添加用户");
			System.out.println("【3】 删除用户");
			System.out.println("【4】 用户权限管理");
			System.out.println("【5】 返回上一级菜单");
			System.out.print("请输入命令（仅输入数字）：");
			
			String res = input.next();
			
			if(res.equals("1"))
			{
				ShowUser.showUser();
			}
			else if(res.equals("2"))
			{
				AddUser.addUser();
			}
			else if(res.equals("3"))
			{
				DeleteUser.deleteUser();
			}
			else if(res.equals("4"))
			{
				EditUser.editUser();
			}
			else if(res.equals("5"))
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
