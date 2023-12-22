package test.cps3230.ebay;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import test.cps3230.Pages.CategoryPage;
import test.cps3230.Pages.HomePage;
import test.cps3230.Pages.SearchResultsPage;

public class EbaySteps {

    private static WebDriver driver;
    private String firstProductLinkHref;

    //private final WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private CategoryPage categoryPage;

    public EbaySteps() {
        // WebDriver
        System.setProperty("webdriver.chrome.driver", "C:/Users/zackm/webtesting/chromedriver-win64/chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:/Users/zackm/webtesting/chrome-win64/chrome.exe");
        driver = new ChromeDriver(co);
    }


    @Given("I am a user of the online shopping website")
    public void iAmAUserOfTheOnlineShoppingWebsite() {
        homePage = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        categoryPage = new CategoryPage(driver);
    }

    @When("I visit the website")
    public void iVisitTheWebsite() {
        homePage.navigateToEbayWebsite();
    }

    @And("I click on the {string} category")
    public void iClickOnTheCategory(String arg0) {
        homePage.clickOnCategory(arg0);
    }

    @Then("I should be taken to the {string} category")
    public void iShouldBeTakenToTheCategory(String arg0) {
        String actualHeaderText = categoryPage.getHeaderofCategory();
        Assert.assertEquals( arg0, actualHeaderText);

    }

    @And("the category should show at least {int} products")
    public void theCategoryShouldShowAtLeastProducts(int arg0) {
        int actualProductCount = categoryPage.getProductCount();
        int expectedMinimumProductCount = arg0;
        Assert.assertTrue(actualProductCount >= expectedMinimumProductCount);
    }

    @When("I click on the first product in the results")
    public void iClickOnTheFirstProductInTheResults() {
        firstProductLinkHref = categoryPage.getFirstProductLink();
        categoryPage.clickOnFirstProduct();

    }

    @Then("I should be taken to the details page for that product")
    public void iShouldBeTakenToTheDetailsPageForThatProduct() {
        String currentUrl = categoryPage.getCurrentUrl();
        Assert.assertEquals(currentUrl,firstProductLinkHref);
        //webAutomation.closeBrowser();
    }


    @When("I search for a product using the term {string}")
    public void iSearchForAProductUsingTheTerm(String arg0) {
        homePage.navigateToEbayWebsite();
        homePage.searchForProduct(arg0);
    }

    @Then("I should see the search results")
    public void iShouldSeeTheSearchResults() {
        searchResultsPage.getSpecificTextAfterBold();
    }

    @And("there should be at least {int} products in the search results")
    public void thereShouldBeAtLeastProductsInTheSearchResults(int arg0) {
        int SearchProductCount = searchResultsPage.getNumberOfResults();
        System.out.println(SearchProductCount);
        Assert.assertTrue(SearchProductCount >= arg0);
    }


}
