package business;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextSaver implements Component {
	
	public TextSaver() {

	}
	
	//writes text to the file via File Operations class
	public void operation(Text text) {
		File file = new File(System.getProperty("user.home") + "/Desktop/" + text.getFileName());
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(file))) { 
	        bWriter.write(text.getValue());
	        bWriter.write("\n");
	        bWriter.flush();
	      }
	      catch (IOException e) {
	         e.printStackTrace();
	      }
	}

}
