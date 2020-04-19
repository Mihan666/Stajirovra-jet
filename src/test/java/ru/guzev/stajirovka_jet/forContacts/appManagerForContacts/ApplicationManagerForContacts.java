package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManagerForContacts {

    public ApplicationManagerForContacts(String browserType){
        this.browserType = browserType;
    }
    public WebDriver driver;
    private String browserType;

    private SessionHelperForContacts sessionHelperForContacts;
    private NavigationHelperForContacts navigationHelperForContacts;
    private ContactHelper contactHelper;

    public void init() {
        switch (browserType) {
            case BrowserType.CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case BrowserType.FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get("http://localhost/addressbook");
        sessionHelperForContacts = new SessionHelperForContacts(driver);
        contactHelper = new ContactHelper(driver);
        navigationHelperForContacts = new NavigationHelperForContacts(driver);
        sessionHelperForContacts.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelperForContacts goTo() {
        return navigationHelperForContacts;
    }
}
