package com.alexgaribay.numconvert.models;

/**
 * This class represents the CharSequence being converted in the app. It is the
 * Model in a MVC patten
 * 
 * @author Alex Garibay
 * 
 */
public class Model
{
	private long _number;

	public Model()
	{
		_number = 0;
	}

	/**
	 * Gets a CharSequence representation of the model based off what target
	 * NumberType you want
	 * 
	 * @param desiredBaseType
	 *            the base type representation desired
	 * @return representation of model in desired number type
	 */
	public CharSequence getRepresentation(BaseTypeEnum desiredBaseType)
	{
		CharSequence representation = "";
		switch (desiredBaseType)
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

	/**
	 * Removes a CharSequence value equivalent to the current NumberType.
	 * 
	 * @param baseTypeEnum
	 *            Current base type
	 * @param numberValue
	 *            The value to be removed
	 */
	public void removeValue(BaseTypeEnum baseTypeEnum, CharSequence numberValue)
	{
		BaseType base = new BaseType(baseTypeEnum);
		_number -= base.getMaxValue() - base.convertToLong(numberValue);
	}

	/**
	 * Adds a CharSequence value equivalent to the current NumberType
	 * 
	 * @param baseTypeEnum
	 *            Current base type
	 * @param numberValue
	 *            The value to be added
	 */
	public void addValue(BaseTypeEnum baseTypeEnum, CharSequence numberValue)
	{
		BaseType base = new BaseType(baseTypeEnum);
		_number += base.getMaxValue() + base.convertToLong(numberValue);
	}

	/**
	 * Gets the Decimal representation of the model
	 * 
	 * @return Decimal representation
	 */
	private CharSequence getDecimalRepresentation()
	{
		return Long.toString(_number);
	}

	/**
	 * Gets the Hexadecimal representation of the model
	 * 
	 * @return Hexadecimal representation
	 */
	private CharSequence getHexadecimalRepresentation()
	{
		return Long.toHexString(_number);
	}

	/**
	 * Gets the Binary representation of the model
	 * 
	 * @return Binary representation
	 */
	private CharSequence getBinaryRepresentation()
	{
		return Long.toBinaryString(_number);
	}

	/**
	 * Gets the Octal representation of the model
	 * 
	 * @return Octal representation
	 */
	private CharSequence getOctalRepresentation()
	{
		return Long.toOctalString(_number);
	}
}
