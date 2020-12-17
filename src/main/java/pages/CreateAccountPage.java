package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountPage extends BasePage {

    @FindBy(xpath = "//label[@class='radio-inline'][1]//input")
    private WebElement selectMr;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement fieldFirstName;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement fieldLastName;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement fieldBirthdate;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement selectReceive;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement selectCustomer;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement selectNewsLetter;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement selectIAgree;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveButton;

    @FindBy(xpath = "//li[@class='alert alert-danger']")
    private WebElement invalidFormatMessage;

    public CreateAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void fillRegistration(String firstName, String lastName, String email,
                                 String password, String birthdate) {
        selectMr.click();
        waitUntilVisible(fieldFirstName, 5).sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        fieldBirthdate.sendKeys(birthdate);
        selectReceive.click();
        selectCustomer.click();
        selectNewsLetter.click();
        selectIAgree.click();
        waitUntilClickable(saveButton, 10).click();
        saveButton.click();
    }

    public void fillRegistrationWithInvalidData(String firstName, String lastName, String email,
                                                String password, String birthdate) {
        selectMr.click();
        waitUntilVisible(fieldFirstName, 5).sendKeys(firstName);
        fieldLastName.sendKeys(lastName);
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        fieldBirthdate.sendKeys(birthdate);
        selectReceive.click();
        selectCustomer.click();
        selectNewsLetter.click();
        selectIAgree.click();
        waitUntilClickable(saveButton, 10).click();
        saveButton.click();
    }

    public String borderFirstName() {
        return waitUntilVisible(fieldFirstName, 10).getCssValue("outline-color");
    }

    public String errorMessage() {
        return waitUntilVisible(invalidFormatMessage, 10).getText();
    }
}
