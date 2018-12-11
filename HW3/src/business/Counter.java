package business;

public class Counter implements Component {
	
	public Counter() {
		
	}
	
	public void operation(Text text) {

		int characterCount = 0;
		int wordCount = -1;
		int lineCount = 0;
		int paragraphCount = -1;
		
		//just counts numbers and letters
		for (char character : text.getValue().replaceAll("[^\\w]", "").toCharArray()) {
			characterCount += 1;
		}
		
		//counts words by splitting from whitespace
		for (String word : text.getValue().split("\\s+")) {
			wordCount += 1;
		}
		
		//newline means (\n) newline
		//counts lines by splitting from newline signs (\n)
		for (String line : text.getValue().split("\\n")) {
			lineCount += 1;
		}
		
		//tab (/t) means new paragraph
		//count lines by splitting from tab sign (\t)
		for (String paragraph : text.getValue().split("\\t")) {
			paragraphCount += 1;
		}
		
		//prints out number of paragraphs, lines, words and characters
		System.out.println("Number of characters: " + characterCount + "\n" 
				+ "Number of words: " + wordCount + "\n" 
				+ "Number of lines: " + lineCount + "\n" 
				+ "Number of paragraph: " + paragraphCount + "\n");
		
	}

}
