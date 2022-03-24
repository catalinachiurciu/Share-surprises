package surprise;

public class Saying {

	private String text;
	private String author;

	// Constructor
	public Saying(String text, String author) {
		this.text = text;
		this.author = author;
	}

	// Getter and Setter
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
}
