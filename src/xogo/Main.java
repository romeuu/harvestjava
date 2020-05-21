package xogo;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main{
	private static boolean stop = false;
	public static Player player;

	public static void main(String[] args) throws InterruptedException {
		int contador = 0;
		
		System.out.println("Oh... hello there! Let's create a character for you!");
		System.out.println("How do you want me to call you?");
		
		Scanner scanner = new Scanner(System.in);
		String nombre = scanner.nextLine();
		
		System.out.println("Alright... So, hello "+nombre+"!");
		System.out.println("Let's start playing...");
		
		Player player = new Player(nombre);
		Main.player = player;
				
		separator();
		
		Farm farm = new Farm();
		
		System.out.println("Your new farm is watining for you!\nWhat do you want to do first?");
		
		menu();
		while(stop != true) {
//			rememberCommands();
			int option = scanner.nextInt();
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
				System.out.println(player.getItems());
			}
			
			if(option == 5) {
				player.setEnergy(1);
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
			
			
		}
		
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
		if(prob > 0.10 && prob < 0.50) {
			player.addItem("Stone");
			System.out.println("Um... stone!");
		}
		if(prob > 0.50 && prob < 0.75) {
			player.addItem("Coal");
			System.out.println("Well, it's coal!");
		}
		if(prob > 0.76 && prob < 0.95) {
			player.addItem("Gold");
			System.out.println("Oh! It's gold!");
		}
		if(prob > 0.96 && prob < 1) {
			player.addItem("Diamond");
			System.out.println("Beautiful! A diamond!");
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
		System.out.print("You are ready to have a great day now!");
	}
	
	public static void rememberCommands() {
		System.out.println("1. Mine, 2. Harvest, 3. Go to the shop, 4. Check items, 5. Go to sleep, 6. Stop playing");
	}

	

}
