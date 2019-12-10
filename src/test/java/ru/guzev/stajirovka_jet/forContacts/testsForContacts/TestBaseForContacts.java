package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.guzev.stajirovka_jet.forContacts.appManagerForContacts.ApplicationManagerForContacts;

public class TestBaseForContacts {

    protected final ApplicationManagerForContacts appForContacts = new ApplicationManagerForContacts();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        appForContacts.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        appForContacts.stop();
    }

    public ApplicationManagerForContacts getAppForContacts() {
        return appForContacts;
    }
}
