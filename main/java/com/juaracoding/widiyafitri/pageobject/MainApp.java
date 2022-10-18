package com.juaracoding.widiyafitri.pageobject;

import com.juaracoding.widiyafitri.pageobject.page.AddtoCart;
import com.juaracoding.widiyafitri.pageobject.page.Dashboard;
import com.juaracoding.widiyafitri.pageobject.page.Login;
import com.juaracoding.widiyafitri.pageobject.page.Register;
import com.juaracoding.widiyafitri.pageobject.drivers.DriverSingleton;
import com.juaracoding.widiyafitri.pageobject.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainApp {
        public static void main(String[] args) {

                DriverSingleton.getInstance(Constants.CHROME);
                WebDriver driver = DriverSingleton.getDriver();
                JavascriptExecutor js = (JavascriptExecutor) driver;

                Dashboard dashboard = new Dashboard();
                driver.get(Constants.URL);
                dashboard.dashboard();

                Register register = new Register();
                driver.get(Constants.LOGURL);
                register.registerForm("Rinjani", "rinjani1354@gmail.com", "rinjani3456");
                driver.navigate().back();
                driver.navigate().refresh();

                Login login = new Login();
                login.loginForm("rinjani1354@gmail.com", "rinjani3456");


                AddtoCart addCart = new AddtoCart();
                driver.get(Constants.SHOPURL);
                js.executeScript("window.scrollBy(0,600)");
                addCart.browserProduct();



                driver.get(Constants.URLITEM);
                js.executeScript("window.scrollBy(0,500)");
                addCart.addToCart();

                try {
                        Thread.sleep(5000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }

                driver.quit();

        }
}
