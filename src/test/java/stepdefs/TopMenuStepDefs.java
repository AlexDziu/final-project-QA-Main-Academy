package stepdefs;

import components.TopMenu;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.*;
import static pages.BasePage.getDriver;

public class TopMenuStepDefs {
    TopMenu topMenu = new TopMenu(getDriver());

    @When("I check that {string} and {string} items appears in CLOTHES")
    public void i_check_items_in_clothes(String man, String women) {
        assertThat(topMenu.checkClothesItems()).contains(man);
        assertThat(topMenu.checkClothesItems()).contains(women);
    }

    @And("I check that {string} and {string} items appears in ACCESSORIES")
    public void i_check_items_in_accessories(String stationery, String homeAccessories) {
        assertThat(topMenu.checkAccessoriesItems()).contains(stationery);
        assertThat(topMenu.checkAccessoriesItems()).contains(homeAccessories);
    }

    @Then("I check that no any items appears in ART")
    public void i_check_items_in_art() {
        assertThat(topMenu.checkArtItems()).isEqualTo(true);
    }
}
