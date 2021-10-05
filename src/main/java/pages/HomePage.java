package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private int numberParagraphsContainingWord = 0;

    @FindBy(xpath = "//a[text()='Pyccкий']")
    private WebElement russianLink;

    @FindBy(xpath = "//p[contains(text (),'это текст')]")
    private WebElement firstParagraph;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement generateButton;

    @FindBy(xpath = "//input[@id='words']")
    private WebElement buttonWords;

    @FindBy(xpath = "//input[@id='bytes']")
    private WebElement buttonBytes;

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement numberField;

    @FindBy(xpath = "//input [@type='checkbox']")
    private WebElement checkBox;

    @FindBy(xpath = "//a[@title]")
    private WebElement backButton;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private List<WebElement> listOfParagraphs;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnRussianLink() {waitVisibilityOfElement(10, russianLink).click();}

    public boolean isWordPresent(String word) {
        return waitVisibilityOfElement(5, firstParagraph).getText().contains(word);
    }

    public void clickOnGenerate() {
        waitVisibilityOfElement(5, generateButton).click();
    }

    public void clickOnRightButton(String button) {
        switch (button) {
            case "words":
                waitVisibilityOfElement(5, buttonWords).click();
                break;
            case "bytes":
                waitVisibilityOfElement(5, buttonBytes).click();
                break;
        }
    }

    public void inputNumberOfElements(String number) {
        waitVisibilityOfElement(5, numberField).clear();
        numberField.sendKeys(number);
    }

    public void unchecksCheckBox() {
        waitVisibilityOfElement(5, checkBox).click();
    }

    public void countNumberOfParagraphs(String word, int times) {
        for (int i = 1; i <= times; i++) {
            waitVisibilityOfElement(5,generateButton).click();
            waitForPageLoadComplete(5);
            for (WebElement element: listOfParagraphs) {
                if(element.getText().toLowerCase().contains(word))
                    numberParagraphsContainingWord++;
                }
            backButton.click();
            }
        }

    public int findAverageParagraphsNumber(int times) {
        return numberParagraphsContainingWord / times;
    }
}





