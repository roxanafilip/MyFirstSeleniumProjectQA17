import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {


    WebDriver driver = new ChromeDriver();

    @Before
    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    @Test
    public void login_test() {
        login_method();
    }

    @After
    public void exitBrowser() {
        driver.quit();
    }


    private void login_method() {

        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();

        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();

        driver.findElement(By.cssSelector("#email")).sendKeys("filip.roxana95@gmail.com");

        driver.findElement(By.cssSelector("#pass")).sendKeys("11martie11");

        WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
        loginButton.click();
    }


}







