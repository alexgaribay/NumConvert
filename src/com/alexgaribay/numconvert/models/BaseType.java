package com.alexgaribay.numconvert.models;

/**
 * Represents the base type in use. Helps the program to be more generic
 * 
 * @author Alex Garibay
 * 
 */
public class BaseType
{
	private BaseTypeEnum baseTypeEnum;
	private long maxValue;
	private int radix;

	/**
	 * Constructs a BaseType based off the specified base type
	 * 
	 * @param baseTypeEnum
	 *            Desired base type
	 */
	public BaseType(BaseTypeEnum baseTypeEnum)
	{
		this.baseTypeEnum = baseTypeEnum;
		maxValue = (long) baseTypeEnum.getValue();
		radix = baseTypeEnum.getValue();
	}

	/**
	 * Converts a value CharSequence form of the set base type
	 * 
	 * @param value
	 *            Value to converted
	 * @return CharSequence representation
	 */
	public CharSequence convertToCharSequence(long value)
	{
		return (baseTypeEnum == BaseTypeEnum.HEX) ? Long.toString(value, radix)
				.toUpperCase() : Long.toString(value, radix);
	}

	/**
	 * Converts a CharSequence of the set base type to a decimal value of a long
	 * 
	 * @param sequence
	 *            Sequence to be converted to a long
	 * @return the long value equivalent
	 */
	public long convertToLong(CharSequence sequence)
	{
		return Long.parseLong(sequence.toString(), radix);
	}

	/**
	 * Get the maximum value for the set base type
	 * 
	 * @return the maximum value
	 */
	public long getMaxValue()
	{
		return this.maxValue;
	}

	public BaseTypeEnum getBaseTypeEnum()
	{
		return baseTypeEnum;
	}
}
