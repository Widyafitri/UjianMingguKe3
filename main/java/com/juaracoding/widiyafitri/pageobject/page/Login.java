package com.juaracoding.widiyafitri.pageobject.page;

import com.juaracoding.widiyafitri.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    public Login() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span")
    WebElement passwordHideShow;

    @FindBy(id = "rememberme")
    WebElement Rememberme;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/button")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id=\"post-8\"]/div/div/nav/ul/li[2]/a")
    WebElement order;


    public void loginForm(String email, String password) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        this.username.sendKeys(email);
        System.out.println("input username or email login");
        this.password.sendKeys(password);
        System.out.println("input password login");
        passwordHideShow.click();
        Rememberme.click();
        System.out.println("Ceklist Rememberme");
        js.executeScript("arguments[0].click();", btnLogin);


    }
}
