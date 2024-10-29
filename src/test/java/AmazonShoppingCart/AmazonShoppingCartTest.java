package AmazonShoppingCart;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class AmazonShoppingCartTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.navigate().to("https://www.google.com/");

        WebElement googleSearchBox = driver.findElement(By.id("APjFqb"));
        WebElement searchButton = driver.findElement(By.cssSelector("input[type='submit']"));

        googleSearchBox.sendKeys("Amazon");
        searchButton.click();

        WebElement amazonBooks = driver.findElement(By.linkText("Books"));
        amazonBooks.click();

        WebElement bookSearch = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement amazonSearchButton = driver.findElement(By.id("nav-search-submit-button"));

        bookSearch.sendKeys("Selenium Framework Design in Data-Driven Testing:");
        amazonSearchButton.click();

        WebElement bookButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        bookButton.click();

        String productURL = driver.getCurrentUrl();
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "0");

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();
        cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "1");


        WebElement goToCartButton = driver.findElement(By.id("sw-gtc"));
        goToCartButton.click();


        // verification that we are on the right URL and that the item is in the cart
        String expectedURL = "https://www.amazon.com/cart?ref_=sw_gtc";
        Assert.assertNotEquals(driver.getCurrentUrl(), productURL);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement proceedToCheckoutButton = driver.findElement(By.name("proceedToRetailCheckout"));
        WebElement addedItemName = driver.findElement(By.className("a-truncate-cut"));
        WebElement deleteItemButton = driver.findElement(By.cssSelector("input[value='Delete']"));

        Assert.assertTrue(proceedToCheckoutButton.isDisplayed());
        Assert.assertTrue(addedItemName.isDisplayed());
        Assert.assertTrue(deleteItemButton.isDisplayed());


        // Deleting of cookies and page refresh
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();


        // verification that we are on the right URL and that an item is NOT in the cart
        expectedURL = "https://www.amazon.com/cart?ref_=sw_gtc";
        Assert.assertNotEquals(driver.getCurrentUrl(), productURL);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        boolean isPresent = false;

        // verification that proceed to checkout button is not present
        try {
            isPresent = driver.findElement(By.name("proceedToRetailCheckout")).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(isPresent);

        //verification that item name is not present
        try {
            isPresent = driver.findElement(By.className("a-truncate-cut")).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(isPresent);

        // verification that delete item button is not present
        try {
            isPresent = driver.findElement(By.cssSelector("input[value='Delete']")).isDisplayed();
        } catch (Exception e) {
        }
        Assert.assertFalse(isPresent);
    }
}
