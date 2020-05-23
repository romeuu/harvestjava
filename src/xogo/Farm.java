package xogo;

public class Farm implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int dimensionsx = 5;
	private int dimensionsy = 5;
	private int fields = 1;
	private int lakes = 1;
	private int dimensionsfarmx = 25;
	private int dimensionsfarmy = 25;
	private Player owner;

	public Farm() {
		
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

	public int getLakes() {
		return lakes;
	}

	public void setLakes(int lakes) {
		this.lakes = lakes;
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

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

}
