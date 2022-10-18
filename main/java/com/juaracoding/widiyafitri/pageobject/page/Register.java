package com.juaracoding.widiyafitri.pageobject.page;

import com.juaracoding.widiyafitri.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {
    private WebDriver driver;

    public Register() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "reg_username")
    WebElement addUsername;

    @FindBy(id = "reg_email")
    WebElement addEmail;

    @FindBy(id = "reg_password")
    WebElement addPassword;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span")
    WebElement hideShowPassword;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")
    WebElement btnRegister;

    public void registerForm(String addUsername, String addEmail, String addPassword) {
        this.addUsername.sendKeys(addUsername);
        System.out.println("Creat username");
        this.addEmail.sendKeys(addEmail);
        System.out.println("Insert email");
        this.addPassword.sendKeys(addPassword);
        System.out.println("Creat password");
        hideShowPassword.click();
        System.out.println("Click for hide/show password ");
        btnRegister.click();
        System.out.println("Click register button");
    }
}
