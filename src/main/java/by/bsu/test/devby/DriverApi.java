package by.bsu.test.devby;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverApi {

    private final WebDriver driver;

    public DriverApi(final WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(final String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public String findText(final String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    public void findAndSend(final String xpath, final String keys) {
        find(xpath).sendKeys(keys);
    }

    public void findAndClick(final String xpath) {
        find(xpath).click();
    }
}
