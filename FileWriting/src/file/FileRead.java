package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * public class FileRead
 */

public class FileRead {

	public static void main(String []args){
		
		FileWrite write = new FileWrite(); 
		try {
			write.fileWriter("Rishab Ilwadi"); //Writing the string usinbg fileWriter() method of class FileWrite
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		FileReader reader=null;
		/*
		 * Reading contents from various files written
		 */
		try{
			File directory = new File("bin/file/temp");  //Opening directory as a file
			File[] listOfFiles = directory.listFiles();  //Listing contents of that directory
			
			char [] readContents;
			StringBuffer contents;
			/*
			 * Reading contents from all files in the directory one by one
			 */
			for (File file : listOfFiles) {
				if (file.isFile()) {
					readContents = new char[50];
					contents = new StringBuffer();
					reader = new FileReader(file);
					reader.read(readContents);
					System.out.println("Reading From file: " + file.getName());
					System.out.print(contents.append(readContents).toString() + "\n");
					}
		         
			} 
			
		}catch(FileNotFoundException exception){
			exception.printStackTrace();
		}
		catch(IOException exception){
			exception.printStackTrace();
		}
		finally{
			
			try {
				reader.close();
			} catch (IOException exception) {
				
				exception.printStackTrace();
			}
		}
}

}
