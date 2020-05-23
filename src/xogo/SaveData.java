package xogo;

import java.util.ArrayList;
import java.util.List;

public class SaveData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    //Player
    private int money = 0;
	private String name;
	private int exp = 10;
	private int energy = 100;
	public List<String> items = new ArrayList<String>();
	
	//Farm
	private int dimensionsx = 5;
	private int dimensionsy = 5;
	private int fields = 1;
	private int lakes = 1;
	private int dimensionsfarmx = 25;
	private int dimensionsfarmy = 25;
	private Player owner;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public int getDimensionsx() {
		return dimensionsx;
	}

	public void setDimensionsx(int dimensionsx) {
		this.dimensionsx = dimensionsx;
	}

	public int getDimensionsy() {
		return dimensionsy;
	}

	public void setDimensionsy(int dimensionsy) {
		this.dimensionsy = dimensionsy;
	}

	public int getFields() {
		return fields;
	}

	public void setFields(int fields) {
		this.fields = fields;
	}

	public int getDimensionsfarmx() {
		return dimensionsfarmx;
	}

	public void setDimensionsfarmx(int dimensionsfarmx) {
		this.dimensionsfarmx = dimensionsfarmx;
	}

	public int getDimensionsfarmy() {
		return dimensionsfarmy;
	}

	public void setDimensionsfarmy(int dimensionsfarmy) {
		this.dimensionsfarmy = dimensionsfarmy;
	}

	public int getLakes() {
		return lakes;
	}

	public void setLakes(int lakes) {
		this.lakes = lakes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
    
    
}
