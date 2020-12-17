package pages;

import components.UserConfig;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//div[@class='user-info']//span[@class='hidden-sm-down' and contains(text(),'"+ UserConfig.FIRST_AND_LAST_NAME+"')]")
    private WebElement userInfo;

    public MyAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String checkUserInfo() {
        waitUntilVisible(userInfo, 10);
        return userInfo.getText();
    }
}
