package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.guzev.stajirovka_jet.forContacts.appManagerForContacts.ApplicationManagerForContacts;

public class TestBaseForContacts {

    protected final ApplicationManagerForContacts appForContacts = new ApplicationManagerForContacts(BrowserType.CHROME);

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
