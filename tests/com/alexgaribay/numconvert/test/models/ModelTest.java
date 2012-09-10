package com.alexgaribay.numconvert.test.models;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alexgaribay.numconvert.models.BaseTypeEnum;
import com.alexgaribay.numconvert.models.Model;

public class ModelTest extends TestCase {
	protected Model model;
	

	public void setUp() throws Exception
	{
		super.setUp();
		model = new Model();
	}
	
	public void testBinaryAddValue()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.BINARY;
		model.addValue(baseTypeEnum, "1");
		Assert.assertEquals("1", model.getRepresentation(baseTypeEnum));
		
		model.addValue(baseTypeEnum, "0");
		Assert.assertEquals("10", model.getRepresentation(baseTypeEnum));
	}
	
	public void testDecimalAddValue()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.DECIMAL;
		model.addValue(baseTypeEnum, "512");
		
		model.addValue(baseTypeEnum, "5");
		Assert.assertEquals("5125", model.getRepresentation(baseTypeEnum));
	}
	
	public void testDecimalRemoveValue()
	{
		BaseTypeEnum baseTypeEnum = BaseTypeEnum.DECIMAL;
		model.addValue(baseTypeEnum, "5316");
		
		model.removeValue(baseTypeEnum);
		Assert.assertEquals("531", model.getRepresentation(baseTypeEnum));
	}

}
