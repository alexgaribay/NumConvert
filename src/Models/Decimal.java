package Models;

public class Decimal {
	private static final int radix = 10;
	public static final long maxValue = 10;

	public static long convertToLong(CharSequence value) 
	{
		return Long.parseLong(value.toString(), radix);
	}	
}
