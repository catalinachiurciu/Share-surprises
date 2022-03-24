package surprise;

public class CandyType {
	
	private String candyName;
	private int candyNumber;

	// Constructor
	public CandyType(String candyName, int candyNumber) {
		this.candyName = candyName;
		this.candyNumber = candyNumber;
	}

	// Setter and Getter
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
}
