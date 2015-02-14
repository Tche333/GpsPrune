package tim.prune.data;

/**
 * Class to represent a Latitude Coordinate
 */
public class Latitude extends Coordinate
{
	/**
	 * Constructor
	 * @param inString string value from file
	 */
	public Latitude(String inString)
	{
		super(inString);
	}


	/**
	 * Constructor
	 * @param inValue value of coordinate
	 * @param inFormat format to use
	 */
	protected Latitude(double inValue, int inFormat)
	{
		super(inValue, inFormat);
		_cardinal = inValue < 0.0 ? SOUTH : NORTH;
	}


	/**
	 * Turn the given character into a cardinal
	 * @see tim.prune.data.Coordinate#getCardinal(char)
	 */
	protected int getCardinal(char inChar)
	{
		// Latitude recognises N, S and -
		// default is North
		int cardinal = NORTH;
		switch (inChar)
		{
			case 'N':
			case 'n':
				cardinal = NORTH; break;
			case 'S':
			case 's':
			case '-':
				cardinal = SOUTH; break;
			default:
				// no character given
		}
		return cardinal;
	}


	/**
	 * Make a new Latitude object
	 * @see tim.prune.data.Coordinate#makeNew(double, int)
	 */
	protected Coordinate makeNew(double inValue, int inFormat)
	{
		return new Latitude(inValue, inFormat);
	}

}