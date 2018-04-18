package AssignmentJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.*;

public class AllFiles {
	
	/*
		JAVA Assignment - My Search Engine
		Author: Emily Murphy
		OS: MAC OSX
		Compiler: eclipse
		Due Date: 16-04-2018
	*/
	
	//method for searching a set File Path
	 public void listFiles()
	 {
		 

		String[] result = MyGui.f1.getText().toLowerCase().replaceAll(","," ").split(" "); // splits string entered by user and converts to lowercase
			
		ArrayList<String> list = new ArrayList<String>();// list of files containing search.
		
		ArrayList<String> listSim = new ArrayList<String>();// list of files containing similar word search.
			
		File dir = new File("/Users/default/Desktop/test"); // I set a default file path with .txt files in it

			
			
		 if(dir.exists()) // Directory exists then proceed.
		 { 
			 

			 for(File files : dir.listFiles()) // loop through all files in directory
			 {
				 
				 
				 if(!files.isFile()) continue; // checks if there is remaining files
					 try
					 {
						 for(int i = 0; i < result.length; i++) // checks open file for each word that is entered
						{

							 FileInputStream fis = new FileInputStream(files); //read through the file
							 BufferedReader in = new BufferedReader(new InputStreamReader(fis)); //Buffers the Fileinputstream
							 String readLine = ""; // used to hold each word read from file
							 int count=0; // counts number of times a word is found
							 int similar = 0;	
							 
							 while((readLine = in.readLine()) != null)// checks if bufferedreader is null
							 {
								 String[] words = readLine.toLowerCase().replaceAll(","," ").split(" ");
					  
								 for(String s : words) //loop for string s in string array
							 	{
							 		if(s.equals(result[i])) 
							 		{
							 			//counts times word was found
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

			 //sort lists
			 Collections.sort(list); //sorts the list of files containing words
			 
			 
			 Collections.sort(listSim); //sorts the list of files containing similar words
			 Collections.reverse(listSim);// puts top results first
			 
			 if(list.isEmpty()) // check if no words found
			 {

					 list.add("No Search results found or Suggestions \n"); // adds result message
					 
				 
			 }
			 

			 
			 MyGui.textArea.append("Strongest Search Results: \n"+list + "\n" + listSim + "\n");// print list of files with words entered in JtextArea.
			 
			
		 } 
		 else // error message no directory exists
		 {
			 MyGui.textArea.append("\n Directory doesn't exist.");
		 }

	}// end listFiles()

}// ends class AllFiles()



