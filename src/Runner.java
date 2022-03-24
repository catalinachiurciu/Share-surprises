import java.util.Scanner;

import container.IBag;
import createContainer.BagFactory;
import giveSurprises.GiveSurpriseAndApplause;
import giveSurprises.GiveSurpriseAndHug;
import giveSurprises.GiveSurpriseAndSing;
import giveSurprises.WaitTime;
import surprise.Candies;
import surprise.FortuneCookie;
import surprise.MinionToy;

public class Runner {

	private static Scanner sc = new Scanner(System.in);
	private static WaitTime waitTime = new WaitTime(0);
	private static BagFactory bag = BagFactory.getInstance();l
	private static GiveSurpriseAndApplause applause;
	private static GiveSurpriseAndHug hug;
	private static GiveSurpriseAndSing sing;
	private static IBag iBag;

	private static void print() {
		System.out.println("help     	  -> Command list\r\n" 
				+ "initialize        -> Initialize bag of surprises\r\n"
				+ "add	          -> Add surprises\r\n" 
				+ "give              -> Give surprises\r\n"
				+ "giveAll           -> Give all surprises\r\n" 
				+ "changeWaitTime    -> Change wait time\r\n"
				+ "quit              -> Close app\r\n"
				+ "size              -> Bag size");
	}

	private static void size() {
		System.out.println("Surprises in bag: " + iBag.size());
	}

	private static void initializeSurprises() {
		System.out.println("Please insert what container do you want: \n-> random\n-> fifo\n-> lifo");
		String text = sc.next();

		switch (text) {
		case "random":
			iBag = bag.makeBag("random");
			applause = new GiveSurpriseAndApplause("random", 3);
			hug = new GiveSurpriseAndHug("random", 3);
			sing = new GiveSurpriseAndSing("random", 3);
			System.out.println("Random bag was initialized succesfully!");
			break;
		case "fifo":
			iBag = bag.makeBag("fifo");
			applause = new GiveSurpriseAndApplause("fifo", 3);
			hug = new GiveSurpriseAndHug("fifo", 3);
			sing = new GiveSurpriseAndSing("fifo", 3);
			System.out.println("FIFO bag was initialized succesfully!");
			break;
		case "lifo":
			iBag = bag.makeBag("lifo");
			applause = new GiveSurpriseAndApplause("lifo", 3);
			hug = new GiveSurpriseAndHug("lifo", 3);
			sing = new GiveSurpriseAndSing("lifo", 3);
			System.out.println("LIFO bag was initialized succesfully!");
			break;
		}
	}

	private static void addSurprises() {
		System.out.println("Insert what surprise do you want: \n-> FortuneCookie\n-> Candies\n-> Minion");
		String text = sc.next();
		switch (text) {
		case "FortuneCookie":
			iBag.put(FortuneCookie.generate());
			break;
		case "Candies":
			iBag.put(Candies.generate());
			break;
		case "Minion":
			iBag.put(MinionToy.generate());
			break;
		}
		System.out.println("Surprises in bag: " + iBag.size());
	}

	private static void give() {
		System.out.println("Please insert how do you want to give surprises: \n-> withApplause\n-> withHug\n-> withSing");
		String text = sc.next();
		switch (text) {
		case "withApplause":
			applause.put(iBag);
			applause.give();
			break;
		case "withHug":
			hug.put(iBag);
			hug.give();
			break;
		case "withSing":
			sing.put(iBag);
			sing.give();
			break;
		}
	}

	private static void giveAll() {
		System.out
				.println("Please insert how do you want to give surprises: \n-> withApplause\n-> withHug\n-> withSing");
		String text = sc.next();
		if (!iBag.isEmpty()) {
			switch (text) {
			case "withApplause":
				applause.put(iBag);
				applause.giveAll();
				break;
			case "withHug":
				hug.put(iBag);
				hug.giveAll();
				break;
			case "withSing":
				sing.put(iBag);
				sing.giveAll();
				break;
			}
		}
	}

	private static void changeWaitTime() {
		System.out.println(waitTime + ". Please insert the new wait time.");
		int newWaitTime = sc.nextInt();
		waitTime.setWaitTime(newWaitTime);
		System.out.println("Wait time changed successfully! " + waitTime);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String select = "";
		System.out.println("Hello! Press \"help\" to see the command line.");

		while (!select.equalsIgnoreCase("quit")) {
			select = sc.next();

			switch (select) {
			case "help":
				print();
				break;
			case "initialize":
				initializeSurprises();
				break;
			case "size":
				size();
				break;
			case "add":
				addSurprises();
				break;
			case "give":
				give();
				break;
			case "giveAll":
				giveAll();
				break;
			case "changeWaitTime":
				changeWaitTime();
				break;
			case "quit":
				break;
			}
		}
		sc.close();
	}
}
