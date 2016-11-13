package com.techolution.domain;

import java.util.List;

public class InputItems {

	private List<MenuItem> menuItemList;
	
	private int totalItems;
	
	private int totalTimeToEat;
	
	public InputItems(List<MenuItem> menuItemList, int totalItems, int totalTimeToEat){
		this.menuItemList = menuItemList;
		this.totalItems = totalItems;
		this.totalTimeToEat = totalTimeToEat;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public int getTotalTimeToEat() {
		return totalTimeToEat;
	}

	public void setTotalTimeToEat(int totalTimeToEat) {
		this.totalTimeToEat = totalTimeToEat;
	}
	
	
}
