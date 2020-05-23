package xogo;

import java.util.ArrayList;
import java.util.List;

public class SaveData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    private Player player;
    private Farm farm;
    
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Farm getFarm() {
		return farm;
	}
	public void setFarm(Farm farm) {
		this.farm = farm;
	}
    
    
    
    
}
