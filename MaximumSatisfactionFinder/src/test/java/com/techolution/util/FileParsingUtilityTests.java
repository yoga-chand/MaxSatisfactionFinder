package com.techolution.util;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.techolution.AppTest;
import com.techolution.domain.InputItems;
import com.techolution.domain.MenuItem;

/**
 * 
 * @author Yoga Chandran
 * Unit test class to test FileParsingUtility
 */
public class FileParsingUtilityTests extends AppTest{

	@Autowired
	private FileParsingUtility utility; 
	
	private InputItems inputItems;
	
	@Before
	public void setUp() throws Exception{
		inputItems = utility.readFile();
	}

	//validates the input filename 
	@Test
	public void validateInputFileName() {
		Assert.assertEquals("data.txt", utility.getFileName());
	}
	
	//validates the fetched total row count
	@Test
	public void validateCompleteDataFetched() {
		Assert.assertEquals(100, inputItems.getTotalItems());
		Assert.assertEquals(10000,inputItems.getTotalTimeToEat());
	}
	
	//validates few items picked from the stored menu items against the value in the file
	@Test
	public void validateItemValueAgainstFile() {
		List<MenuItem> menuItemList = inputItems.getMenuItemList();
		Assert.assertEquals(13497, menuItemList.get(93).getSatisfactionValue());
		Assert.assertEquals(85696, menuItemList.get(69).getSatisfactionValue());
	}
	
}
