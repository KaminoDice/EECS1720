package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UserInfo {
	static public ArrayList<User> userList=new ArrayList<>();
	static 
	{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream("src/user.txt"), "UTF-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s;
		User user;
//		int i=1;
		try {
			while ((s = in.readLine()) != null)
			{
				StringTokenizer t = new StringTokenizer(s, " ");
				String userName=t.nextToken();
				String userPassword=t.nextToken();
				int userScore=Integer.parseInt(t.nextToken());
				user=new User(userName,userPassword,userScore);
				userList.add(user);
//				System.out.println(i+":"+user.toString());
//				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void method(String conent) {
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/user.txt", true)));
			out.write(conent + "\r\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
