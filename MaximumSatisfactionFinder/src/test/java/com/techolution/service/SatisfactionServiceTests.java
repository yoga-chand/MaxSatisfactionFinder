package com.techolution.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.techolution.AppTest;
import com.techolution.domain.InputItems;
import com.techolution.util.FileParsingUtility;

/**
 * 
 * @author Yoga Chandran
 * Unit test class for testing SatisfactionService 
 */
public class SatisfactionServiceTests extends AppTest{

	@Autowired 
	private FileParsingUtility utility;
	
	@Autowired
	private SatisfactionService satisfactionService;
	
	private InputItems inputItems;
	
	@Before
	public void setUp() throws Exception{
		inputItems = utility.readFile();
		satisfactionService.setInputItems(inputItems);
	}
	
	/**
	 * Below methods whether the maximum value is calculated correctly
	 */
	@Test
	public void validateMaxValueCalcInSecs() {
		Assert.assertEquals(2493893, satisfactionService.calculateMaxSatisfactionInSeconds());
	}
	
	@Test
	public void validateMaxValueCalcInMins() {
		Assert.assertEquals(4488056, satisfactionService.calculateMaxSatisfactionInMinutes());
	}
	
}


