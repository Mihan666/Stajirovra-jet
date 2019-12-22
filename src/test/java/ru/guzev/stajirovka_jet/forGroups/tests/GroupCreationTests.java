package ru.guzev.stajirovka_jet.forGroups.tests;

import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forGroups.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("test11", null, null));
    }
}

