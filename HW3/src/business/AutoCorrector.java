package business;

import autocorrection.AutoCorrect;

public class AutoCorrector implements Component {
	
	public AutoCorrector() {
		
	}
	
	public void operation(Text text) {
		AutoCorrect ac = new AutoCorrect();
		ac.initialize();
		
		String suggestions;
		
		for (String word : text.getValue().split("\\s+")) {
			suggestions = ac.autoCorrect(word);
			if (suggestions == "No suggestions.") {
				continue;
			}
			text.setValue(text.getValue().replace(word, suggestions.split("\\s+")[0]));
		}

	}

	public void addOperation(Component operation) {}

	public void removeOperation(Component operation) {}

}
