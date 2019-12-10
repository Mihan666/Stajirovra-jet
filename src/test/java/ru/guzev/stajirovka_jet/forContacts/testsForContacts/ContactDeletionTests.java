package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBaseForContacts {

    @Test
    public void testContactDeletion() throws Exception {
        appForContacts.getContactHelper().selectContact();
        appForContacts.getContactHelper().deleteSelectedContacts();
    }
}
