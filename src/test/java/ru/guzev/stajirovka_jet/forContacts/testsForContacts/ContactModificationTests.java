package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

public class ContactModificationTests extends TestBaseForContacts {
    @Test
    public void testContactModification() {
        appForContacts.getContactHelper().selectContact();
        appForContacts.getContactHelper().initContactModification();
        appForContacts.getContactHelper().fillContactForm(new GroupDataForContacts("Test1", "Test2", "8666666666", "Test@mail.iu"));
        appForContacts.getContactHelper().submitContactModification();
        appForContacts.getContactHelper().returnToHomePage();
    }
}
