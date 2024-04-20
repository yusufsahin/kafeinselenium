package tr.com.kafein.sportsstorereusable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderPage {
    WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterDetials(){
        driver.findElement(By.id("Name")).click();
        // 11 | type | id=Name | John Doe
        driver.findElement(By.id("Name")).sendKeys("John Doe");
        // 12 | click | id=Line1 |
        driver.findElement(By.name("Line1")).click();
        // 13 | type | id=Line1 | Silicon Hill Blv
        driver.findElement(By.name("Line1")).sendKeys("Silicon Hill Blv");
        // 14 | click | css=.form-group:nth-child(5) |
        driver.findElement(By.cssSelector(".form-group:nth-child(5)")).click();
        // 15 | click | id=Line2 |
        driver.findElement(By.id("Line2")).click();
        // 16 | type | id=Line2 | No 9
        driver.findElement(By.id("Line2")).sendKeys("No 9");
        // 17 | click | id=Line3 |
        driver.findElement(By.xpath("//*[@id='Line3']")).click();
        // 18 | type | id=Line3 | 6785
        driver.findElement(By.id("Line3")).sendKeys("6785");
        // 19 | click | id=City |


        driver.findElement(By.id("City")).click();
        // 20 | type | id=City | Austin
        driver.findElement(By.id("City")).sendKeys("Austin");
        // 21 | click | id=State |
        driver.findElement(By.id("State")).click();
        // 22 | type | id=State | TX
        driver.findElement(By.id("State")).sendKeys("TX");
        // 23 | click | id=Zip |
        driver.findElement(By.id("Zip")).click();
        // 24 | type | id=Zip | 56422
        driver.findElement(By.id("Zip")).sendKeys("56422");
        // 25 | click | id=Country |

        driver.findElement(By.id("Country")).click();
        // 26 | type | id=Country | USA
        driver.findElement(By.id("Country")).sendKeys("USA");
        // 27 | click | css=.btn-primary |

    }

    public void submitOrder(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
        // 28 | click | css=h2 |
        driver.findElement(By.cssSelector("h2")).click();
        // 29 | waitForElementVisible | css=h2 | 30000
        {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2")));
        }
        // 30 | click | css=p:nth-child(3) |
        driver.findElement(By.cssSelector("p:nth-child(3)")).click();
        // 31 | assertText | css=p:nth-child(3) | We'll ship your goods as soon as possible.
      ///  assertEquals(driver.findElement(By.cssSelector("p:nth-child(3)")).getText(), "We'll ship your goods as soon as possible.");
        // 32 | click | linkText=Return to Store |

    }

    public void returnToStore(){
        driver.findElement(By.linkText("Return to Store")).click();
    }

    public  String getConfirmationText(){
        return driver.findElement(By.cssSelector("p:nth-child(3)")).getText();
    }

}
