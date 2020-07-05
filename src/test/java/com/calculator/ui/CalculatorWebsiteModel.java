package com.calculator.ui;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorWebsiteModel {
	WebDriver driver;
	Actions builder;
	WebElement canvas;
	int Y = (255 / 6);
	int X = (174 / 5) * 2;
	public CalculatorWebsiteModel(WebDriver driver){
		this.driver = driver;
		this.builder = new Actions(driver);
	}

	public void gotoHomePage(){
		driver.get("https://www.online-calculator.com/full-screen-calculator/");
		new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("fullframe")));
		canvas = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("canvas")));
	}
	public void click1() {
		//clicking on 1
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -2, Y * 3).click().build().perform();
	}

	public void click2() {
		//clicking on 2
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -1, Y * 3).click().build().perform();
	}


	public void click3() {
		//clicking on 3
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 0, Y * 3).click().build().perform();
	}

	public void click4() {
		//clicking on 4
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -2, Y * 1).click().build().perform();
	}
	public void click5() {
		//clicking on 5
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -1, Y * 1).click().build().perform();
	}
	public void click6() {
		//clicking on 6
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 0, Y * 1).click().build().perform();
	}
	public void click7() {
		//clicking on 7
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -2, Y * -1).click().build().perform();
	}
	public void click8() {
		//clicking on 8
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -1, Y * -1).click().build().perform();
	}
	public void click9() {
		//clicking on 9
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -0, Y * -1).click().build().perform();
	}
	public void click0() {
		//clicking on 0
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -2, Y * 4).click().build().perform();
	}
	public void clickDot() {
		//clicking on .
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * -1, Y * 4).click().build().perform();
	}
	public void clickMinus() {
		//clicking on the substract sign (-)
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 1, Y * 3).click().build().perform();
	}

	public void clickPlus() {
		//clicking on the Addition sign (+)
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 1, Y * 4).click().build().perform();
	}

	public void clickDivide() {
		//clicking on the Division sign (/)
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 1, Y * -1).click().build().perform();
	}

	public void clickEquals() {//clicking on equals to sign (=)
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 2,Y * 4).click().build().perform();
	}

	public void clickCE() {//clicking on C or CE
		new Actions(driver).moveToElement(canvas, 0, 0).moveByOffset(X * 2,Y * -3).click().build().perform();
	}

	public void clickButton(char c){
		switch(c){
			case '1': click1();
				break;
			case '2': click2();
				break;
			case '3': click3();
				break;
			case '4': click4();
				break;
			case '5': click5();
				break;
			case '6': click6();
				break;
			case '7': click7();
				break;
			case '8': click8();
				break;
			case '9': click9();
				break;
			case '0': click0();
				break;
			case '.': clickDot();
				break;
			case '-': clickMinus();
				break;
			case '+': clickPlus();
				break;
			case '/': clickDivide();
				break;
			case 'C': clickCE();
				break;
			case '=': clickEquals();
				break;
		}
	}
}
