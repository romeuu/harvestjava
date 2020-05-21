package xogo;
import java.util.*;


public class Main{
	private static boolean stop = false;
	public static Player player;

	public static void main(String[] args) {
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
			int option = scanner.nextInt();
			if(option == 1) {
				
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
		System.out.println("Game menu! Choose an option.\n1. Mine\n2. Harvest\n3. Go to the shop.\n4. Stop playing");
	}

	

}
