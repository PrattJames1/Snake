public class Die
{
	// Instance data: 

	private final int MAX = 6; // Max face value

	public int faceValue; // current value showing on the die

	// Constructor: Sets the initial face value. (not essential)

	public Die()
	{
		faceValue = 1;
	}

	// Face value mutator.

	public void setFaceValue(int value)
	{
		faceValue = value;
	}

	// Face value accessor. (How to get faceValue.)

	public int getFaceValue()
	{
		return faceValue;
	}

	// Rolls the die and returns the result.

	public int roll()
	{
		faceValue = (int)(Math.random() * MAX) + 1;

		return faceValue;
	}

	public String toString()
	{
		String result = Integer.toString(faceValue);

		return result;
	}
}