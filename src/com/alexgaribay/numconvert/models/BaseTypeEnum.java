package com.alexgaribay.numconvert.models;

/**
 * Enumerator for supported base types
 * 
 * @author Alex Garibay
 * 
 */
public enum BaseTypeEnum
{
	BINARY(1), OCTAL(8), DECIMAL(10), HEX(16);

	private int value;

	private BaseTypeEnum(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}
}
