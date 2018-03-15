public class PairOfDice {

	private int value1, value2, sum;

	Die die1 = new Die();
	Die die2 = new Die();

	// Constructor:

	public PairOfDice() {

	}
	
	// FaceValue Accessors:

	public int getDie1Value() {
		value1 = die1.getFaceValue();
		return value1;
	}

	public int getDie2Value() {
		value2 = die2.getFaceValue();
		return value2;
	}

	// Mutators:

	public void setDie1Value(int value) {
		die1.setFaceValue(value);
	}

	public void setDie2Value(int value) {
		die2.setFaceValue(value);
	}

	// Sum Accessor:

	public int sumOfDice() {
		value1 = die1.getFaceValue();
		value2 = die2.getFaceValue();
		sum = value1 + value2;
		return sum;
	}

	// Rolls dice, returns sum:

	public int rollDice() {
		value1 = die1.roll();
		value2 = die2.roll();
		sum = value1 + value2;

		return sum;
	}
}