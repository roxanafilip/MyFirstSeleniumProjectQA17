import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchTest {

    WebDriver driver = new ChromeDriver();

    @Before

    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void search_test() {
        driver.findElement(By.cssSelector("#search")).click();
        driver.findElement(By.cssSelector("#search")).sendKeys("dress");
        driver.findElement(By.cssSelector("#search_mini_form button")).click();


        List<WebElement> myListOfWebElements = driver.findElements(By.cssSelector("div.category-products h2 a"));

        boolean find_product = false;

        for (WebElement element : myListOfWebElements) {

            System.out.println("Search text in = " + element.getText());

            if (element.getText().contains("DRESS")) {
                find_product = true;
                break;
            } else {
                System.out.println("The product wasn’t found!");
            }
        }

        System.out.println(find_product);
        Assert.assertTrue(find_product);
    }

    @After
    public void exitBrowser() {
        driver.quit();
    }

}
