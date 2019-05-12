package test;

import java.util.Arrays;
import java.util.Random;

public class Player {

	int steine;
	int[] wuerfel = new int[3];
	String name;

	public Player(int steine, String name) {
		super();
		this.steine = steine;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name + " - Wuerfel:" + Arrays.toString(wuerfel) + ", Steine:" + steine;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getWuerfel() {
		return wuerfel;
	}

	public void setWuerfel(int[] wuerfel) {
		this.wuerfel = wuerfel;
	}

	public int getSteine() {
		return steine;
	}

	public void setSteine(int steineInLand) {
		this.steine = steineInLand;
	}
	
	public void wuerfeln() {
		if(steine < 3) {
			wuerfel = new int[steine];
		}
		Random rand = new Random();
		int random = 0;
		for(int i = 0; i<getWuerfel().length; i++) {
			random = rand.nextInt((6 - 1) + 1) + 1;
			getWuerfel()[i] = random;
		}
		sort();
	}
	
	public void attack(Player defender) {
		this.wuerfeln();
		defender.wuerfeln();
//		printWuerfel();
//		defender.printWuerfel();
		System.out.println(this.getName() + " greift " + defender.getName() + " an!\n");
		int[] array = defender.getWuerfel();
		int u;
		if(array.length < wuerfel.length){
			u = array.length;
		}else {
			u = wuerfel.length;
		}
		for(int i = 0; i < u; i++) {
			if(array[i] < wuerfel[i]) {
				defender.setSteine(defender.getSteine() - 1);
			}else{
				steine = steine - 1;
			}
		}
		System.out.println(this);
		System.out.println(defender + "\n");
	}
	
	public void sort() {
		Arrays.sort(getWuerfel());
		for(int i = 0; i < getWuerfel().length / 2; i++) {
		    int temp = getWuerfel()[i];
		    getWuerfel()[i] = getWuerfel()[getWuerfel().length - i - 1];
		    getWuerfel()[getWuerfel().length - i - 1] = temp;
		}
	}
	
	public void printWuerfel() {
		System.out.println();
		for(int k : getWuerfel()) {
			System.out.print(k + " ");
		}
		System.out.println();
	}
}
