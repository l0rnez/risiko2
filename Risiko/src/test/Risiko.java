package test;

public class Risiko {
	public static void main(String[] args) {
		Player player1 = new Player(12, "Spieler1");
		Player player2 = new Player(10, "Spieler2");
		boolean abbruch = false;
		while(!abbruch) {
			player1.attack(player2);
			if(player1.getSteine() <= 0 || player2.getSteine() <= 0) {
				System.out.println("\n" + "Spiel vorbei!");
				System.out.println(player2.getName() + " hat " + player2.getSteine() + " Steine.");
				System.out.println(player1.getName() + " hat " + player1.getSteine() + " Steine.");
				abbruch = true;
				/**
				 * abbruchbedingung fixen
				 */
				break;
			}
			player2.attack(player1);
			if(player1.getSteine() <= 0 || player2.getSteine() <= 0) {
				System.out.println("\n" + "Spiel vorbei!");
				System.out.println(player2.getName() + " hat " + player2.getSteine() + " Steine.");
				System.out.println(player1.getName() + " hat " + player1.getSteine() + " Steine.");
				abbruch = true;
			}
//			abbruch = player1.getSteine() <= 0 || player2.getSteine() <= 0 || player1.getSteine() <= 0 || player2.getSteine() <= 0;
		}
	}
}