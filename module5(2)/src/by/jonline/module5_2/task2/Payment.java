package by.jonline.module5_2.task2;

import java.util.ArrayList;
import java.util.List;

public class Payment {
	
	public enum PurchaseType {
		CAR, BOAT, HOUSE;
	}
	
	private int balance;
	private int carPrice = 100;
	private int boatPrice = 200;
	private int housePrice = 500;

	private List<Purchase> journal = new ArrayList<>();

	public Payment(int balance) {this.balance = balance;}
	public int getBalance() {return balance;}
	public void setBalance(int balance) {this.balance = balance;}
	public int getCarPrice() {return carPrice;}
	public void setCarPrice(int carPrice) {this.carPrice = carPrice;}
	public int getBoatPrice() {return boatPrice;}
	public void setBoatPrice(int boatPrice) {this.boatPrice = boatPrice;}
	public int getHousePrice() {return housePrice;}
	public void setHousePrice(int housePrice) {this.housePrice = housePrice;}

	abstract class Purchase {

		int balance;
		int price;
		PurchaseType type;

		public Purchase() {
			this.balance = getBalance();
		}

		@Override
		public String toString() {
			return "Purchase:  \n" + 
		"Product: " + this.type + 
		", price: " + this.price + 
		", balance: " + this.balance + "\n";
		}
	}

	class Car extends Purchase {
		public Car() {
			this.price = carPrice;
			this.balance = getBalance() - price;
			this.type = PurchaseType.CAR;
		}
	}

	class Boat extends Purchase {
		public Boat() {
			this.price = boatPrice;
			this.balance = getBalance() - price;
			this.type = PurchaseType.BOAT;
		}
	}

	class House extends Purchase {
		public House() {
			this.price = housePrice;
			this.balance = getBalance() - price;
			this.type = PurchaseType.HOUSE;
		}
	}

	public void newPurchase(PurchaseType type) throws NotEnoughMoneyException, IllegalArgumentException {

		Purchase newPurchase;
		checkAction(type);

		switch (type) {
		case BOAT:
			newPurchase = new Boat();
			setBalance(newPurchase.balance);
			break;
		case CAR:
			newPurchase = new Car();
			setBalance(newPurchase.balance);
			break;
		case HOUSE:
			newPurchase = new House();
			setBalance(newPurchase.balance);
			break;
		default:
			throw new UnsupportedOperationException("There is no this type of good to buy");
		}

		journal.add(newPurchase);

	}

	public void checkAction(PurchaseType type) throws 
	IllegalArgumentException, 
	NotEnoughMoneyException {

		if (getBalance() <= 0) {
			throw new IllegalArgumentException("You don't have money at all");
		}

		switch (type) {
		case CAR:
			if (getCarPrice() > getBalance()) {
				throw new NotEnoughMoneyException("Not enogh money to buy a Car");
			}
			break;
		case BOAT:
			if (getBoatPrice() > getBalance()) {
				throw new NotEnoughMoneyException("Not enogh money to buy a Boat");
			}
			break;
		case HOUSE:
			if (getHousePrice() > getBalance()) {
				throw new NotEnoughMoneyException("Not enogh money to buy a House");
			}
			break;
		default:
			break;

		}

	}

	public String print() {
		
		String string = "";

		for (Purchase p : journal) {
			string += p.toString();
		}
		return string;
	}
}
