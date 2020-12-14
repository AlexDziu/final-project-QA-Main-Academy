package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.BasePage;

public class DriverManager {

    public static void setUpDriver() {
        String browserFromProperty = System.getProperty("chrome");
        setBrowser(browserFromProperty);
    }

    public static void setBrowser(String browser) {
        WebDriver driver;
        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("internetExplorer")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException();
        }
        driver.manage().window().maximize();
        BasePage.setDriverThreadLocal(driver);

    }

    public static void quiteDriver() {
        BasePage.getDriver().quit();
    }
}
