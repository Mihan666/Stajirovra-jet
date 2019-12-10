package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManagerForContacts {
    public WebDriver driver;

    private SessionHelperForContacts sessionHelperForContacts;
    private NavigationHelperForContacts navigationHelperForContacts;
    private ContactHelper contactHelper;

    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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


    public ContactHelper getContactHelper() {
        return contactHelper;
    }

    public NavigationHelperForContacts getNavigationHelperForContacts() {
        return navigationHelperForContacts;
    }
}