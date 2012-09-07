package Models;

public class Binary 
{
	private final static int radix = 1;
	public static final long maxValue = 1;
	
	public static long convertToLong(CharSequence value) 
	{
		return Long.parseLong(value.toString(), radix);
	}	
}
