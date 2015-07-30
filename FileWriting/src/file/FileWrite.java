package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/*
 * public class FileWrite
 */
public class FileWrite {

	private File file;
	/*
	 * method: public void fileWriter(String contents)
	 * throws IOException
	 * Takes a string as an argument to be written on files
	 * Used for writing the string to a file till its size is less than equal to 8 bytes
	 * else starts writing to a new file
	 */ 
	public void fileWriter(String contents) throws IOException{
		
		FileWriter fileWrite = null;
		char[] content=contents.toCharArray();
		try{
			
			fileWrite = new FileWriter("bin/file/temp/temp.txt");
			file = new File("bin/file/temp/temp.txt");
			int length = content.length;
			int counter = 0;
			Integer count=new Integer(1);
			while(counter<length){

				/*
				 * Checking file size.
				 * If size > 8 bytes
				 * then creates a new file & starts writing the remaining contents on it 
				 */
				if(file.length() >= 8){
					fileWrite.close();
					fileWrite =  new FileWriter("bin/file/temp/temp" + count.toString() + ".txt"); //creating new file
					file = new File("bin/file/temp/temp" + count.toString() + ".txt");
					count++;				
				}
				fileWrite.write(content[counter]);
				fileWrite.flush();
				System.out.println(file.length());
				counter++;

			}
			
		}catch(FileNotFoundException exception){
			exception.printStackTrace();
		}
	}


}
