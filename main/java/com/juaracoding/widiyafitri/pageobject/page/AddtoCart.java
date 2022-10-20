package com.juaracoding.widiyafitri.pageobject.page;

import com.juaracoding.widiyafitri.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddtoCart {


    private WebDriver driver;

    public AddtoCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[3]/div/h3/a")
    WebElement itemClick;

    @FindBy(id = "pa_color")
    WebElement colorOption;

    @FindBy(id = "pa_size")
    WebElement sizeOption;

    @FindBy(xpath = "//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")
    WebElement itemQty;

    @FindBy(xpath = "//*[@id=\"product-1281\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement btnAddCart;

    @FindBy(id = "nav-menu-item-cart")
    WebElement btnViewCart;

    public void browserProduct() {
        itemClick.click();
        System.out.println("Click Item");
    }

    public void addToCart() {
        Select selectColorOption = new Select(this.colorOption);
        Select selectSizeOption = new Select(this.sizeOption);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        selectColorOption.selectByIndex(1);
        System.out.println("Choose Color Option");
        selectSizeOption.selectByIndex(3);
        System.out.println("Choose Size Option");
        itemQty.click();
        System.out.println("Click quantity button");
        btnAddCart.click();
        System.out.println("Click addcart button");
        btnViewCart.click();
        System.out.println("Click view cart");
        js.executeScript("window.scrollBy(0,500)");

    }
}
