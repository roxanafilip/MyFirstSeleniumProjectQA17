import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddReviewTest {

    WebDriver driver = new ChromeDriver();

    @Before
    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void add_review_test() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > a"))).build().perform();
        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-3.parent > ul > li.level1.nav-3-1.first > a")).click();
        driver.findElement(By.cssSelector("div.main-container.col3-layout div.col-wrapper div.col-main div.category-products ul li div  h2 a")).click();
        driver.findElement(By.cssSelector("div.wrapper div.main-container.col1-layout div.col-main div.product-collateral.toggle-content.tabs li.last")).click();
        driver.findElement(By.cssSelector("#customer-reviews a")).click();
        driver.findElement(By.cssSelector("#Price_1")).click();
        driver.findElement(By.cssSelector("#Value_3")).click();
        driver.findElement(By.cssSelector("#Quality_2")).click();
        driver.findElement(By.cssSelector("#review_field")).sendKeys("kfdhfgrurugh");
        driver.findElement(By.cssSelector("#summary_field")).sendKeys("hdkjkeruujfh");
        driver.findElement(By.cssSelector("#nickname_field")).sendKeys("kdwf");
        driver.findElement(By.cssSelector(" div.buttons-set > button")).click();
        String message = driver.findElement(By.cssSelector("body div.page > div.main-container.col1-layout div.col-main > ul")).getText();
        Assert.assertEquals("Your review has been accepted for moderation.", message);


    }

    @After
    public void exitBrowser() {
        driver.quit();
    }

}







