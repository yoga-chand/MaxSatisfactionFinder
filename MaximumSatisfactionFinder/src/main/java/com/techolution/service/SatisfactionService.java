package com.techolution.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techolution.domain.InputItems;
import com.techolution.domain.MenuItem;

/**
 * 
 * @author Yoga Chandran
 * This class is used for calculating maximum satisfaction value 
 */

@Component
public class SatisfactionService{
	
	private InputItems inputItems;
	
	public InputItems getInputItems() {
		return inputItems;
	}

	public void setInputItems(InputItems inputItems) {
		this.inputItems = inputItems;
	}

	/**
	 * 
	 * @return maximum satisfaction value in secs
	 */
	public int calculateMaxSatisfactionInSeconds() {
		return calculateMaxSatisfaction(false);
	}

	/**
	 * 
	 * @return maximum satisfaction value in mins
	 */
	public int calculateMaxSatisfactionInMinutes() {
		return calculateMaxSatisfaction(true);
	}
	
	/**
	 * 
	 * @param isMinutes - boolean to determine whether calculation should be in secs or mins
	 * @return maximum satisfaction value
	 */
	private int calculateMaxSatisfaction(boolean isMinutes) {
		int totalItemCount = inputItems.getTotalItems();
		int totalTimeToEat = 0;
		List<MenuItem> menuItemList = inputItems.getMenuItemList();
		
		if(isMinutes)
			totalTimeToEat = inputItems.getTotalTimeToEat() * 60;
		else
			totalTimeToEat = inputItems.getTotalTimeToEat(); 
		
		int i, j;
		int k[][] = new int[totalItemCount+1][totalTimeToEat+1];
		for (i = 0; i <= totalItemCount; i++) {
			for (j = 0; j <= totalTimeToEat; j++) {
				if (i == 0 || j == 0)
					k[i][j] = 0;
				else if (menuItemList.get(i-1).getTimeTakenToEat() <= j)
					k[i][j] = Math.max(menuItemList.get(i-1).getSatisfactionValue()+k[i-1][j-menuItemList.get(i-1).getTimeTakenToEat()], k[i-1][j]);
				else
					k[i][j] = k[i - 1][j];
			}
		}

		return k[totalItemCount][totalTimeToEat];
	}

}
