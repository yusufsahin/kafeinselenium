package tr.com.kafein.orderpof;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText ="Home")
    private WebElement homeLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//h2")
    private WebElement h2Element;

    @FindBy(xpath ="//h2[contains(.,'Your cart')]")
    private WebElement yourCartElement;

    @FindBy(linkText = "Checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//h2[contains(.,'Check out now')]")
    private WebElement checkoutNowElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Use a single instance for waiting
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        homeLink.click();
    }

    public void addToCart() {
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(yourCartElement));
    }

    public void goToCheckOut() {
        checkoutButton.click();
        wait.until(ExpectedConditions.visibilityOf(checkoutNowElement));
    }
}

