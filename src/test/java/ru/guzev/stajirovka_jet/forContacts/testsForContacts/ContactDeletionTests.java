package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

public class ContactDeletionTests extends TestBaseForContacts {

    @Test
    public void testContactDeletion() throws Exception {
        if (! appForContacts.getContactHelper().isThereAContact()){
            appForContacts.getContactHelper().createContact(new GroupDataForContacts("Test1", "Test2", "8666666666", null));
        }
        appForContacts.getContactHelper().selectContact();
        appForContacts.getContactHelper().deleteSelectedContacts();
    }
}
