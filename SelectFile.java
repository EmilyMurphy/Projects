package testcodeass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectFile {
	
	/*
	JAVA First Draft - My Search Engine
	Emily Murphy
	*/

	 public void StrongFiles()
	 {
		 
			File dir = new File(MyGui.f2.getText());

		 String[] result = MyGui.f1.getText().split(" ");
			
			ArrayList<String> list = new ArrayList<String>(); // list of files.
			
			

	
		 if(dir.exists()) // Directory exists then proceed.
		 { 
			 

			 for(File files : dir.listFiles())
			 {
				 
				 
				 if(!files.isFile()) continue;
					 try
					 {
						 for(int i = 0; i < result.length; i++)
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
				 catch(Exception e)
				 {
					 System.out.print("\n\t Error processing file : "+files.getName());
				 }
				 

			 }

			 MyGui.textArea.append(list + "\n");
			
			 
		 } // IF directory exists then only process.
		 else
		 {
			 System.out.print("\n Directory doesn't exist.");
		 }
		
	}
}


