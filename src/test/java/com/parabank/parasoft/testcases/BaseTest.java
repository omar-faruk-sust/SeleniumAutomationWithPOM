package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import com.parabank.parasoft.util.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;
    Page page;

    @BeforeMethod
    public void setUpBrowser() {
        driver = new FirefoxDriver();
        driver.get(Common.BASE_URL);
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();;
    }
}
