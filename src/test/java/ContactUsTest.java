import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsTest {


    WebDriver driver = new ChromeDriver();

    @Before
    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void contact_us_test() {

        driver.findElement(By.cssSelector("div.footer-container  div:nth-child(2) li:nth-child(2) a")).click();
        driver.findElement(By.id("name")).sendKeys("S");
        driver.findElement(By.id("email")).sendKeys("teste@testgmail.com");
        driver.findElement((By.id("comment"))).sendKeys("What is your phone number?");
        driver.findElement(By.cssSelector("#contactForm div.buttons-set > button")).click();
        String message = driver.findElement(By.cssSelector("#messages_product_view")).getText();

        Assert.assertEquals("Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.", message);

    }

    @After
    public void exitBrowser() {
        driver.quit();
    }

}

