package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Adminpage {
	WebDriver driver;

	@Given("I am on the OrangeHRM website")
	public void i_am_on_the_OrangeHRM_website() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\offic\\Downloads\\chromedriver14\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Given("I log in with valid username  {string} and password {string}")
	public void i_log_in_with_valid_Admin_and_admin123(String string, String string2) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(string);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(string2);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

	}

	@When("I successfully navigate to the homepage")
	public void i_successfully_navigate_to_the_homepage() throws InterruptedException {
		Thread.sleep(2000);
		boolean logo = driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
		Assert.assertEquals(logo, true);

	}

	@When("I click on the Admin button")
	public void i_click_on_the_Admin_button() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();

	}

	@When("I validate the system user with valid employee name {string}")
	public void i_validate_the_system_user_with_valid_John_Smith(String string) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']"))
				.sendKeys(string);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

	@Then("I should successfully retrieve the record for the given username")
	public void i_should_successfully_retrieve_the_record_for_the_given_username() throws InterruptedException {
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']")).getText();
		System.out.println(text);
		driver.close();
	}

}
