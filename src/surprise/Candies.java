package surprise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Candies implements ISurprise {
	private static final ArrayList<CandyType> candies = new ArrayList<CandyType>(Arrays.asList(
					new CandyType("chocolate", 3), 
					new CandyType("jelly", 2), 
					new CandyType("fruit", 4),
					new CandyType("vanilla", 5)));

	private String candyName;
	private int candyNumber;
	private static final Random randomGenerator = new Random();

	private Candies(String candyName, int candyNumber) {
		this.candyName = candyName;
		this.candyNumber = candyNumber;
	}

	public static Candies generate() {
		int randomIdx = Candies.randomGenerator.nextInt(Candies.candies.size());
		CandyType randomCandyType = Candies.candies.get(randomIdx);
		int randomNumber = Candies.randomGenerator.nextInt(Candies.candies.size());
		CandyType randomNumberOfCandy = Candies.candies.get(randomNumber);
		if (randomNumber == 0) {
			randomNumber++;
		}
		System.out.println("Congrats! You generated a candy.");
		return new Candies(randomCandyType.getCandyName(), randomNumberOfCandy.getCandyNumber());
	}                                                        

	// coming from ISurprise interface
	@Override
	public void enjoy() {
		System.out.println("Enjoy your candy! You have " + this.candyNumber + " " + this.candyName + " candy/candies.");

	}

	// Getter and Setter for candyName and candyNumber
	public String getCandyName() {
		return candyName;
	}

	public void setCandyName(String candyName) {
		this.candyName = candyName;
	}

	public int getCandyNumber() {
		return candyNumber;
	}

	public void setCandyNumber(int candyNumber) {
		this.candyNumber = candyNumber;
	}

	@Override
	public String toString() {
		return "Candies [candyName=" + candyName + ", candyNumber=" + candyNumber + "]";
	}

}
