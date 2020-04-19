package ru.guzev.stajirovka_jet.forGroups.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void groupPage() {

        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups") &&
                isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }
}
