package DemoqaBookstoreCookie;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

public class BookStoreCookie {
    WebDriver driver;

    @BeforeClass
    public void setUP() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeMethod
    public void pageSetup() {
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void userCanLogIn() throws InterruptedException {
        WebElement bookStoreApplication = driver.findElement(By.cssSelector("svg[fill='currentColor']"));
        bookStoreApplication.click();


        ArrayList<String> cookieName = new ArrayList<>();
        cookieName.add("_GRECAPTCHA");
        cookieName.add("ar_debug");
        cookieName.add("receive-cookie-deprecation");
        cookieName.add("panoramaId_expiry");
        cookieName.add("3pi");
        cookieName.add("expires");
        cookieName.add("NID");
        cookieName.add("OTZ");
        cookieName.add("userID");
        cookieName.add("panoramaId");
        cookieName.add("IDE");
        cookieName.add("AID");
        cookieName.add("AEC");
        cookieName.add("APC");
        cookieName.add("SEARCH_SAMESITE");
        cookieName.add("_ga");
        cookieName.add("_gid");
        cookieName.add("_ga_MVRXK93D28");
        cookieName.add("__eoi");
        cookieName.add("__gads");
        cookieName.add("DSID");
        cookieName.add("userName");
        cookieName.add("DV");
        cookieName.add("__gpi");
        cookieName.add("_cc_id");
        cookieName.add("id5");
        cookieName.add("token");
        cookieName.add("panoramaIdType");


        ArrayList<String> cookieValue = new ArrayList<>();
        cookieValue.add("09AGteOypqGSi3bM65WYynxG-ge6eMN6-HSdg5hSdTLCXbOYSbVkYOmluT5oZoCA9fobB0o7nigRMbUAhNb0-CRRo");
        cookieValue.add("1");
        cookieValue.add("1");
        cookieValue.add("1728594185872");
        cookieValue.add("2#1727867899783#373812527#1984668956603459312|966#1727963763945#-143971662|203#1727828371529#1591971570#5b358fba-2575-409b-97d0-7961f2579f59|1227#1727830037192#-787375807|464#1727861103004#944934521#60594d08-1949-4099-babe-2489f56e3abf-tuctdf5e499|18#1727830036743#1191425255|19#1727815450853#2060532229#b127951cf3069fdd897c5b715f0e3925|916#1727815674225#1550396462|340#1727830036850#-104558660|1244#1727828377205#-787375807|285#1727815449520#1959947340#M1QWMPPE-14-17DK|349#1727830036282#-104558660|991#1727830069386#311211677|224#1727828376866#1036194046#2919984239800913740|160#1727829993147#-104558660|164#1727871378151#1814150942|485#1727815674333#-104558660|165#1727830036379#311211677|422#1727829993600#1979635139|102#1727993368755#-331795731|104#1727830036926#1956800078#0fa8c59f-f38a-4fae-a92f-d1756afc9400|170#1727829994494#1914339009|108#1727815674481#75482156|1132#1727829993742#-1254470104#838e759f-d598-48b1-9c02-743aea249c8c|429#1727829994209#-214867836#8C20A247-8F79-4170-B5F4-FFAF70460AD5|110#1727860099198#-1440963292|175#1727829994494#1598780614|112#1727830036577#2037579463#6BEA1657D0DE601B|181#1727829993036#-787375807|441#1728058903317#816164266#e_413620f8-154e-4f3f-a566-c028718a14e0|1402#1727829994007#-787375807|123#1727815450155#-834734902|124#1727815449350#1550396462|1405#1727829994318#-787375807|1406#1727815449897#-787375807");
        cookieValue.add("2024-10-11T20%3A17%3A47.732Z");
        cookieValue.add("518=bhyKR4KGAs_BcUixjMKgL9vbgGstmr-jyb2XUyc3ob6eV4pAJyLQyVnhUAeHIt_xmjV0hAyvL1snoDgN-AGEWmXUpapfqqACev2rMuH9mYUZSW4ixPFfmsJwLnNtU2-zftGoxQuV25yg-qBu7rUnQjvdOBcioNsvvdBvnS00FdOpY74JhZGRufHFkOc4-tMDHoH7a_tkZAqn1E5OZz7ZI5rFzssqNQwIKPvyqna03y0sYIfwQt0-iQVLq_DaOt9XiyadLru2DROKaDRJ0eSWs--x4y8n370CvCjp6aC5mQDRIIFRKZb6bzxVocI7Uw12-5v133UTKP-61nn1DqJSMKamMBLXdOMTvV5EDzu-6OEDihzPzwwEIE9WNeYdcPOam133WYYwR8MAiFNF-MGsOAXwedqq0VY1uxMSIDEs3fYqgROli37LDGw_FPF84Ubl1shAuPpTVCNAIb3lUoc8hw");
        cookieValue.add("7730934_48_52_123900_48_436380");
        cookieValue.add("872248f0-5d64-413c-9570-f0207a475d44");
        cookieValue.add("9a6a4970e54818d939d1421e30b4185ca02cea36211ef3155ab945cfad000904");
        cookieValue.add("AHWqTUnZlxLRB15h3UbUb7tcK2rSjEYPdddtcwy3ISAxxmEcKqmeg7qxO0M9S6kGP4o");
        cookieValue.add("AJHaeXL0GWsBZWZ-iiWlOd0lQ2_Y_20ymaOFzfaABnNQgVREN5mAqFmxCA");
        cookieValue.add("AVYB7cr2tGlLuMvZgL4RFNtP3BvUrU5FfJUpLLgLhXwGFNRVdd8aCGEa0Q");
        cookieValue.add("AfxxVi5z1HLxKJoFPbXVLTra2wfX_I40yEf4QnGxUoLKzUhr0cuBqA");
        cookieValue.add("CgQIn5wB");
        cookieValue.add("GA1.1.1167552931.1727989385");
        cookieValue.add("GA1.2.1236752161.1727989385");
        cookieValue.add("GS1.1.1728072910.4.1.1728073526.51.0.0");
        cookieValue.add("ID=100382f31df2ba30:T=1727989385:RT=1728073514:S=AA-Afjao8UVTr2ng72oFOt8gWawY");
        cookieValue.add("ID=5805af7599b729b0:T=1727989385:RT=1728073514:S=ALNI_MajHJGmAXECKMakqtsn9YnnV9D7xA");
        cookieValue.add("NO_DATA");
        cookieValue.add("PeraZdera");
        cookieValue.add("Q0QaSibjKvgUQIF0XFQkBVi9ZVOTJRk");
        cookieValue.add("UID=00000f1f8e8f4cc3:T=1727989385:RT=1728073514:S=ALNI_MYpGOjxe5-gRu9-ZZd77YnawyULRQ");
        cookieValue.add("b127951cf3069fdd897c5b715f0e3925");
        cookieValue.add("d3947f8f-edc3-7847-b66b-3ecb9d5229db#1727815448915#147");
        cookieValue.add("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6IlBlcmFaZGVyYSIsInBhc3N3b3JkIjoiUGVyYXpkZXJAMDY2IiwiaWF0IjoxNzI4MDczMDY3fQ.sSdeqS3IJzWaCTSrHiuTRnXyyU14fK9-hXFMyjYFnHg");
        cookieValue.add("panoDevice");

        driver.navigate().to("https://demoqa.com/profile");

        WebElement notLoggedInMessage = driver.findElement(By.id("notLoggin-label"));
        Assert.assertTrue(notLoggedInMessage.isDisplayed());


        for (int i = 0; i < cookieValue.size(); i++) {
            Cookie cookie = new Cookie(cookieName.get(i), cookieValue.get(i));
            System.out.println(cookieName.get(i) + " ::::: " + cookieValue.get(i));

            driver.manage().addCookie(cookie);

            driver.navigate().refresh();

        }

        driver.navigate().to("https://demoqa.com/login");
        WebElement alreadyLoggedInMessage = driver.findElement(By.id("loading-label"));
        Assert.assertTrue(alreadyLoggedInMessage.isDisplayed());
        System.out.println(alreadyLoggedInMessage.getText());

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
