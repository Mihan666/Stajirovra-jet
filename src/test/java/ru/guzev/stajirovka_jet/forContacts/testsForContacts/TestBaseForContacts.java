package ru.guzev.stajirovka_jet.forContacts.testsForContacts;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.guzev.stajirovka_jet.forContacts.appManagerForContacts.ApplicationManagerForContacts;

public class TestBaseForContacts {

    protected static final ApplicationManagerForContacts appForContacts = new ApplicationManagerForContacts(BrowserType.CHROME);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        appForContacts.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        appForContacts.stop();
    }

    public ApplicationManagerForContacts getAppForContacts() {
        return appForContacts;
    }
}
