import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTest {
    WebDriver driver = new ChromeDriver();

    @Before
    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void log_out_test() {
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();

        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();

        driver.findElement(By.cssSelector("#email")).sendKeys("filip.roxana95@gmail.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("11martie11");

        WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
        loginButton.click();

        driver.findElement(By.cssSelector("#header div.skip-links > div > a span.label")).click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();

        String message = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col1-layout > div > div > div.page-title > h1")).getText();
        Assert.assertEquals("YOU ARE NOW LOGGED OUT", message);

    }

    @After
    public void exitBrowser() {
        driver.quit();
    }


}
