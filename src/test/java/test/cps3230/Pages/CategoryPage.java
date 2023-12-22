package test.cps3230.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {

    private final WebDriver driver;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderofCategory() {
        try {
            WebElement headerElement = driver.findElement(By.cssSelector("h1.title-banner__title"));
            return headerElement.getText();
        } catch (NoSuchElementException e) {
            WebElement headerElement = driver.findElement(By.cssSelector("span.b-pageheader__text"));
            return headerElement.getText();
        }
    }

    public int getProductCount() {
        WebElement productCountElement = driver.findElement(By.cssSelector("div.srp-controls__count h2.srp-controls__count-heading"));
        String productCountText = productCountElement.getText();
        return Integer.parseInt(productCountText.replaceAll("[^0-9]", ""));
    }

    public String getFirstProductLink() { //this method is both used in CategoryPage and SearchResultsPage
        try {
            WebElement defaultProductLink = driver.findElement(By.cssSelector("ul.b-list__items_nofooter li.s-item--large a.s-item__link"));
            String hrefValue = defaultProductLink.getAttribute("href");
            return hrefValue;

        } catch (NoSuchElementException e) {
            WebElement firstProductLink = driver.findElement(By.cssSelector("ul.srp-results li.s-item a.s-item__link"));
            String hrefValue = firstProductLink.getAttribute("href");
            return hrefValue;
        }

    }

    public void clickOnFirstProduct() {
        try {
            WebElement defaultProductLink = driver.findElement(By.cssSelector("ul.b-list__items_nofooter li.s-item--large a.s-item__link"));
            defaultProductLink.click();
        } catch (NoSuchElementException e) {
            WebElement firstProductLink = driver.findElement(By.cssSelector("ul.srp-results li.s-item a.s-item__link"));
            firstProductLink.click();
        }

        String parentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
