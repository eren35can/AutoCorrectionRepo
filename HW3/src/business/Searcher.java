package business;

import java.util.ArrayList;
import java.util.List;

public class Searcher implements Component {

	public Searcher() {
		
	}
	
	public void operation(Text text) {
		List<String> containingWords = new ArrayList<>();
		
		for (String word : text.getValue().split("\\s+")) {
			if (!word.contains(text.getCharacter())) {
				continue;
			}
			containingWords.add(word);
		}
		
		if (containingWords.size() == 0) {
			System.out.println("There is no containing words.");
		}
		
		System.out.print("\n"+ containingWords.size() +" words those contain '" + text.getCharacter() + "': ");
		for (String word : containingWords) {
			System.out.print(word);
		}
		System.out.println();
		
	}

	public void addOperation(Component operation) {
		
	}

	public void removeOperation(Component operation) {
		
	}

}
