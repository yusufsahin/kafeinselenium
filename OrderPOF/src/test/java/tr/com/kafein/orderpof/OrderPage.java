package tr.com.kafein.orderpof;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "Name")
    private WebElement nameField;

    @FindBy(id = "Line1")
    private WebElement line1Field;
    @FindBy(id = "Line2")
    private WebElement line2Field;
    @FindBy(id = "Line3")
    private WebElement line3Field;

    @FindBy(name = "City")
    private WebElement cityField;

    @FindBy(name = "State")
    private WebElement stateField;

    @FindBy(name = "Zip")
    private WebElement zipField;

    @FindBy(name = "Country")
    private WebElement countryField;

    @FindBy(css = ".btn-primary")
    private WebElement submitOrderButton;

    @FindBy(xpath = "//input[@value='Confirm Order']")
    private WebElement confirmationOrderButton;

    @FindBy(css = "h2")
    private WebElement confirmationHeader;

    @FindBy(linkText = "Return to Store")
    private WebElement returnToStoreButton;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    @ParameterizedTest
    @CsvSource({
            "John Doe, 123 Main St, Apt 4, , Springfield, Illinois, 62704, USA",

    })
    public void enterDetails(String name, String line1, String line2, String line3, String city, String state, String zip, String country) {
        nameField.sendKeys(name);
        line1Field.sendKeys(line1);
        line2Field.sendKeys(line2);
        line3Field.sendKeys(line3);

        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zip);
        countryField.sendKeys(country);
    }

    public void submitOrder() {
        submitOrderButton.click();
        wait.until(ExpectedConditions.textToBe(By.cssSelector("h2"), "Thanks!"));
    }

    public void returnToStore() {
        returnToStoreButton.click();
    }

    public String getConfirmationText() {
        waitForElement(confirmationHeader);
        return confirmationHeader.getText();
    }

    private void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
