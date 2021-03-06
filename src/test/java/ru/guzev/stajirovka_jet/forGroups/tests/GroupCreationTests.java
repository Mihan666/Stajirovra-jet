package ru.guzev.stajirovka_jet.forGroups.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forGroups.model.GroupData;

import java.util.Comparator;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();

        GroupData group = new GroupData().withName("test11");
        app.group().create(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(group);
        Comparator<? super GroupData> byId = (q1, q2) -> Integer.compare(q1.getId(),q1.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }
}

