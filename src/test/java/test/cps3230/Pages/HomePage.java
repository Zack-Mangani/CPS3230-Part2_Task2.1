package test.cps3230.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToEbayWebsite() {
        driver.get("https://www.ebay.co.uk/");
    }

    public void clickOnCategory(String categoryName) {
        WebElement shopByCategoryButton = driver.findElement(By.id("gh-shop-a"));
        shopByCategoryButton.click();

        WebElement allCategoriesLink = driver.findElement(By.id("gh-shop-see-all-center"));
        allCategoriesLink.click();
        WebElement categoryLink = driver.findElement(By.xpath("//h3[@class='cat-title']/a[text()='" + categoryName + "']"));

        categoryLink.click();
    }



    public void searchForProduct(String searchTerm) {
        WebElement searchInput = driver.findElement(By.id("gh-ac"));
        searchInput.clear();
        searchInput.sendKeys(searchTerm);
        searchInput.sendKeys(Keys.ENTER);
    }
}
