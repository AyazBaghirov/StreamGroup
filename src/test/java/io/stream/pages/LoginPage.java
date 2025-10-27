package io.stream.pages;

import io.stream.utilities.BrowserUtils;
import io.stream.utilities.DocuportConstants;
import io.stream.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userNameInput;


    @FindBy (xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy (xpath = "//*[.=' Login ']")
    public WebElement loginText;

    @FindBy (xpath = "//img[@src='/img/logo.d7557277.svg']")
    public WebElement docuportText;

    @FindBy (xpath = "//h3[.='Choose account']")
    public WebElement chooseAccountText;



    public void insertField(String field, String input){
        switch (field.toLowerCase().trim()){
            case "username" -> BrowserUtils.waitForVisibility(userNameInput, DocuportConstants.LARGE).sendKeys(input);
            case "password" -> BrowserUtils.waitForVisibility(passwordInput, DocuportConstants.LARGE).sendKeys(input);
            default -> throw new IllegalArgumentException("No such a field: " + field);
        }
    }

    public void clickButton(String button){
        switch (button.toLowerCase().trim()){
            case "login" -> BrowserUtils.waitForClickable(loginButton, DocuportConstants.LARGE).click();
            case "continue" -> {
                try {
                    BrowserUtils.waitForClickable(continueButton, DocuportConstants.LARGE).click();
                } catch (StaleElementReferenceException e){
                    WebElement element = Driver.getDriver().findElement(By.xpath("//span[.=' Continue ']"));
                    BrowserUtils.waitForClickable(element, DocuportConstants.LARGE).click();
                }
            }
            default -> throw new IllegalArgumentException("Not such a button: " + button);
        }
    }


    /**
     * Logins to docuport
     * @param username
     * @param password
     */
    public void login(String username, String password) throws InterruptedException {
        BrowserUtils.waitForClickable(loginButton, 10);
        userNameInput.clear();
        userNameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        Thread.sleep(5000);
//        if(BrowserUtils.waitForVisibility(loginButton, 10).isDisplayed()){
//            loginButton.click();
//        }
    }
    public void login(WebDriver driver, String role) throws InterruptedException {
        switch (role.toLowerCase()) {
            case "client":
                userNameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                userNameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                userNameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                userNameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            default:
                throw new InterruptedException("There is not such a role: " + role);
        }
    }


}
