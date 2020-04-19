package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBaseForContacts {

    //из-за бага в приложении, после нажатия кнопки "update" контакт удаляется, а не сохраняются изменения

    @BeforeMethod
    public void ensurePreconditions(){
        if (appForContacts.contact().list().size()==0) {
            appForContacts.goTo().addContact();
            appForContacts.contact().create(new GroupDataForContacts().withFirstName("FirstName1").withLastName("LastName2").withPhone("8666666666"));
        }
    }

    @Test
    public void testContactModification() {
        List<GroupDataForContacts> before = appForContacts.contact().list();
        int index = before.size() - 1;
        GroupDataForContacts contacts = new GroupDataForContacts().withId(before.get(index).getId()).withFirstName("FirstName1").withLastName("LastName2").withPhone("8666666666").withEmail("Test@mail.iu");
        List<GroupDataForContacts> after = appForContacts.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(contacts);
        Comparator<? super GroupDataForContacts> byId = (q1, q2) -> Integer.compare(q1.getId(),q1.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
