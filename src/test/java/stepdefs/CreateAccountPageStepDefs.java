package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CreateAccountPage;

import static components.UserConfig.*;
import static org.assertj.core.api.Assertions.*;

public class CreateAccountPageStepDefs {
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @And("I fill the form with valid data")
    public void i_fill_valid_data() {
        createAccountPage.fillRegistration(FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, BIRTHDATE);
    }

    @Given("I fill First name field with James8 and rest fields valid data")
    public void i_fill_invalid_data() {
        createAccountPage.fillRegistrationWithInvalidData(INVALID_NAME, LAST_NAME, EMAIL, PASSWORD, BIRTHDATE);
    }

    @And("I check that First name higlighted in red")
    public void i_check_border_color() {
        assertThat(createAccountPage.borderFirstName()).isEqualTo(FIRST_NAME_BORDER_RED_COLOR);
    }

    @Then("I check that pop-up with text {string} appear under field")
    public void i_check_error_message(String message) {
        assertThat(createAccountPage.errorMessage()).isEqualTo(message);
    }
}
