package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forContacts.modelForContacts.GroupDataForContacts;


import java.util.Comparator;

import java.util.List;

public class ContactCreationTests extends TestBaseForContacts {

    @Test
    public void testContactCreation() {
        List<GroupDataForContacts> before = appForContacts.getContactHelper().getContactList();
        GroupDataForContacts contact = new GroupDataForContacts("FirstName1", "LastName2", "8666666666", null);
        appForContacts.getContactHelper().createContact(contact);
        List<GroupDataForContacts> after = appForContacts.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super GroupDataForContacts> byId = (q1, q2) -> Integer.compare(q1.getId(),q1.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
//        AssertJ сравнение Set`ов без учета порядка элементов
//        Assertions.assertThat(new HashSet<>(after))
//                .containsExactlyInAnyOrderElementsOf(new HashSet<>(before));
    }
}
