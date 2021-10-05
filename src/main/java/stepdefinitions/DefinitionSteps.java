package stepdefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GeneratedPage;
import pages.HomePage;

import static org.junit.Assert.assertTrue;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    GeneratedPage generatedPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @Given("User opens home page")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User clicks on language link Russian")
    public void clickOnLanguageLinkRussian() {
        homePage.clickOnRussianLink();
    }

    @Then("User checks that the first paragraph contains the keyword")
    public void findTheWord(String word) {
        assertTrue(homePage.isWordPresent(word));
    }

    @When("User clicks on Generate Lorem Ipsum button")
    public void clickOnGenerateButton() {
        homePage.clickOnGenerate();
    }

    @Then("User checks that the first paragraph starts with phrase")
    public void checkParagraphStartsWithPhrase(String phrase) {
        generatedPage = pageFactoryManager.getGeneratedPage();
        assertTrue(generatedPage.firstPhrase(phrase));
    }

    @When("User clicks on {string}")
    public void clickOnButton(String button) {
        homePage.clickOnRightButton(button);
    }

    @And("User inputs {string} into the number field")
    public void inputNumberIntoNumberField(String number) {
        homePage.inputNumberOfElements(number);
    }

    @Then("User checks that the result has correct number of words {string} {string}")
    public void compareNumberWords(String number, String button) {
        generatedPage = pageFactoryManager.getGeneratedPage();
        generatedPage.compareResults(number, button);
    }

    @When("User unchecks start with Lorem Ipsum checkbox")
    public void UnchecksStartWithLoremIpsumCheckbox() {
        homePage.unchecksCheckBox();
    }

    @Then("User result no longer starts with phrase")
    public void resultNoLongerStartsWithPhrase(String phrase) {
        generatedPage = pageFactoryManager.getGeneratedPage();
        generatedPage.startingPhrase(phrase);
    }


    @When("User counts the paragraphs containing {string} clicking on Generate Lorem Ipsum button {int}")
    public void countsParagraphsWithTestingWord(String word, int times) {
            homePage.countNumberOfParagraphs(word, times);
    }

    @Then("User checks that the average paragraphs number containing word {int}")
    public void checkAverageParagraphsNumber(int times) {
        assertTrue(homePage.findAverageParagraphsNumber(times)>=2);

    }

   @After
   public void tearDown() {driver.close();}
}
