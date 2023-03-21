package StepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions{
	 ChromeDriver Driver;
	@Given("I am on the amazon signin page")
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/Drivers/chromedriver.exe");
		Driver= new ChromeDriver();
		Driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		Driver.manage().window().maximize();
		String text = Driver.findElement(By.className("a-spacing-small")).getText();
		if(text.contains("Sign in")) {
			System.out.println("Sign in page");
		}}
	@When ("I enter the email Id as {string}")
	public void EnterEmail(String email) {
		Driver.findElement(By.id("ap_email")).sendKeys(email);
	}
	
	@And("I enter the {string} button")
	public void ClickContinue(String submit) {
		Driver.findElement(By.id("continue")).click();
	}
	@And("I should enter the password {string}")
		public void EnterPassword(String password) {
		Driver.findElement(By.id("ap_password")).sendKeys(password);
		}
	@And("I  click the {string} button")
	public void Signin(String submit) throws InterruptedException {
		Driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(2000);
	}
	@Then("I should see the amazon homepage")
	public void HomePage() throws InterruptedException {
		String attribute = Driver.findElement(By.id("nav-logo-sprites")).getAttribute("aria-label");
		System.out.println(attribute);
		if(attribute.contains("Amazon.in")) {
			System.out.println("Login successful");
			Thread.sleep(2000);
		}}
		@And("I select the category {string}")
    public void SelectCategory(String x) throws InterruptedException {
		WebElement element = Driver.findElement(By.id("searchDropdownBox"));
	    Select category=new Select(element);
	   category.selectByValue("search-alias=electronics");
	   Thread.sleep(2000);
	   }
    @And("I should search for {string}")
    public void SearchForProduct(String text) throws InterruptedException {
    	Driver.findElement(By.name("field-keywords")).sendKeys(text);
    	Thread.sleep(2000);
    }
    @And("I click the search button")
    public void ClickSearch() throws InterruptedException {
    	Driver.findElement(By.id("nav-search-submit-button")).click();
    	Thread.sleep(2000);
    }
     
    @Then("I see the results for {string}")
    public void GetProducts(String a ) throws InterruptedException {
     String text = Driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']")).getText();
        if(text.contains(a)) {
        	System.out.println(a);
        }Thread.sleep(2000);}
    @When("I add the first item to cart")
    public void AddToCart() throws InterruptedException {
        Driver.findElement(By.xpath("//*[@alt='Apple iPhone 14 Pro Max (128 GB) - Space Black']")).click(); 
    	Driver.findElement(By.id("add-to-cart-button")).submit();
    	Thread.sleep(2000);
    }
    @Then("I should see added to cart")
    public void CheckOutCart() throws InterruptedException {
    	String text = Driver.findElement(By.xpath("//span[@class='a-size-medium-plus a-color-base sw-atc-text a-text-bold']")).getText();
    	if(text.contains("Added to Cart")) {
    		System.out.println("Product added to cart successfully");
    		Thread.sleep(2000);
    		Driver.quit();
    	}}
          
    }
