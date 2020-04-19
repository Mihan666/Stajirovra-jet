package ru.guzev.stajirovka_jet.forContacts.appManagerForContacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.ArrayList;
import java.util.List;

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
        driver.switchTo().alert().accept(); //кликает на всплывающее окно подтверждения действия
    }

    public void selectContact(int index) {
        driver.findElements(By.xpath("//input[@name='selected[]']")).get(index).click();
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void create(GroupDataForContacts contact) {
        navigationHelperForContacts.addContact();
        fillContactForm(contact);
        submitContactCreation();
        returnToHomePage();

    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContacts();
    }

    public void modify(int index, GroupDataForContacts contacts) {
        selectContact(index);
        initContactModification();
        fillContactForm(contacts);
        submitContactModification();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//input[@name='selected[]']"));
    }

    public int getContactCount() {
        return driver.findElements(By.xpath("//input[@name='selected[]']")).size();
    }

    public List<GroupDataForContacts> list() {
        List<GroupDataForContacts> contacts = new ArrayList<GroupDataForContacts>();
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@class]"));//улучшить локатор
        for (WebElement element : elements) {

            String firstName = element.findElements(By.xpath("./td")).get(2).getText();
            String lastName = element.findElements(By.xpath("./td")).get(1).getText();
            String phone = element.findElements(By.xpath("./td")).get(5).getText();

            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new GroupDataForContacts().withId(id).withFirstName(firstName).withLastName(lastName).withPhone(phone));
        }
        return contacts;
    }
}