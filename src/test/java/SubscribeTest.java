import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubscribeTest {
    WebDriver driver = new ChromeDriver();


    @Before
    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void subscribe_test() {
        driver.findElement(By.cssSelector("#newsletter")).sendKeys("test@testgmail.com");
        driver.findElement(By.cssSelector("#newsletter-validate-detail div.actions ")).click();

        String message = driver.findElement(By.cssSelector(" li > ul span")).getText();

        Assert.assertEquals("Thank you for your subscription.", message);

    }

    @After
    public void exitBrowser() {
        driver.quit();
    }

}
