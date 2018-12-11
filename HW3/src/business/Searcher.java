package business;

import java.util.ArrayList;
import java.util.List;

public class Searcher implements Component {

	public Searcher() {
		
	}
	
	public void operation(Text text) {
		//list for storing the words that contains given characters
		List<String> containingWords = new ArrayList<>();
		
		//splitting the text into words
		for (String word : text.getValue().split("\\s+")) {
			if (!word.contains(text.getCharacter())) {
				continue;
			}
			//if word contains the given characters it add to the list
			containingWords.add(word);
		}
		
		//if there is no words that contain given characters it prints a message
		if (containingWords.size() == 0) {
			System.out.println("There is no containing words.");
		}
		
		//printing all words that containg given characters
		System.out.print("\n"+ containingWords.size() +" words those contain '" + text.getCharacter() + "': ");
		for (String word : containingWords) {
			System.out.print(word);
			System.out.print(" ");
		}
		System.out.println();
		
	}

}
