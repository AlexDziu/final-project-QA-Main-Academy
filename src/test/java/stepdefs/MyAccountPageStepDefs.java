package stepdefs;

import io.cucumber.java.en.Then;
import pages.MyAccountPage;

import static components.UserConfig.*;
import static org.assertj.core.api.Assertions.*;

public class MyAccountPageStepDefs {
    MyAccountPage myAccountPage = new MyAccountPage();

    @Then("I check my name appear near cart button")
    public void check_registration_successful() {
        assertThat(myAccountPage.checkUserInfo()).contains(FIRST_AND_LAST_NAME);
    }
}
