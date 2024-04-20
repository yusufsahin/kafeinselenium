package tr.com.kafein.sportsstorereusable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class OrderTest {
    private WebDriver driver;
    HomePage homePage;
    OrderPage orderPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options= new ChromeOptions();
        // options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage= new HomePage(driver);
        orderPage= new OrderPage(driver);
    }

    @Test
    public void testOrder() {
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheckOut();
        orderPage.enterDetials();
        orderPage.submitOrder();
        Assertions.assertEquals(orderPage.getConfirmationText(),"We'll ship your goods as soon as possible.");
        orderPage.returnToStore();
    }

    @Test
    public void testSelectProduct() {
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheckOut();

    }

    @AfterEach
    public void tearDown() {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
