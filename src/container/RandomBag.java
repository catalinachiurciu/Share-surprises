package container;

import java.util.ArrayList;
import java.util.Random;
import surprise.ISurprise;

public class RandomBag implements IBag {
	private ArrayList<ISurprise> surprises;
	private static final Random randomGenerator = new Random();

	public RandomBag() {
		this.surprises = new ArrayList<ISurprise>();
	}

	@Override
	public void put(ISurprise newSurprise) {
		this.surprises.add(newSurprise);

	}

	@Override
	public void put(IBag bagOfSurprises) {
		while (!bagOfSurprises.isEmpty()) {
			ISurprise nextSurprise = bagOfSurprises.takeOut();
			this.put(nextSurprise);
		}
	}

	@Override
	public ISurprise takeOut() {
		if (this.isEmpty()) {
			return null;
		}
		int randomIdx = randomGenerator.nextInt(this.surprises.size());
		ISurprise nextSurprise = this.surprises.get(randomIdx);
		this.surprises.remove(randomIdx);
		return nextSurprise;
	}

	@Override
	public boolean isEmpty() {
		return surprises.isEmpty();
	}

	@Override
	public int size() {
		return surprises.size();
	}
}
