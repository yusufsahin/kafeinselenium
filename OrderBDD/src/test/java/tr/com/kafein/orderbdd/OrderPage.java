package tr.com.kafein.orderbdd;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Date;

import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class OrderPage {
    private WebDriver driver;
    @FindBy(id = "Name")
    private WebElement nameField;

    @FindBy(name = "Line1")
    private WebElement line1Field;

    @FindBy(name = "Line2")
    private WebElement line2Field;

    @FindBy(id = "Line3")
    private WebElement line3Field;

    @FindBy(id = "City")
    private WebElement cityField;

    @FindBy(id = "State")
    private WebElement stateField;

    @FindBy(id = "Zip")
    private WebElement zipField;

    @FindBy(id = "Country")
    private WebElement countryField;

    @FindBy(css = ".btn-primary")
    private WebElement confirmOrderButton;

    @FindBy(css = "h2")
    private WebElement confirmationHeader;

    @FindBy(linkText = "Return to Store")
    private WebElement returnToStoreButton;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public  OrderPage enterDetails(String name, String line1, String line2, String line3, String city, String state, String zip,String country) throws IOException {
        nameField.sendKeys(name);
        line1Field.sendKeys(line1);
        line2Field.sendKeys(line2);
        line3Field.sendKeys(line3);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipField.sendKeys(zip);
        countryField.sendKeys(country);
        takeScreenShot("screenshot_order_info");
        return  this;
    }
    public OrderPage submitOrder() {
        confirmOrderButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
        return this;
    }
    public String getConfirmationText() throws IOException {
        return confirmationHeader.getText();

    }
    public OrderPage returnToStore() throws IOException {
        takeScreenShot("screenshot_return_to_store");
        returnToStoreButton.click();
        return this;
    }
    private void waitForElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }

    private void takeScreenShot(String image) throws IOException {


        TakesScreenshot screenshotTaker= (TakesScreenshot) driver;

        File screenshotFile= screenshotTaker.getScreenshotAs(OutputType.FILE);

        File destinationFile= new File("src/test/resources/"+ image+ new Date().getTime()+".png");

        Files.copy(screenshotFile.toPath(),destinationFile.toPath());
    }
}
