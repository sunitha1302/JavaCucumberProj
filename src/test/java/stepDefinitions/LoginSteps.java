package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.pages.LoginPage;
import utils.WebDriverSetup;

public class LoginSteps {

    WebDriver driver = WebDriverSetup.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    @Given("User navigates to the login page")
    public void user_navigates_to_the_login_page()
    {
        driver.get("https://www.saucedemo.com/");
    }
    @When("User enters valid credentials {string} and {string}")
    public void user_enters_valid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the inventory")
    public void user_should_be_redirected() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        driver.quit();
    }
}
