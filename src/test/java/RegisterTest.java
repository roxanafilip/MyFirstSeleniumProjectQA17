import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.apache.commons.lang3.RandomStringUtils.random;


public class RegisterTest {

    @Test
    public void register() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://testfasttrackit.info/selenium-test/");

        driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a")).click();

        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();

        driver.findElement(By.id("firstname")).sendKeys("User");

        driver.findElement(By.id("middlename")).sendKeys("I");

        driver.findElement((By.id("lastname"))).sendKeys("User");

        String email = random(5, true, false);

        driver.findElement(By.id("email_address")).sendKeys(email + "@gmail.com");

        driver.findElement(By.id("password")).sendKeys("1234.");

        driver.findElement(By.id("confirmation")).sendKeys("1234.");

        driver.findElement(By.cssSelector("#is_subscribed")).click();

        driver.quit();


    }
}
