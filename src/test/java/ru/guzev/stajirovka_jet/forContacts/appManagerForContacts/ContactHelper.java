package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

public class ContactHelper extends HelperBaseForContacts {

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void fillContactForm(GroupDataForContacts contactGroupData) {
        type(By.name("firstname"), contactGroupData.getFirstName());
        type(By.name("lastname"), contactGroupData.getLastName());
        type(By.name("mobile"), contactGroupData.getPhone());
        type(By.name("email"), contactGroupData.getEmail());
    }

    public void deleteSelectedContacts() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void selectContact() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }
}
