package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.List;

public class ContactDeletionTests extends TestBaseForContacts {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!appForContacts.getContactHelper().isThereAContact()) {
            appForContacts.getContactHelper().createContact(new GroupDataForContacts("Test1", "Test2", "8666666666", null));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        List<GroupDataForContacts> before = appForContacts.getContactHelper().getContactList();
        int index = before.size() - 1;
        appForContacts.getContactHelper().selectContact(index);
        appForContacts.getContactHelper().deleteSelectedContacts();
        List<GroupDataForContacts> after = appForContacts.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index); //проверка срабатывает через раз

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
