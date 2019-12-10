package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelperForContacts extends HelperBaseForContacts {


    public SessionHelperForContacts(WebDriver driver) {
        super(driver);
    }

    public void login(String userName, String password) {
        type(By.name("user"), userName);
        type(By.name("pass"), password);
        click(By.xpath("//input[@value='Login']"));
    }
}
