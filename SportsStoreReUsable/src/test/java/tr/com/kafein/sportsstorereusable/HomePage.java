package tr.com.kafein.sportsstorereusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public  void selectProduct()
    {
        driver.findElement(By.linkText("Home")).click();driver.findElement(By.linkText("Home")).click();
    }

    public void addToCart(){
        driver.findElement(By.xpath("//button[@type=\'submit\']")).click();
        // 5 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 6 | waitForElementPresent | xpath=//h2[contains(.,'Your cart')] | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(.,\'Your cart\')]")));
        }
    }

    public void goToCheckOut() {
        driver.findElement(By.linkText("Checkout")).click();
        // 8 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 9 | waitForElementVisible | xpath=//h2[contains(.,'Check out now')] | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(.,\'Check out now\')]")));
        }
    }
}
