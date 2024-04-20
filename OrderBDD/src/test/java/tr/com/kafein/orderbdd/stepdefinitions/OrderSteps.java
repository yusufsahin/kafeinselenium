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

import java.io.IOException;
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

    @When("User fills order information with name {string}, line1 {string}, line2 {string}, line3 {string}, city {string}, state {string}, zip {string}, and country {string}")
    public void user_fills_order_information_with_name_line1_line2_line3_city_state_zip_and_country(String name, String line1, String line2, String line3, String city, String state, String zip, String country) throws IOException {
        orderPage.enterDetails(name, line1, line2,line3, city, state, zip, country);
    }

    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message() throws IOException {
        orderPage.submitOrder();
        Assert.assertEquals(orderPage.getConfirmationText(),"Thanks!");
    }

    @Then("Return To Store")
    public void returnToStore() throws IOException {
        orderPage.returnToStore();

        if (driver!=null){
            driver.quit();
        };
    }

}
