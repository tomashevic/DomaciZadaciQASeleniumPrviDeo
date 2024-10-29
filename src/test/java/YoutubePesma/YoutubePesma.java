package YoutubePesma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubePesma {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.youtube.com/");
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).sendKeys("californication rhcp");
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input")).sendKeys(Keys.ENTER);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("setTimeout(function() { " +
                "document.querySelector('a#video-title[title=\"Red Hot Chili Peppers - Californication (Official Music Video) [HD UPGRADE]\"]').scrollIntoView(); " +
                "document.querySelector('a#video-title[title=\"Red Hot Chili Peppers - Californication (Official Music Video) [HD UPGRADE]\"]').click(); " + "}, 2000);");
    }
}