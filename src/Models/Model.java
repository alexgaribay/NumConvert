package Models;

public class Model 
{
	private long _number;
	
	public Model()
	{
		_number = 0;
	}

	/**
	 * Gets a CharSequence representation of the model based off what target NumberType you want
	 * @param numberType the number type representation desired
	 * @return representation of model in desired number type
	 */
	public CharSequence getRepresentation(NumberType numberType)
	{
		CharSequence representation = "";
		switch (numberType)
		{
		case DECIMAL:
			representation = this.getDecimalRepresentation();
			break;
		case BINARY:
			representation = this.getBinaryRepresentation();
			break;
		case HEX:
			representation = this.getHexadecimalRepresentation();
			break;
		case OCTAL:
			representation = this.getOctalRepresentation();
			break;
		default:
			break;
		}
		return representation;
	}
	
	public void removeValue(NumberType numberType, CharSequence numberValue)
	{
		switch(numberType)
		{
		case BINARY:
			_number -= (Binary.maxValue - Binary.convertToLong(numberValue));
			break;
		case DECIMAL:
			_number -= (Decimal.maxValue - Decimal.convertToLong(numberValue));
			break;
		case HEX:
			_number -= (Hexadecimal.maxValue - Hexadecimal.convertToLong(numberValue));
			break;
		case OCTAL:
			_number -= (Octal.maxValue - Octal.convertToLong(numberValue));
			break;
		default:
			break;
		
		}
	}
	
	/**
	 * Gets the Decimal representation of the model
	 * @return Decimal representation
	 */
	private CharSequence getDecimalRepresentation()
	{
		return  Long.toString(_number);
	}
	
	/**
	 * Gets the Hexadecimal representation of the model
	 * @return Hexadecimal representation
	 */
	private CharSequence getHexadecimalRepresentation()
	{
		return Long.toHexString(_number);
	}
	
	/**
	 * Gets the Binary representation of the model
	 * @return Binary representation
	 */
	private CharSequence getBinaryRepresentation()
	{
		return Long.toBinaryString(_number);
	}
	
	/**
	 * Gets the Octal representation of the model
	 * @return Octal representation
	 */
	private CharSequence getOctalRepresentation()
	{
		return Long.toOctalString(_number);
	}
}
