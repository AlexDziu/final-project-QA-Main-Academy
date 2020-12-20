package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MainPage;

import static org.assertj.core.api.Assertions.*;

public class MainPageStepDefs {

    MainPage mainPage = new MainPage();

    @Given("I am on the demo.prestashop.com main page")
    public void i_am_on_the_main_page() {
        mainPage.openMainPage();
    }

    @When("I enter {string} email")
    public void i_enter_email(String email) {
        mainPage.scrollVisibleTextSubscribe();
        mainPage.enterEmail(email);
    }

    @Then("I check that error message {string} appears")
    public void i_see_error_message(String errorMessage) {
        assertThat(mainPage.getErrorMessage()).isEqualTo(errorMessage);
    }


}
