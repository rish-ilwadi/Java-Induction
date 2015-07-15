package Library;

import java.util.StringTokenizer;
import java.io.*;
public class StringTokens {

	public static void main(String []args)throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String address;
		System.out.println("Enter address: ");
		address=reader.readLine();
		StringTokenizer tokens=new StringTokenizer(address,"\",\"");
		while(tokens.hasMoreTokens()){
		     System.out.println(tokens.nextToken());
		}
	}
}
