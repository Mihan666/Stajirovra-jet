package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

public class ContactHelper extends HelperBaseForContacts {
    NavigationHelperForContacts navigationHelperForContacts;


    public ContactHelper(WebDriver driver) {
        super(driver);
        navigationHelperForContacts = new NavigationHelperForContacts(driver);
    }

    public void returnToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
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
        driver.switchTo().alert().accept();
    }

    public void selectContact() {
        click(By.xpath("//input[@name='selected[]']"));
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void createContact(GroupDataForContacts contact) {
        navigationHelperForContacts.goToAddContact();
        fillContactForm(new GroupDataForContacts("Test1", "Test2", "8666666666", null));
        submitContactCreation();
        returnToHomePage();

    }


    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

}
