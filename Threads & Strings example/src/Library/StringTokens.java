package Library;

import java.util.StringTokenizer;
import java.io.*;
/*
 * package Library
 * imports java.lang,java.io,java.util.StringTokenizer 
 * 
 * public class StringTokens
 * 
 * Used for spliting the input string into tokens using delimeter as ","
 */
public class StringTokens {

	public static void main(String []args)throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String address;
		
		System.out.println("Enter address: ");
		address=reader.readLine();
		address=address.replace("\",\"","\\\\");
		System.out.println(address);
		StringTokenizer tokens=new StringTokenizer(address,"\\\\");
		
		while(tokens.hasMoreTokens()){
		     System.out.println(tokens.nextToken());
		}
	}
}
