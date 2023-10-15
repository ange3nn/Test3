package testselenium;


	import java.util.concurrent.TimeUnit;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.chrome.ChromeOptions;
    	public class saucedemo5 {

	public static void main(String[] args) {

	   // Set the path to the ChromeDriver executable
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\2252204\\Downloads\\Open Source Google Chrome Driver 114,0.5735.90_chromedriver win32 (5) (1)\\\\chromedriver.exe");
	   
	  // Create a new instance of the ChromeDriver
		ChromeOptions chromeOptions=new ChromeOptions(); 
		chromeOptions.addArguments ("--remote-allow-origin", "ignore-certificate-errors");
		WebDriver driver=new ChromeDriver (chromeOptions);
		driver.manage().window().maximize();

	 //Navigate to www.saucedemo.com 
		driver.get("http://www.saucedemo.com");

	// Login with standard user and secret sauce
		WebElement usernameField=driver.findElement(By.id("user-name"));
		WebElement passwordField=driver.findElement(By.id("password"));
		WebElement loginButton =driver.findElement(By.id("login-button"));
		usernameField.sendKeys("standard user");
		passwordField.sendKeys ("secret sauce");
		loginButton.click();

	// Verify the count of products is
		int productCount= driver.findElements (By.className("inventory iten")).size();
		if (productCount== 6)
		{
		System.out.println("Product count is 6. Test passed!");

		} else {

		System.out.println("Product count is not 6. Test failed!");
		
		}


		// Check if "Swag Labs" is displayed on the page

		WebElement swagLabsText= driver.findElement(By.className("app_logo"));
		if (swagLabsText.getText().equals("Swag Labs"))
		{
			System.out.println("Swag Labs is displayed on the page. Test passed!");


		} else {


		System.out.println("Swag Labs is not displayed on the page. Test failed!");

		}

		// Add Sauce Labs Backpack to the cart
		WebElement backpackAddToCartButton = driver.findElement(By.xpath("//button[@id= \"add-to-cart-sauce-labs-backpack\"]"));
		backpackAddToCartButton.click();

		// Add Sauce Labs Bike Light to the cart

		WebElement bikeLightAddToCartButton = driver.findElement(By.xpath("//button[(@id=\"add-to-cart-sauce-labs-bike-light\"]"));

		bikeLightAddToCartButton.click();

		// Click on the Cart

		WebElement cartIcon= driver.findElement(By.className("shopping_cart_badge"));

		cartIcon.click();

	  // Confirm Sauce Labs Backpack and Sauce Labs Bike Light are added to the cart

		WebElement cartItems = driver.findElement(By.className("cart_list"));
		if (cartItems.getText().contains("Sauce Labs Backpack")) 
		{

		System.out.println("Sauce Labs Backpack in prosent in the cart, Test passed!");

		} else {

		System.out.println("Sauce Labs Backpack is not present in the cart. Test failed!");


		}
		
		if (cartItems.getText().contains("Sauce Labs Bike Light"))
		{
			System.out.println(" Sauce Labs Bike Light is present in the cart. Test passed!");
			
			} else {
				
			System.out.println("Sauce Labs Bike Light is not present in the cart. Test failed!");

				}

		// Click on Checkout
		
		WebElement checkoutButton =driver.findElement(By.xpath("//button[@id='checkout']"));
		checkoutButton.click();
		
       // Fill in the details on Your Information page
		
		WebElement firstNameField= driver.findElement(By.id("first-name"));

		WebElement lastNameField= driver.findElement(By.id("last-name"));

		WebElement zipCodeField= driver.findElement(By.id("postal code"));

		WebElement continueButton = driver.findElement(By.id("continue"));
		
		firstNameField.sendKeys("Angelin");
		lastNameField.sendKeys("Nancy");
		zipCodeField.sendKeys("12345");
		continueButton.click();

		//Access the menu on the left of the page
		WebElement menuButton =driver.findElement(By.xpath("//button[@id='react-burger-menu-btn')"));
		menuButton.click();
    
		// Click logout
		driver.manage().timeouts ().implicitlyWait (10, TimeUnit.SECONDS);

		WebElement logoutLink=driver.findElement(By.id("logout sidebar_link"));
		logoutLink.click();

		// Close the browser

		driver.quit();
			
	}

}
