package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

public class ContactCreationTests extends TestBaseForContacts {

    @Test
    public void testContactCreation() throws Exception {
        appForContacts.getContactHelper().createContact(new GroupDataForContacts("Test1", "Test2", "8666666666", null));
    }
}
