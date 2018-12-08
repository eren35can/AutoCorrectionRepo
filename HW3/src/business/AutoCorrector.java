package business;

import autocorrection.AutoCorrect;

public class AutoCorrector implements Component {
	
	public AutoCorrector() {
		
	}
	
	//automatically corrects the given text
	public void operation(Text text) {
		AutoCorrect ac = new AutoCorrect();
		ac.initialize();
		
		String suggestions;
		
		//splitting text into words and checking each word if it is misspelled
		for (String word : text.getValue().split("\\s+")) {
			suggestions = ac.autoCorrect(word);
			if (suggestions == "No suggestions.") {
				continue;
			}
			//if word is misspelled changing its value
			text.setValue(text.getValue().replace(word, suggestions.split("\\s+")[0]));
		}

	}

}
