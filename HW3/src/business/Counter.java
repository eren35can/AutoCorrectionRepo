package business;

public class Counter implements Component {

	private int characterCount = 0;
	private int wordCount = 0;
	private int lineCount = 0;
	private int paragraphCount = -1;
	
	public Counter() {
		
	}
	
	public void operation(Text text) {

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
