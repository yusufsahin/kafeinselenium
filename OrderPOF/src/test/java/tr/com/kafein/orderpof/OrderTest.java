package tr.com.kafein.orderpof;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class OrderTest {
    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @ParameterizedTest
    @CsvSource({
            "John Doe, Main Blv, 5432 Str, No 5, Austin, Texas, 34567, USA",
            "Jane Doe, Second St, 1234 Ave, Apartment 7, Dallas, Texas, 67890, USA",
            "Sue Doe, Third St, 4321 Ave, Apartment 9, Dallas, Texas, 67890, USA"
    })
    public void order(String name, String line1, String line2, String line3, String city, String state, String zip, String country) {
        homePage.selectProduct();
        homePage.addToCart();
        homePage.goToCheckOut();

        orderPage.enterDetails(name, line1, line2, line3, city, state, zip, country);
        orderPage.submitOrder();

        Assertions.assertEquals("Thanks!", orderPage.getConfirmationText());

        orderPage.returnToStore();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
