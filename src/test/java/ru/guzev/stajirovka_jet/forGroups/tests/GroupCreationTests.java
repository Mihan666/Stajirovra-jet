package ru.guzev.stajirovka_jet.forGroups.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forGroups.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();

        GroupData group = new GroupData("test11", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}

