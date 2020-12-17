package stepdefs;

import io.cucumber.java.en.And;
import pages.SignInPage;

public class SignInPageStepDefs {
    SignInPage signInPage = new SignInPage();

    @And("I click on No account? Create one here link")
    public void i_click_create_one_here_link() {
        signInPage.clickOnCreateAccount();
    }
}
