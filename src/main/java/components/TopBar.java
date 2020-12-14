package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static pages.BasePage.getDriver;

@Getter
public class TopBar {
    private static WebDriver webDriver;
    private static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @FindBy(xpath = "//i[@class='material-icons expand-more']")
    private WebElement languagesButton;

    @FindBy(xpath = "//ul[@class='dropdown-menu hidden-sm-down']")
    private WebElement dropDownList;

    public TopBar(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
        webDriver = driver;
        wait = new WebDriverWait(getDriver(), 5);
    }

    public TopBar clickOnLanguagesButton() {
        wait.until(ExpectedConditions.visibilityOf(languagesButton)).click();
        return this;
    }

    public int checkAmountLanguages() {
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//ul[@class='dropdown-menu hidden-sm-down']//li"));
        return webElementList.size();
    }

    public void checkUkrLanguageExist(String ukrLanguage) {
        wait.until(ExpectedConditions.visibilityOf(dropDownList));

    }


}
