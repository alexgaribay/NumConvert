package Models;

public class Octal {
	private static final int radix = 8;
	public static final long maxValue = 8;

	public static long convertToLong(CharSequence value) 
	{
		return Long.parseLong(value.toString(), radix);
	}	
}
