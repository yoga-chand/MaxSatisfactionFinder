package com.techolution.domain;

public class MenuItem {

	private int itemId;
	
	private int timeTakenToEat;
	
	private int satisfactionValue;
	
	public MenuItem(int itemId, int timeTakenToEat, int satisfactionValue){
		
		this.itemId = itemId;
		this.timeTakenToEat = timeTakenToEat;
		this.satisfactionValue = satisfactionValue;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getTimeTakenToEat() {
		return timeTakenToEat;
	}

	public void setTimeTakenToEat(int timeTakenToEat) {
		this.timeTakenToEat = timeTakenToEat;
	}

	public int getSatisfactionValue() {
		return satisfactionValue;
	}

	public void setSatisfactionValue(int satisfactionValue) {
		this.satisfactionValue = satisfactionValue;
	}
	
	
	
}
