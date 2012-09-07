package Models;

public class Hexadecimal {
	private static final int radix = 16;
	public static final long maxValue = 16;

	public static long convertToLong(CharSequence value) 
	{
		return Long.parseLong(value.toString(), radix);
	}	
}
