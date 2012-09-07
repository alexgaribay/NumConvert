package Models;

/**
 * Enumerator for supported number types
 * @author Alex Garibay
 *
 */
public enum NumberType 
{
	BINARY(1),
	OCTAL(8),
	DECIMAL(10),
	HEX(16);
	
	private int value;
	
	private NumberType(int value)
	{
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
