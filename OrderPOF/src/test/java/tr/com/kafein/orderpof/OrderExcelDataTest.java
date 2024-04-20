package tr.com.kafein.orderpof;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

public class OrderExcelDataTest {
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
    private static Stream<Arguments> provideData() {
        List<Object[]> data = ExcelReader.readExcel("C:\\Projects\\KafeinSelenium\\OrderPOF\\src\\test\\resources\\data.xlsx");
        return data.stream().map(Arguments::of);
    }
    @ParameterizedTest
    @MethodSource("provideData")
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
