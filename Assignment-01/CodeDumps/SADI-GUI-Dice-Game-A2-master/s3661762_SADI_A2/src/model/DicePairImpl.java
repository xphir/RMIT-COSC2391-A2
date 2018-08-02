package model;

import model.interfaces.DicePair;

public class DicePairImpl implements DicePair {
	private int dice1;
	private int dice2;
	private int numFaces;
	/* constructor */

	public DicePairImpl(int dice1, int dice2, int numFaces) {
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.numFaces = numFaces;
	}

	/* getter methods */
	@Override
	public int getDice1() {
		return dice1;
	}

	@Override
	public int getDice2() {
		return dice2;
	}

	@Override
	public int getNumFaces() {
		return numFaces;

	}

	/* toString method that lists the values of the Dice pair */
	@Override
	public String toString() {
		int sumOfDice = getDice1() + getDice2();
		String stringFormat1 = String.format("Dice 1: %d, Dice 2: %d.. Total: %d", getDice1(), getDice2(), sumOfDice);
		return stringFormat1;
	}

}
