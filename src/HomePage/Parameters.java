package HomePage;

import java.time.LocalDate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	WebDriver driver = new ChromeDriver();

	String url = "https://www.almosafer.com/en";

	String expectedlang = "en";
	String expectedcureency = "SAR";
	String expectednumber = "+966554400000";
	Assertion myassert = new Assertion();

}
