package HomePage;

import java.time.Duration;
import java.time.LocalDate;

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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test()
	public void ChechTheDefaultLanguageIsEnglish() {

		String Actual = driver.findElement(By.tagName("html")).getAttribute("lang");
		myassert.assertEquals(Actual, expectedlang);

	}

	@Test()
	public void CheckTheDefaultCurrency() {

		String Actualcurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']"))
				.getText();

		myassert.assertEquals(Actualcurrency, expectedcureency);

	}

	@Test()
	public void CheckTheContactNumber() {

		String Actualnumber = driver.findElement(By.tagName("strong")).getText();

		myassert.assertEquals(Actualnumber, expectednumber);

	}

	@Test()
	public void CheckQitafLogo() {

		WebElement QitafLogo = driver.findElement(By.xpath("//div[@class='sc-fihHvN eYrDjb']//*[name()='svg']"));

		boolean ActualLogo = QitafLogo.isDisplayed();
		myassert.assertEquals(ActualLogo, true);
	}

	@Test()
	public void CheckHotels() {

		WebElement Hotels = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String Actual = Hotels.getAttribute("aria-selected");
		myassert.assertEquals(Actual, "false");

	}

	@Test
	public void CheckTheDates() {
		

		LocalDate today = LocalDate.now();

		int expectedtomorrow = today.plusDays(1).getDayOfMonth();
		int expectedaftertomorrow = today.plusDays(2).getDayOfMonth();

		
		

		String actualtomorrow = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-kqlzXE blwiEW'] span[class='sc-cPuPxo LiroG']"))
				.getText();
		
		int actualtomorrowasint= Integer.parseInt(actualtomorrow);
		

		String actualaftertomorrow = driver
				.findElement(By.cssSelector("div[class='sc-iHhHRJ sc-OxbzP edzUwL'] span[class='sc-cPuPxo LiroG']"))
				.getText();
		int actualaftertomorrowasint=Integer.parseInt(actualaftertomorrow);

		myassert.assertEquals(actualtomorrowasint, expectedtomorrow);
		myassert.assertEquals(actualaftertomorrowasint, expectedaftertomorrow);

	}
	
}
