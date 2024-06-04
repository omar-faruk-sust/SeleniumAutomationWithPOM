package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By selector) {
        WebElement element = null;
        try {
            element = driver.findElement(selector);
        } catch (Exception e) {
            System.out.println(selector.toString() + "Selector not found in the page!");
        }

        return element;
    }

    @Override
    public List<WebElement> getWebElements(By selector) {
        List<WebElement> elements = null;
        try{
            elements = driver.findElements(selector);
        }catch (Exception e) {
            System.out.println(selector.toString() + "Selector not found in the page!");
        }

        return elements;
    }

    @Override
    public void waitForElement(By selector) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        }catch (Exception e) {
            System.out.println(selector.toString() + "Was not able to load the element!");
        }
    }
}
