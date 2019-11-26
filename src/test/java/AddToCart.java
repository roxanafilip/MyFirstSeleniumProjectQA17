import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToCart {

    WebDriver driver = new ChromeDriver();


    @Before
    public void intDriver() {
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver");
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }


    /**
     * Scop: Verifica ca in cos au fost adaugate 2 produse in cos fara logare
     */
    @Test
    public void add_to_cart_without_loginTest() {

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent "))).build().perform();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > ul > li.level1.nav-1-4.last > a")).click();

        driver.findElement(By.cssSelector("#product-collection-image-424")).click();

        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();

        driver.findElement(By.cssSelector("#swatch15 > span.swatch-label > img")).click();

        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("2");

        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        String number = driver.findElement(By.cssSelector("#header span.count")).getText();
        System.out.println("Produse din cos = " + number);
        Assert.assertEquals("2", number);
    }

    /**
     * Scop: Verifica ca in cos au fost adaugate 2 produse in cos cu logare
     */

    @Test

    public void add_to_cart_with_loginTest() {
        WebElement accountLink = driver.findElement(By.cssSelector("div.skip-links > div > a"));
        accountLink.click();

        driver.findElement(By.cssSelector("#header-account li.last ")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("filip.roxana95@gmail.com");
        driver.findElement(By.cssSelector("#pass")).sendKeys("11martie11");

        WebElement loginButton = driver.findElement(By.cssSelector("#send2"));
        loginButton.click();

        driver.findElement(By.cssSelector("#header div.skip-links div div [class=\"icon\"]")).click();
        driver.findElement(By.cssSelector("#header-cart > div.minicart-wrapper > div.minicart-actions > a")).click();

        driver.findElement(By.cssSelector("#empty_cart_button ")).click();
        driver.findElement(By.cssSelector("#header div.skip-links > div > div")).click();
        String message = driver.findElement(By.cssSelector("div.page-title")).getText();

        Assert.assertEquals("SHOPPING CART IS EMPTY", message);

        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent "))).build().perform();

        driver.findElement(By.cssSelector("#nav > ol > li.level0.nav-1.first.parent > ul > li.level1.nav-1-4.last > a")).click();

        driver.findElement(By.cssSelector("#product-collection-image-424")).click();

        driver.findElement(By.cssSelector("#swatch76 > span.swatch-label")).click();

        driver.findElement(By.cssSelector("#swatch15 > span.swatch-label > img")).click();

        driver.findElement(By.cssSelector("#qty")).clear();
        driver.findElement(By.cssSelector("#qty")).sendKeys("2");

        driver.findElement(By.cssSelector("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button > span > span")).click();
        String number = driver.findElement(By.cssSelector("#header span.count")).getText();
        System.out.println("Produse din cos = " + number);
        Assert.assertEquals("2", number);

    }

    @After
    public void exitBrowser() {
        driver.quit();
    }

}
