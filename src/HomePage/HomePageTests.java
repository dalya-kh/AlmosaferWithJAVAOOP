package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTests extends Parameters {

	@BeforeTest
	public void mysetup() {
		driver.get(url);
		driver.manage().window().maximize();

		WebElement popmsg = driver.findElement(By.cssSelector(".sc-iBmynh.izXFRL"));
		if (popmsg.isDisplayed()) {

			WebElement sarbutton = driver
					.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
			sarbutton.click();
		}

	}

	@Test()
	public void ChechTheDefaultLanguageIsEnglish() {

		String Actual = driver.findElement(By.tagName("html")).getAttribute("lang");
		myassert.assertEquals(Actual, expectedlang);

	}

	@Test()
	public void CheckTheDefaultCurrency() {

		String Actualcurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();

		myassert.assertEquals(Actualcurrency,expectedcureency);
		
	}
	@Test ()
	public void CheckTheContactNumber () {
		
		String Actualnumber=driver.findElement(By.tagName("strong")).getText();
		
		myassert.assertEquals(Actualnumber, expectednumber);
		
	}

}
