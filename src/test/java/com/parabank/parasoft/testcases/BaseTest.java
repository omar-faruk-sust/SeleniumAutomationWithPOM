package com.parabank.parasoft.testcases;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import com.parabank.parasoft.util.Common;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    LoremIpsum dataFaker;
    private Properties properties;

    public BaseTest() {

        dataFaker = LoremIpsum.getInstance();

        try {
            properties = new Properties();
            // System.getProperty("user.dir") will give you the project root path
            String filePath = System.getProperty("user.dir") + "/src/test/resources/config.properties";

            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void setUpBrowser() {
        String browserName = properties.getProperty("browserName");

        switch (browserName) {
            case Common.CHROME:
                ChromeOptions options = new ChromeOptions();
                options.setBrowserVersion("116.0.5845.111");
                driver = new ChromeDriver(options);
                break;

            case Common.CHROME_HEADLESS:
                driver = new ChromeDriver(
                        (ChromeOptions) new ChromeOptions()
                                .setBrowserVersion("116.0.5845.111")
                                .addArguments("--headless")
                );
                break;

            case Common.FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case Common.FIREFOX_HEADLESS:
                driver = new FirefoxDriver(
                        new FirefoxOptions().addArguments("--headless")
                );
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + browserName);
        }

        driver.get(this.getBaseUrl());
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public String getBaseUrl() {
        return properties.getProperty("url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
