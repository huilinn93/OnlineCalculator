package com.calculator.test;

import com.calculator.ui.CalculatorWebsite;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

public class TestCalculator extends TestBase{

	@DataProvider(name="expressions")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
				{
						{"120+0=", "120" },
						{"12+567=", "579" },
						{"500.9+5234=", "5734.9" },
						{"100+234=", "334" },
						{"12.5123+567.0022=", "579.5145" },
						{"128-4=", "124" },
						{"2-288=", "-286" },
						{"900-0=", "900" },
						{"125.50-25.20=", "100.3" },
						{"0/0=", "Error" },
						{"1000/5=", "200" },
						{"500.4/2=", "250.2" },
						{"123+456-78/90.5=", "5.5359116" },
						{"800/200*3+300-900=", "-588" },
						{"123+456C700=", "823" },
						{"123+456CC5+600=", "605" }
				};

	}

	@Test(dataProvider="expressions")
	public void testAddition(String expression, String expectedResult) {
		CalculatorWebsite calculatorWebsite = new CalculatorWebsite(driver);

		calculatorWebsite.calculateExpression(expression);
		try {
			takeSnapShots();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String actualResult = null;
		try {
			actualResult = readOcr();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(actualResult, expectedResult, expression);
	}
}
