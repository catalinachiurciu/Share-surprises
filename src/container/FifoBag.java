package container;

import java.util.ArrayList;
import surprise.ISurprise;

public class FifoBag implements IBag {
	private ArrayList<ISurprise> surprises;

	public FifoBag() {
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
		ISurprise nextSurprise = this.surprises.get(0);
		this.surprises.remove(0);
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
