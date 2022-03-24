package surprise;

import java.util.ArrayList;
import java.util.Arrays;

public class MinionToy implements ISurprise {

	private static final ArrayList<MinionToyCollection> minionToys = new ArrayList<MinionToyCollection>(Arrays.asList(
			new MinionToyCollection("Bob"), 
			new MinionToyCollection("Kevin"), 
			new MinionToyCollection("Stuart"),
			new MinionToyCollection("Carl"), 
			new MinionToyCollection("Tim")));

	private String minionName;
	private static int counter = 0;

	private MinionToy(String minionName) {
		this.minionName = minionName;
	}

	public static MinionToy generate() {
		MinionToyCollection minionIndex = MinionToy.minionToys.get(counter % minionToys.size());
		counter++;
		System.out.println("Congrats! You generated a minion toy.");
		return new MinionToy(minionIndex.getMinionName());
	}

	// Coming from ISurprise
	@Override
	public void enjoy() {
		System.out.println("Enjoying a minion toy named " + this.minionName + ".");
	}

	// Getter and Setter
	public String getMinionName() {
		return minionName;
	}

	public void setMinionName(String minionName) {
		this.minionName = minionName;
	}

	@Override
	public String toString() {
		return "MinionToy [minionName=" + minionName + "]";
	}

}
