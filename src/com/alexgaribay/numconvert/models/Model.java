package com.alexgaribay.numconvert.models;

/**
 * This class represents the CharSequence being converted in the app. It is the
 * Model in a MVC pattern
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
		BaseType base = new BaseType(desiredBaseType);
		return base.convertToCharSequence(_number);
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
}
