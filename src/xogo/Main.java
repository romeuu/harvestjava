package xogo;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main{
	private static boolean stop = false;
	public static Player player;
	public static Farm farm;

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);
		
		createCharacter();
		
		createFarm();
		
		menu();
		
		while(stop != true) {
			int option = scanner.nextInt();
			mainGame(option);
		}
		
		scanner.close();
		
	}
	
	public static void createFarm() {
		Farm farm = new Farm();
		Main.farm = farm;
		System.out.println("Your new farm is watining for you!\nWhat do you want to do first?");
	}
	
	public static void separator() {
		System.out.println("*-------*----------**-------*----------**-------*----------*");
	}
	
	private static void stats() {
		System.out.println("STATS:\nName: "+player.getName()+"\nMoney: "+player.getMoney()+"\nEnergy: "+player.getEnergy()+"\nExp: "+player.getExp());
		
	}
	
	public static void menu() {
		separator();
		//STATS
		stats();
		separator();
		//MENU
		System.out.println("Game menu! Choose an option.\n1. Mine\n2. Harvest\n3. Go to the shop.\n4. Check items.\n5. Go to sleep.\n6. Stop playing");
	}
	
	public static void checkMining(double prob) {
		if(prob > 0.00 && prob < 0.10) {
			System.out.println("Um... you missed! Your remaining energy is: "+player.getEnergy());
		}
		if(prob > 0.10 && prob < 0.50) {
			player.addItem("Stone");
			System.out.println("Um... stone! Your remaining energy is: "+player.getEnergy());
		}
		if(prob > 0.50 && prob < 0.75) {
			player.addItem("Coal");
			System.out.println("Well, it's coal! Your remaining energy is: "+player.getEnergy());
		}
		if(prob > 0.76 && prob < 0.95) {
			player.addItem("Gold");
			System.out.println("Oh! It's gold! Your remaining energy is: "+player.getEnergy());
		}
		if(prob > 0.96 && prob < 1) {
			player.addItem("Diamond");
			System.out.println("Beautiful! A diamond! Your remaining energy is: "+player.getEnergy());
		}
	}
	
	public static void animationSleeping() {
		char[] animationChars = new char[]{'|', '/', '-', '\\'};
		
		for (int i = 0; i <= 100; i++) {
            System.out.print("Recharging energy: " + i + "% " + animationChars[i % 4] + "\r");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
		System.out.println("You are ready to have a great day now!");
		rememberCommands();
	}
	
	public static void rememberCommands() {
		separator();
		System.out.println("Command helper! 1. Mine, 2. Harvest, 3. Go to the shop, 4. Check items, 5. Go to sleep, 6. Stop playing");
		separator();
	}
	
	public static void enteringShop() {
		Scanner scannerShop = new Scanner(System.in);
		separator();
		System.out.println("Welcome to the shop, here you may sell your items!");
		int coal = Collections.frequency(player.getItems(), "Coal");
		int gold = Collections.frequency(player.getItems(), "Gold");
		int diamond = Collections.frequency(player.getItems(), "Diamond");
		int stone = Collections.frequency(player.getItems(), "Stone");
		System.out.println("Your items: \nCoal: "+coal+"\nGold: "+gold+"\nDiamond: "+diamond+"\nStone: "+stone);
		separator();
		System.out.println("Here are the prices: \nCoal: 5\nGold: 15\nDiamond: 30\nStone: 1");
		separator();
		System.out.println("What do you want to sell? (Coal/Gold/Diamond/Stone)");
		String answer = scannerShop.nextLine();
		
		Scanner keep = new Scanner(System.in);
		
		if("COAL".equals(answer.toUpperCase())) {
			removeAll(player.items,"Coal");
			player.setMoney(player.getMoney() + coal * 5);
			System.out.println("Do you want to keep selling things? (Y/N)");
			String keepSelling = keep.nextLine(); 
			if("Y".equals(keepSelling.toUpperCase())) {
				enteringShop();
			}else {
				checkMoney();
			}
		}
		if("GOLD".equals(answer.toUpperCase())) {
			removeAll(player.items,"Gold");
			player.setMoney(player.getMoney() + gold * 15);
			System.out.println("Do you want to keep selling things? (Y/N)");
			String keepSelling = keep.nextLine(); 
			if("Y".equals(keepSelling.toUpperCase())) {
				enteringShop();
			}else {
				checkMoney();
			}
		}
		if("DIAMOND".equals(answer.toUpperCase())) {
			removeAll(player.items,"Diamond");
			player.setMoney(player.getMoney() + diamond * 30);
			System.out.println("Do you want to keep selling things? (Y/N)");
			String keepSelling = keep.nextLine(); 
			if("Y".equals(keepSelling.toUpperCase())) {
				enteringShop();
			}else {
				checkMoney();
			}
		}
		if("STONE".equals(answer.toUpperCase())) {
			removeAll(player.items,"Stone");
			player.setMoney(player.getMoney() + stone * 1);
			System.out.println("Do you want to keep selling things? (Y/N)");
			String keepSelling = keep.nextLine(); 
			if("Y".equals(keepSelling.toUpperCase())) {
				enteringShop();
			}else {
				checkMoney();
			}
		}
	}
	
	public static void removeAll(List<String> list, String element) {
	    while (list.contains(element)) {
	        list.remove(element);
	    }
	}
	
	public static void checkMoney() {
		System.out.println("Your money is : "+player.getMoney());
	}
	
	public static void createCharacter() {
		System.out.println("Oh... hello there! Let's create a character for you!");
		System.out.println("How do you want me to call you?");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		System.out.println("Alright... So, hello "+name+"!");
		System.out.println("Let's start playing...");
		
		Player player = new Player(name);
		Main.player = player;
				
		separator();
	}
	
	public static void getItems(Player player) {
		if(!(player.getItems().isEmpty())) {
			System.out.println("Here are your items: "+player.getItems());
		}else {
			System.out.println("Sorry, you have got no items right now!");
		}
	}
	
	public static void mainGame(int option) {
		int energy = player.getEnergy();
		
		if(option == 1) {
			if(player.getEnergy() > 15) {
				double prob = Math.random();
				checkMining(prob);
				player.setEnergy(player.getEnergy() - 5);
			}else {
				System.out.println("Insufficient energy. You should think about going to sleep.");
			}
		}
		
		if(option == 4) {
			getItems(Main.player);
		}
		
		if(option == 5) {
			if(energy < 20) {
				System.out.println("Your player is currently sleeping...");
				animationSleeping();
				if(energy + 50 > 100) {
					player.setEnergy(100);
				}else {
					player.setEnergy(energy + 50);
				}
			}
		}
		
		if(option == 3) {
			enteringShop();
			rememberCommands();
		}
		
		if(option == 6) {
			SaveData data = new SaveData();
			//Player
			data.setName(Main.player.getName());
			data.setMoney(Main.player.getMoney());
			data.setExp(Main.player.getExp());
			data.setItems(Main.player.getItems());
			data.setEnergy(Main.player.getEnergy());
			
			//Farm
			data.setFields(Main.farm.getFields());
			data.setLakes(Main.farm.getLakes());
			data.setDimensionsx(Main.farm.getDimensionsx());
			data.setDimensionsy(Main.farm.getDimensionsy());
			data.setDimensionsfarmx(Main.farm.getDimensionsfarmx());
			data.setDimensionsfarmy(Main.farm.getDimensionsfarmy());
			data.setOwner(Main.player);
			
			
			try {
                ResourceManager.save(data, "1.save");
                System.out.println("See you soon, your game has been saved!");
            }
            catch (Exception e) {
                System.out.println("Couldn't save: " + e.getMessage());
            }
			
			System.exit(0);
		}
		
		if(option == 7) {
			try {
                SaveData data = (SaveData) ResourceManager.load("1.save");
                Main.player.setName(data.getName());
            }
            catch (Exception e) {
                System.out.println("Couldn't load save data: " + e.getMessage());
            }
		}
	}

	

}
