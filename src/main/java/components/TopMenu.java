package components;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static pages.BasePage.getDriver;

@Getter
public class TopMenu {
    private final WebDriver webDriver;
    private final WebDriverWait wait;
    private final Actions actions;

    @FindBy(xpath = "//li[@id='category-3']")
    private WebElement clothes;

    @FindBy(xpath = "//li[@id='category-6']")
    private WebElement accessories;

    @FindBy(xpath = "//li[@id='category-9']")
    private WebElement art;

    public TopMenu(WebDriver driver) {
        PageFactory.initElements(getDriver(), this);
        webDriver = driver;
        wait = new WebDriverWait(getDriver(), 15);
        actions = new Actions(getDriver());
    }

    public String checkClothesItems() {
        wait.until(ExpectedConditions.visibilityOf(clothes));
        actions.moveToElement(getDriver().findElement(By.xpath("//li[@id='category-3']"))).build().perform();
        ArrayList<String> listItems = new ArrayList<>();
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//li[@id='category-3']//li"));
        for (WebElement element : webElementList) {
            String man = element.findElement(By.xpath("//li[@id='category-3']//li[1]")).getText();
            String woman = element.findElement(By.xpath("//li[@id='category-3']//li[2]")).getText();
            listItems.add(man);
            listItems.add(woman);
        }
        return String.valueOf(listItems);
    }

    public String checkAccessoriesItems() {
        wait.until(ExpectedConditions.visibilityOf(accessories));
        actions.moveToElement(getDriver().findElement(By.xpath("//li[@id='category-6']"))).build().perform();
        ArrayList<String> listItems = new ArrayList<>();
        List<WebElement> webElementList = getDriver().findElements(By.xpath("//li[@id='category-6']//li"));
        for (WebElement element : webElementList) {
            String stationary = element.findElement(By.xpath("//li[@id='category-6']//li[1]")).getText();
            String accessories = element.findElement(By.xpath("//li[@id='category-6']//li[2]")).getText();
            listItems.add(stationary);
            listItems.add(accessories);
        }
        return String.valueOf(listItems);
    }

    public boolean checkArtItems() {
        wait.until(ExpectedConditions.visibilityOf(art));
        actions.moveToElement(getDriver().findElement(By.xpath("//li[@id='category-9']"))).build().perform();
        return art.isDisplayed();
    }
}
