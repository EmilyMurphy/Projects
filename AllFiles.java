package testcodeass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class AllFiles {
	
	/*
	JAVA First Draft - My Search Engine
	Emily Murphy
	*/
	
	 public void listFiles()
	 {
		 

			

		 String[] result = MyGui.f1.getText().split(" "); // splits string entered by user by spaces
			
			ArrayList<String> list = new ArrayList<String>(); // list of files.
			
			File dir = new File("/Users/default/Desktop/test"); // I set a default directory with .txt files in it

			
			
		 if(dir.exists()) // Directory exists then proceed.
		 { 
			 

			 for(File files : dir.listFiles()) // loop through all files in directory
			 {
				 
				 
				 if(!files.isFile()) continue; // checks if there is remaining files
					 try
					 {
						 for(int i = 0; i < result.length; i++) // checks open file for each word that is entered
						{

							 FileInputStream fis = new FileInputStream(files); //read all chars in file
							 BufferedReader in = new BufferedReader(new InputStreamReader(fis));
							 String readLine = "";
							 int numRead=0;
							 while((readLine = in.readLine()) != null)// readLine = in.readLine();

							 {
								 String[] words = readLine.split(" ");
					  
								 for(String s : words) 
							 	{
							 		if(s.equals(result[i])) 
							 		{
							 			numRead++;
							 			list.add("Word: "+result[i]+ " found in: "+files.getName()+ " "+ numRead + " times."+"\n");
							 		}
							 		
							 	}
								 
								 
							 }
							 fis.close();
					
					
						}
					 }
				 catch(Exception e)// error message for file
				 {
					 System.out.print("\n\t Error processing file : "+files.getName());
				 }
				 

			 }

			 MyGui.textArea.append(list + "\n");// print list of files with words entered.
			
			
		 } 
		 else // error message no directory exists
		 {
			 System.out.print("\n Directory doesn't exist.");
		 }
		
	}
	 
}



