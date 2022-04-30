package com.bdd.Steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest {
	WebDriver driver;
	WebElement email, pass, submit, logout;
  
	@Given("^To launch chrome browser$")
	public void to_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_v.99.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Given("^To enter the site URL$")
	public void to_enter_the_site_URL() {
		driver.get("file:///C:/selenium%20data/Offline%20Website/Offline%20Website/index.html");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

	}

	@Given("^To enter email \"([^\"]*)\"$")
	public void to_enter_email(String uName) {
		email = driver.findElement(By.xpath("//input[@type='text']"));
		email.sendKeys(uName);
	}

	@Given("^To enter password \"([^\"]*)\"$")
	public void to_enter_password(String uPass) {
		pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys(uPass);
	}

	@When("^click on submit button$")
	public void click_on_submit_button() {
		submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
	}

	@Then("^To validate dashboard page title \"([^\"]*)\"$")
	public void to_validate_dashboard_page_title(String expResult) {
		String actResult = driver.getTitle();
		Assert.assertEquals(actResult, expResult);
	}

	@Then("To click on Logout button")
	public void to_click_on_logout_button()   {
		logout=driver.findElement(By.id("hlogout"));
		logout.click();
	
	}
	@Then("To validate Login page title {string}")
	public void to_validate_login_page_title(String expResult) throws InterruptedException {
		String actResult = driver.getTitle();
		Assert.assertEquals(actResult, expResult);  
		Thread.sleep(2000);
	}
    @After
    public void tearDown() {
    	driver.close();
    }
}
