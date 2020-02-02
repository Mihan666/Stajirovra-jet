package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.List;

public class ContactModificationTests extends TestBaseForContacts {
    //из-за бага в приложении, после нажатия кнопки "update" контакт удаляется, а не сохраняются изменения
    @Test
    public void testContactModification() {
        if (!appForContacts.getContactHelper().isThereAContact()) {
            appForContacts.getNavigationHelperForContacts().goToAddContact();
            appForContacts.getContactHelper().createContact(new GroupDataForContacts("Test1", "Test2", "8666666666", null));
        }
        List<GroupDataForContacts> before = appForContacts.getContactHelper().getContactList();
        appForContacts.getContactHelper().selectContact(before.size() - 1);
        appForContacts.getContactHelper().initContactModification();
        appForContacts.getContactHelper().fillContactForm(new GroupDataForContacts("Test1", "Test2", "8666666666", "Test@mail.iu"));
        appForContacts.getContactHelper().submitContactModification();
        appForContacts.getContactHelper().returnToHomePage();
        List<GroupDataForContacts> after = appForContacts.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}
