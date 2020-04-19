package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.List;

public class ContactDeletionTests extends TestBaseForContacts {

    @BeforeMethod
    public void ensurePreconditions(){
        if (!appForContacts.contact().isThereAContact()) {
            appForContacts.contact().create(new GroupDataForContacts()
                    .withFirstName("FirstName1").withLastName("LastName2").withPhone("8666666666"));
        }
    }

    @Test
    public void testContactDeletion() throws Exception {
        List<GroupDataForContacts> before = appForContacts.contact().list();
        int index = before.size() - 1;
        appForContacts.contact().delete(index);
        List<GroupDataForContacts> after = appForContacts.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1); //проверка срабатывает через раз

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}
