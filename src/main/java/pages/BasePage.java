package pages;

import components.IFrame;
import components.IWaiting;
import components.TopBar;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Getter
public abstract class BasePage implements IFrame, IWaiting {

    private final TopBar topBar;

    public BasePage() {
        this.topBar = new TopBar(getDriver());
    }

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setDriverThreadLocal(WebDriver webDriver) {
        DRIVER_THREAD_LOCAL.set(webDriver);
    }

    public static WebDriver getDriver() {
        return DRIVER_THREAD_LOCAL.get();
    }

    public WebElement waitUntilVisible(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilClickable(WebElement element, int time) {
        return new WebDriverWait(getDriver(), time).until(ExpectedConditions.elementToBeClickable(element));
    }

    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    public void waitUntilTextWillPresent(By locator, int time, String text) {
        new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public void waitInvisibilityOf(By locator, int time) {
        new WebDriverWait(getDriver(), time)
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickWithJs(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void moveToElement(WebElement element) {
        new Actions(getDriver()).moveToElement(element).build().perform();
    }
}
