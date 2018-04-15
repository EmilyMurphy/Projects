package testcodeass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectFile {
	
	/*
	JAVA Assignment - My Search Engine
	Author: Emily Murphy
	OS: MAC OSX
	Compiler: eclipse
	Due Date: 16-04-2018
	 */
	
	//method for searching a Specific File Path
	 public void StrongFiles()
	 {
		 
		File dir = new File(MyGui.f2.getText());

		String[] result = MyGui.f1.getText().toLowerCase().split(" ");
			
		ArrayList<String> list = new ArrayList<String>(); // list of files.
		ArrayList<String> listSim = new ArrayList<String>();
			

	
		 if(dir.exists()) // Directory exists then proceed.
		 { 
			 

			 for(File files : dir.listFiles())
			 {
				 
				 
				 if(!files.isFile()) continue; // checks if there is remaining files
				 try
				 {
					 for(int i = 0; i < result.length; i++) // checks open file for each word that is entered
					{

						 FileInputStream fis = new FileInputStream(files); //read all chars in file
						 BufferedReader in = new BufferedReader(new InputStreamReader(fis)); //Buffers the Fileinputstream
						 String readLine = ""; // used to hold each word read from file
						 int count=0; // counts number of times a word is found
						 int similar=0;	
						 
						 while((readLine = in.readLine()) != null)// readLine = in.readLine();
						 {
							 String[] words = readLine.toLowerCase().replaceAll(","," ").split(" ");
				  
							 for(String s : words) 
						 	{
						 		if(s.equals(result[i])) 
						 		{
						 			count++;

						 		}
						 		else
						 		{
						 			//search for similar words if word not found
						 			if(s.startsWith(result[i]))
						 			{
						 				//counts times similar word was found
						 				similar++;
						 				
						 				//add similar words found
						 				listSim.add(" Similar Word: "+ s + " was found in: "+files.getName()+ " "+ similar + " times."+"\n");
						 			}
						 		}

						 	}
							 
							 
							 
						 }
						 
						 if(count>0) // check if matching words were found
						 {
							 //adds to list what word was found and how many times
							 list.add(" Word: "+result[i]+ " was found in: "+files.getName()+ " "+ count + " times."+"\n"); 
						 }
						 

						 fis.close(); // close the fileInputStream

				
					}

				 }
			 catch(Exception e)// error message for file
			 {
				 MyGui.textArea.append("\n\t Error processing file : "+files.getName());
			 }
			 

		 }

		 
		 Collections.sort(list); //sorts the list of files containing word
		 Collections.reverse(list);// puts top results first
		 
		 if(list.isEmpty()) // check if no words found
		 {

				 list.add("No Search results found or Suggestions \n"); // adds result message
				 //list.addAll(listSim); // adds suggestions
			 
		 }
		 

		 
		 MyGui.textArea.append("Strongest Search Results: \n"+list + "\n" + listSim + "\n");// print list of files with words entered in JtextArea.
		 
		
		 } 
		 else // error message no directory exists
		 {
			 MyGui.textArea.append("\n Directory doesn't exist.");
		 }

	 }// end StrongFiles()

}// ends class AllFiles()

