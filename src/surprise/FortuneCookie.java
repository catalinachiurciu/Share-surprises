package surprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

//Class receives the message at the object construction and displays it at output
public class FortuneCookie implements ISurprise {

	private static final ArrayList<Saying> sayings = new ArrayList<Saying>(Arrays.asList(
			new Saying("\"All our dreams can come true, if we have the courage to pursue them.\"", "Walt Disney"),
			new Saying("\"It’s hard to beat a person who never gives up.\"", "Babe Ruth"),
			new Saying("\"Everything you can imagine is real.\"", "Pablo Picasso"),
			new Saying("\"It’s Monday… time to motivate and make dreams and goals happen. Let’s go!\"",
					"Heather Stillufsen"),
			new Saying("\"You can waste your lives drawing lines. Or you can live your life crossing them.\"",
					"Shonda Rhimes"),
			new Saying("\"If opportunity doesn’t knock, build a door.\"", "Kurt Cobain"),
			new Saying("\"If everything seems to be under control, you’re not going fast enough.\"", "Mario Andretti"),
			new Saying(
					"\"mesGood. Better. Best. Never let it rest. ‘Til your good is better and your better is best.\"",
					"St. Jerome"),
			new Saying("\"In the middle of every difficulty lies opportunity.\"", "Albert Einstein"),
			new Saying("\"Doubt kills more dreams than failure ever will.\"", "Suzy Kassem"),
			new Saying("\"Focus on being productive instead of busy.\"", "Tim Ferriss"),
			new Saying("\"You don’t need to see the whole staircase, just take the first step.\"",
					" Martin Luther King Jr."),
			new Saying("\"Try not to become a man of success, but rather become a man of value.\"", "Albert Einstein"),
			new Saying("\"If you fall – I’ll be there.\"", "Floor"),
			new Saying("\"If you think you’re too small to make a difference, try sleeping with a mosquito.\"",
					"Dalai Lama"),
			new Saying("\"Success is going from failure to failure without losing your enthusiasm.\"",
					"Winston Churchill"),
			new Saying("\"Everything is hard before it is easy.\"", "Goethe"),
			new Saying("\"Remember, today is the tomorrow you worried about yesterday.\"", "Dale Carnegie"),
			new Saying("\"Education is learning what you didn’t even know you didn’t know.\"", "Daniel J. Boorstin"),
			new Saying("\"You must expect great things of yourself before you can do them.\"", "Michael Jordan")));

	private String text;
	private String author;
	private static final Random randomGenerator = new Random();

	private FortuneCookie(String text, String author) {
		this.text = text;
		this.author = author;
	}

	//Generates a random number and chooses the coresp. message from arrayList
	//It'll create a (new) surprise

	public static FortuneCookie generate() {
		int randomIdx = FortuneCookie.randomGenerator.nextInt(FortuneCookie.sayings.size());
		Saying randomSaying = FortuneCookie.sayings.get(randomIdx);
		System.out.println("Congrats! You generated a fortune cookie.");
		return new FortuneCookie(randomSaying.getText(), randomSaying.getAuthor());
	}

	// coming from ISurprise
	@Override
	public void enjoy() {
		System.out.println("Enjoying a fortune cookie...\nText: " + this.text + " - " + this.author);
	}

	// Getter and setter
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

	@Override
	public String toString() {
		return "FortuneCookie [text=" + text + ", author=" + author + "]";
	}

}
