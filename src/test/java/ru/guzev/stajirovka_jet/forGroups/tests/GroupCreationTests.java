package ru.guzev.stajirovka_jet.forGroups.tests;

import org.testng.annotations.Test;
import ru.guzev.stajirovka_jet.forGroups.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test11", "test22", "test33"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }
}

