package stepdefs;

import components.TopBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.BasePage.getDriver;

public class TopBarStepDefs {
    TopBar topBar = new TopBar(getDriver());

    @When("I click on the list of languages")
    public void i_click_on_the_languages() {
        topBar.clickOnLanguagesButton();
    }

    @And("I see that {int} languages exists in Language dropdown in the top menu")
    public void i_see_languages_exists(int amountLanguages) {
        assertThat(topBar.checkAmountLanguages()).isEqualTo(amountLanguages);
    }
}
