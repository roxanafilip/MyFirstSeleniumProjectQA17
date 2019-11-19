import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

        @Test
        public void login_test() {
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            driver.get("http://testfasttrackit.info/selenium-test/");
            WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
            accountLink.click();

            driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();

            driver.findElement(By.cssSelector("#email")).sendKeys("filip.roxana95@gmail.com");

            driver.findElement(By.cssSelector("#pass")).sendKeys("11martie11");

            driver.findElement(By.cssSelector("#send2")).click();

            driver.close();

        }


    }

