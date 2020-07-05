package com.calculator.ui;

import org.openqa.selenium.WebDriver;


public class CalculatorWebsite {
	WebDriver driver;
	public CalculatorWebsite(WebDriver driver){
		this.driver = driver;
	}

	public void calculateExpression(String expression){
		CalculatorWebsiteModel calculatorWebsiteModel = new CalculatorWebsiteModel(driver);
		calculatorWebsiteModel.gotoHomePage();
		delay(500);
		for(char c : expression.toCharArray()) calculatorWebsiteModel.clickButton(c);
	}

	void delay(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
