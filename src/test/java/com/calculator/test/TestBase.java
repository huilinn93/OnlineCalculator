package com.calculator.test;
import com.asprise.ocr.Ocr;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestBase {
	WebDriver driver;
	String IMG_FILE_NAME = "calculationresult.png";
	@BeforeMethod
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		ChromeOptions opt = new ChromeOptions();
		//opt.merge(cap);
		driver = new ChromeDriver(opt);
	}

	@AfterMethod
	public void cleanUp() {
		delay(2000);
		driver.quit();
	}

	void delay(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	String readOcr() throws IOException {
		Ocr.setUp();
		Ocr ocr = new Ocr();
		ocr.startEngine("eng", Ocr.SPEED_SLOW); // English

		String s = ocr.recognize(new File[]{new File(IMG_FILE_NAME)},
				Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);

		ocr.stopEngine(); // Stop OCR engine
		s = StringUtils.chop(s);
		return s;
	}

	public void takeSnapShots() throws IOException {
		WebElement element = driver.findElement(By.id("canvas"));
		File take = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

		Point p = element.getLocation();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight()/10;

		BufferedImage img = ImageIO.read(take);
		BufferedImage dest = img.getSubimage(p.getX() + 130, p.getY() + 45, width + 20,
				height);
		ImageIO.write(dest, "png", take);
		File f1 = new File(IMG_FILE_NAME);
		FileUtils.copyFile(take, f1);
	}

}
