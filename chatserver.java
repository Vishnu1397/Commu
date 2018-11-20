import java.net.*;
import java.io.*;

public class chatserver
{
	public static void main(String args[])throws Exception
	{
		ServerSocket ss=new ServerSocket(2000);
		Socket sk=ss.accept();
		BufferedReader cin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream cout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while(true)
		{
			System.out.println("Client");
			s=cin.readLine();
			if(s.equalsIgnoreCase("Kill"))
			{
				cout.println("Out");
				break;
			}
			System.out.println("Client: "+s+"\n");
			System.out.println("Server :");
			s=stdin.readLine();
			cout.println(s);
		}
		ss.close();
		sk.close();
		cin.close();
		cout.close();
		stdin.close();
	}
}