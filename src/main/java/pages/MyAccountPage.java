package pages;

import components.UserConfig;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static utils.ScreenShotUtils.*;

@Slf4j
@Getter
public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//div[@class='user-info']//span[@class='hidden-sm-down' and contains(text(),'" + UserConfig.FIRST_AND_LAST_NAME + "')]")
    private WebElement userInfo;

    public MyAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @Step("Check user info")
    public String checkUserInfo() {
        waitUntilVisible(userInfo, 10);
        log.info("Check user info");
        makeScreenshot();
        return userInfo.getText();
    }
}
