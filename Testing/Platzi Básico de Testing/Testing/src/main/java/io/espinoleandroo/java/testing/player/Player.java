package io.espinoleandroo.java.testing.player;

public class Player {
	
	private Dice dice;
	private int numberToWin;
	
	public Player(Dice dice, int minNumberToWin) {
		super();
		this.dice = dice;
		this.numberToWin = minNumberToWin;
	}

	public boolean play() {
		int diceNumber = dice.roll();
		return diceNumber == numberToWin;
	}

}
