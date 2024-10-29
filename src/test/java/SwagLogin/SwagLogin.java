package SwagLogin;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class SwagLogin {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        String loginPage = "https://www.saucedemo.com/";
        driver.navigate().to(loginPage);
        Assert.assertEquals(driver.getCurrentUrl(), loginPage);

        WebElement pageSaucedemo = driver.findElement(By.className("login_logo"));
        Assert.assertEquals(pageSaucedemo.getText(), "Swag Labs");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Test Case 1 = Login with valid credentials

        String validUser = "standard_user";
        String validPass = "secret_sauce";

        usernameField.clear();
        usernameField.sendKeys(validUser);

        passwordField.clear();
        passwordField.sendKeys(validPass);

        loginButton.click();

        // verification of successful login with valid credentials

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        Assert.assertNotEquals(driver.getCurrentUrl(), loginPage);
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement productsText = driver.findElement(By.className("title"));
        Assert.assertTrue(productsText.isDisplayed());

        WebElement ShoppingCartIcon = driver.findElement(By.id("shopping_cart_container"));
        Assert.assertTrue(ShoppingCartIcon.isDisplayed());

        WebElement burgerMenuIcon = driver.findElement(By.id("react-burger-menu-btn"));
        Assert.assertTrue(burgerMenuIcon.isDisplayed());
        burgerMenuIcon.click();

        WebElement logoutCard = driver.findElement(By.id("logout_sidebar_link"));
        logoutCard.click();

        // verification of successful logout

        Assert.assertEquals(driver.getCurrentUrl(), loginPage);

        boolean isPresent = false;

        try {
            isPresent = driver.findElement(By.className("title")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isPresent);

        WebElement credentialsField = driver.findElement(By.id("login_credentials"));
        Assert.assertTrue(credentialsField.isDisplayed());

        // Test Case 2 = invalid username and valid password

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        usernameField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));

        String invalidUser = "WrongUser";

        usernameField.clear();
        usernameField.sendKeys(invalidUser);

        passwordField.clear();
        passwordField.sendKeys(validPass);

        loginButton.click();

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(driver.getCurrentUrl(), loginPage);

        isPresent = false;

        try {
            isPresent = driver.findElement(By.className("title")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isPresent);

        WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        WebElement usernameErrorButton = driver.findElement(By.cssSelector("svg[role='img']"));
        Assert.assertTrue(usernameErrorButton.isDisplayed());

        // Test Case 3 = valid username and invalid password;

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        Assert.assertEquals(driver.getCurrentUrl(), loginPage);

        credentialsField = driver.findElement(By.id("login_credentials"));
        Assert.assertTrue(credentialsField.isDisplayed());


        usernameField = driver.findElement(By.id("user-name"));
        passwordField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login-button"));

        String invalidPass = invalidUser;

        usernameField.clear();
        usernameField.sendKeys(validUser);

        passwordField.clear();
        passwordField.sendKeys(invalidPass);

        loginButton.click();

        Assert.assertNotEquals(driver.getCurrentUrl(), expectedURL);
        Assert.assertEquals(driver.getCurrentUrl(), loginPage);

        isPresent = false;

        try {
            isPresent = driver.findElement(By.className("title")).isDisplayed();
        } catch (Exception e) {

        }
        Assert.assertFalse(isPresent);

        errorMessage = driver.findElement(By.cssSelector(".error-message-container.error"));
        Assert.assertTrue(errorMessage.isDisplayed());

        usernameErrorButton = driver.findElement(By.cssSelector("svg[role='img']"));
        Assert.assertTrue(usernameErrorButton.isDisplayed());

    }
}