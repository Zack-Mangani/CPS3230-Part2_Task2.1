package test.cps3230.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    private final WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductCount() {
        WebElement productCountElement = driver.findElement(By.cssSelector("div.srp-controls__count h2.srp-controls__count-heading"));
        String productCountText = productCountElement.getText();
        return Integer.parseInt(productCountText.replaceAll("[^0-9]", ""));
    }

    public String getSpecificTextAfterBold() {
        By searchResultsLocator = By.cssSelector("h1.srp-controls__count-heading span.BOLD");
        WebElement searchResultsCountElement = driver.findElement(searchResultsLocator);
        String h1Text = searchResultsCountElement.getText();
        int startIndex = h1Text.indexOf("<span class=\"BOLD\">") + "<span class=\"BOLD\">".length();
        int endIndex = h1Text.indexOf("</span>", startIndex);
        return h1Text.substring(endIndex + "</span>".length());
    }

    public int getNumberOfResults() {
        By searchResultsLocator = By.cssSelector("h1.srp-controls__count-heading span.BOLD");

        // Wait for the search results count to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchResultsCountElement = wait.until(ExpectedConditions.presenceOfElementLocated(searchResultsLocator));

        // Extract the numeric value from the text (e.g., "43,000,000" becomes 43000000)
        String numericValue = searchResultsCountElement.getText().replaceAll("[^0-9]", "");

        return Integer.parseInt(numericValue);
    }
}
