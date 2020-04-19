package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelperForContacts extends HelperBaseForContacts {

    public NavigationHelperForContacts(WebDriver driver) {
        super(driver);
    }

    public void addContact() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))){
            return;
        }
        click(By.linkText("add new"));
    }
}
