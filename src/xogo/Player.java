package xogo;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int money = 0;
	private String name;
	private int exp = 10;
	private int energy = 100;
	private List<String> items = new ArrayList<String>();

	//CONSTRUCTOR
	public Player(String name) {
		this.name = name;
	}
	
	//GETTERS AND SETTERS
	
	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}


	public List<String> getItems() {
		return items;
	}
	
	public void addItem(String item) {
		items.add(item);
	}
	
	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getExp() {
		return exp;
	}


	public void setExp(int exp) {
		this.exp = exp;
	}
	
	

}
