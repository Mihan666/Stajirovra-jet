package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBaseForContacts {

    @Test
    public void testContactCreation() {
        List<GroupDataForContacts> before = appForContacts.getContactHelper().getContactList();
        GroupDataForContacts contact = new GroupDataForContacts("FirstName1", "LastName2", "8666666666", null);
        appForContacts.getContactHelper().createContact(contact);
        List<GroupDataForContacts> after = appForContacts.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupDataForContacts g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        contact.setId(max);
        before.add(contact);

        Assert.assertEquals(new HashSet<>(after), new HashSet<>(before));
//        AssertJ сравнение Set`ов без учета порядка элементов
//        Assertions.assertThat(new HashSet<>(after))
//                .containsExactlyInAnyOrderElementsOf(new HashSet<>(before));
    }
}
