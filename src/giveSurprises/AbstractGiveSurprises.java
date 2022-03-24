package giveSurprises;

import java.util.concurrent.TimeUnit;

import container.IBag;
import createContainer.BagFactory;
import surprise.ISurprise;

public abstract class AbstractGiveSurprises {
	private IBag container;
	private BagFactory bagFactory;
	private long waitTime;

	public AbstractGiveSurprises(String containerType, long waitTime) {
		this.bagFactory = BagFactory.getInstance();
		this.container = bagFactory.makeBag(containerType);
		this.waitTime = waitTime;
	}

	public void put(IBag newSurprise) {
		this.container.put(newSurprise);
	}

	public void put(ISurprise surprise) {
		this.container.put(surprise);
	}

	public IBag getContainer() {
		return this.container;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	public void give() {
		if (this.getContainer().isEmpty()) {
			System.out.println("There are no more suprises in the container.");
		}
		this.getContainer().takeOut().enjoy();
		giveWithPassion();
		System.out.println("Happy holidays!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public void giveAll() {
		while (!this.getContainer().isEmpty()) {
			ISurprise nextSurprise = this.getContainer().takeOut();
			nextSurprise.enjoy();
			this.giveWithPassion();
			try {
				TimeUnit.SECONDS.sleep(getWaitTime());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Happy holidays!");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	public boolean isEmpty() {
		return this.container.isEmpty();
	}

	abstract void giveWithPassion();

}