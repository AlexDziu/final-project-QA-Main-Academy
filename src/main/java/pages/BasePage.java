package pages;

import components.IFrame;
import components.TopBar;
import components.TopMenu;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class BasePage implements IFrame {

    private final TopBar topBar;
    private final TopMenu topMenu;

    public BasePage() {
        this.topBar = new TopBar(getDriver());
        this.topMenu = new TopMenu(getDriver());
    }

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriverThreadLocal(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public static WebElement waitUntilVisible(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilClickable(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time).until(ExpectedConditions.elementToBeClickable(element));
    }

}
