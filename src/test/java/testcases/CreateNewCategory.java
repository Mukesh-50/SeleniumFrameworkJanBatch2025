package testcases;

import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import base.BaseClass;

public class CreateNewCategory extends BaseClass{
	
	@Test
	public void createNewCategory()
	{
		ChainTestListener.log("Test Executed");
	}

}
