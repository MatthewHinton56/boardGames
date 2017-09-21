import java.util.ArrayList;
/**
 * Class that manages the dice in a board game.
 * Allows the management of different kind of dice.
 */
public class Dice extends ArrayList<Di>
{
	/**
	 * Constructs an empty Dice object.
	 */
	public Dice(){}
	/**
	 * Constructs a Dice object with pre-created Di objects
	 * @param dice the precreated Di objects.
	 */
	public Dice(ArrayList<Di> dice)
	{
	for(Di di:dice)this.add(di);	
	}
	/**
	 * Gets the value of a specific Di roll.
	 * @param index the Di to roll
	 * @return the value of the roll
	 * Pre: 0<=index<size()
	 */
	public int roll(int index)
	{
	if(index<0||index>=size())throw new IllegalArgumentException("index must be within range of 0<=index<size()");
	return get(index).roll();	
	}
	/**
	 * Adds a new Di to the Dice object using the given Parameters
	 * @param sides the sides of the Di
	 * @param lowerBound the lowerBound of the Di
	 * @param upperBound the upperBound of the Di
	 * Pre: sides>0
	 */
	public void add(int sides,int lowerBound,int upperBound)
	{
		if(sides<=0)throw new IllegalArgumentException("Sides must be greater than 0");
		add(new Di(sides,lowerBound,upperBound));
	}
	/**
	 * rolls all the dice, returning an array of the rolls.
	 * @return rolls the array of rolls generated
	 */
	public int[] rollAll()
	{
		int[] rolls = new int[size()];
		int i = 0;
		for(Di di:this)
		{
			rolls[i]=di.roll();
			i++;
		}
		return rolls;
	}
	/**
	 * sums the collective rolls of all the Di objects.
	 * @return sum the sum of all rolls.
	 */
	public int rollAndSum()
	{
		int sum = 0;
		for(int i:rollAll())sum+=i;
		return sum;
	}
	/**
	 * creates a String representation of the Dice
	 * @return The String representation.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dice:\n");
		int index = 1;
		for(Di di:this)
		{
			builder.append("Dice "+index+": "+di);
		}
		return builder.toString();
	}
}
/**
 * A class that creates objects that manages the info of one Di
 * @author Matth
 *
 */
 class Di
{
	private int sides;
	private int lowerBound;
	private int upperBound;
	/**
	 * constructs a generic Di with 6 sides with range of 1-6
	 */
	public Di()
	{
		this(6,1,6);
	}
	/**
	 * Constructs a Di with the given parameters
	 * @param sides the amount of sides
	 * @param lowerBound the lower bound of the range
	 * @param upperBound the upper bound of the range
	 */
	public Di(int sides,int lowerBound,int upperBound)
	{
		this.sides =sides;
		this.lowerBound=lowerBound;
		this.upperBound=upperBound;
	}
	/**
	 * rolls the dice and returns a value
	 * @return roll the value of the roll
	 */
	public int roll()
	{
		return ((int)(Math.random()*upperBound+lowerBound));
	}
	/**
	 * Creates a string representation of the object
	 * @return the string representation
	 */
	@Override
	public String toString() {
		return "Sides: "+sides+" Range: "+lowerBound+"-"+upperBound;
	}
}