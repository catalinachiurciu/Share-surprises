package giveSurprises;

public class WaitTime {

	private long waitTime;

	public WaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public String toString() {
		return "Wait time is " + waitTime + ".";
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}
}
