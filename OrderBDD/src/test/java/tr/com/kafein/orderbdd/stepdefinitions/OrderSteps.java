package tr.com.kafein.orderbdd.stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import tr.com.kafein.orderbdd.HomePage;
import tr.com.kafein.orderbdd.OrderPage;

import java.time.Duration;

/*
Feature:Placing order on SportsStore
  Scenario: User places an order
    Given User is on sportsstore homepage
    When User clicks on category
    And User adds product to the cart
    And User proceeds to checkout
    And User fills order information
    Then User should see order confirmation message
    Then Return To Store
 */
public class OrderSteps {
    private WebDriver driver;
    private HomePage homePage;
    private OrderPage orderPage;

    @Given("User is on sportsstore homepage")
    public void user_is_on_sportsstore_homepage()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://sportsstore.innovium.net/");

        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
    }

    @When("User clicks on category")
    public void  user_clicks_on_category(){
        homePage.selectCategory("Chess");
    }

    @And("User adds product to the cart")
    public void user_adds_product_to_the_cart(){
        homePage.addtoCart(1);
    }
    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout(){
        homePage.goToCheckout();
    }

    @And("User_fills_order_information")
    public void user_fills_order_information(){
        orderPage.enterDetails("John Doe", "ABC Bulv.", "996677 Str.", "No:10", "New York", "NY", "456677", "USA");
    }

    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message(){
        orderPage.submitOrder();
        Assert.assertEquals(orderPage.getConfirmationText(),"Thanks!");
    }

    @Then("Return To Store")
    public void returnToStore(){
        orderPage.returnToStore();
    }

}
