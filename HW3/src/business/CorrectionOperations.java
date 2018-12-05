package business;

import autocorrection.AutoCorrect;

public class CorrectionOperations {
	
	private AutoCorrect autoCorrect;
	
	public CorrectionOperations() {
		this.autoCorrect = new AutoCorrect();
	}
	
	public void printSuggessions(Text text) {
		autoCorrect.initialize();
		System.out.println(autoCorrect.autoCorrect(text.getValue()));
	}
	
	

}
