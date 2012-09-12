package com.alexgaribay.numconvert.test.models;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alexgaribay.numconvert.models.BaseTypeEnum;
import com.alexgaribay.numconvert.models.Model;

public class ModelTest extends TestCase
{
	protected Model model;

	public void setUp() throws Exception
	{
		super.setUp();
		model = new Model();
	}

	public void testBinaryAddDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.BINARY;
		model.addDigit(baseTypeEnum, "1");
		Assert.assertEquals("1", model.getRepresentation(baseTypeEnum));

		model.addDigit(baseTypeEnum, "0");
		Assert.assertEquals("10", model.getRepresentation(baseTypeEnum));

		model.addDigit(baseTypeEnum, "1");
		Assert.assertEquals("101", model.getRepresentation(baseTypeEnum));
	}

	public void testBinaryRemoveDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.BINARY;
		model.addDigit(baseTypeEnum, "10101");

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("1010", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("101", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("10", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("1", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("0", model.getRepresentation(baseTypeEnum));
	}

	public void testOctalAddDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.OCTAL;
		model.addDigit(baseTypeEnum, "012");

		model.addDigit(baseTypeEnum, "7");
		Assert.assertEquals("127", model.getRepresentation(baseTypeEnum));
	}

	public void testOctalRemoveDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.OCTAL;
		model.addDigit(baseTypeEnum, "0357");

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("35", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("3", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("0", model.getRepresentation(baseTypeEnum));
	}

	public void testDecimalAddDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.DECIMAL;
		model.addDigit(baseTypeEnum, "512");

		model.addDigit(baseTypeEnum, "5");
		Assert.assertEquals("5125", model.getRepresentation(baseTypeEnum));
	}

	public void testDecimalRemoveDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.DECIMAL;
		model.addDigit(baseTypeEnum, "5316");

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("531", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("53", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("5", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("0", model.getRepresentation(baseTypeEnum));
	}

	public void testHexAddDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.HEX;
		model.addDigit(baseTypeEnum, "1A3F");

		model.addDigit(baseTypeEnum, "C");
		Assert.assertEquals("1A3FC", model.getRepresentation(baseTypeEnum));
	}

	public void testHexRemoveDigit()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.HEX;
		model.addDigit(baseTypeEnum, "D4B2");

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("D4B", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("D4", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("D", model.getRepresentation(baseTypeEnum));

		model.removeDigit(baseTypeEnum);
		Assert.assertEquals("0", model.getRepresentation(baseTypeEnum));
	}
}
