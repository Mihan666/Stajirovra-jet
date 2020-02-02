package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.List;

public class ContactDeletionTests extends TestBaseForContacts {

    @Test
    public void testContactDeletion() throws Exception {
        if (!appForContacts.getContactHelper().isThereAContact()) {
            appForContacts.getContactHelper().createContact(new GroupDataForContacts("Test1", "Test2", "8666666666", null));
        }
        List<GroupDataForContacts> before = appForContacts.getContactHelper().getContactList();
        appForContacts.getContactHelper().selectContact(before.size() - 1);
        appForContacts.getContactHelper().deleteSelectedContacts();
        List<GroupDataForContacts> after = appForContacts.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }
}
