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

	public BaseType(BaseTypeEnum baseTypeEnum)
	{
		this.baseTypeEnum = baseTypeEnum;
		maxValue = (long) baseTypeEnum.getValue();
		radix = baseTypeEnum.getValue();
	}

	public CharSequence convertToCharSequence(Long value)
	{
		return Long.toString(value, radix);
	}
	
	public long convertToLong(CharSequence value)
	{
		return Long.parseLong(value.toString(), radix);
	}

	public long getMaxValue()
	{
		return this.maxValue;
	}

	public BaseTypeEnum getBaseTypeEnum()
	{
		return baseTypeEnum;
	}
}
