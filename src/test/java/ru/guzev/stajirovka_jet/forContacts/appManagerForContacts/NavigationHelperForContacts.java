package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelperForContacts extends HelperBaseForContacts {

    public NavigationHelperForContacts(WebDriver driver) {
        super(driver);
    }

    public void goToAddContact() {
        click(By.linkText("add new"));
    }
}
