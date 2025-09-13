package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    WebDriver driver;

    // Locators
    @FindBy(id = "email")   // Adjust locator as per actual HTML
    private WebElement usernameInput;
    
    public void enterUsername(String username) {
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    @FindBy(id = "password")
    private WebElement passwordInput;
    
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement loginButton;
    public void clickLogin() {
        loginButton.click();
    }

    // Constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}

