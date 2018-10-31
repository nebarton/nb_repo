package msbuddy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	
	private String path;
	public ReadFile (String file_path) {
		path = file_path;
		
	}
	//create a method that returns all lines of code from the text file. Lines will be held in an array
	//Add IOException to any method that deals with reading a text file
	
	public String[] OpenFile() throws IOException {
		
		//FileReader reads the characters of the text file, whole lines by using the BufferedReader
		// Two new objects are being created (1) FileReader and BufferedReader
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		//Set up an array to hold the lines of text
		int numberOfLines = 3;
		String[] textData = new String[numberOfLines];
		
		//Need a loop to put the lines of text from the file into each position in the array
		int i;
		for(i=0; 1< numberOfLines; i++) {
			textData[i]=textReader.readLine();
		}
		
	}

}
