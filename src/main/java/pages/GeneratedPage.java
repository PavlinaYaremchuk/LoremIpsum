package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GeneratedPage extends BasePage {

    @FindBy(xpath = "//div[@id='lipsum']/p[1]")
    private WebElement firstPhrase;

    @FindBy(xpath = "//div[@id='lipsum']/p")
    private WebElement generatedText;

    public GeneratedPage(WebDriver driver) {super(driver);}

    public boolean firstPhrase(String phrase) {
        return waitVisibilityOfElement(5, firstPhrase).getText().startsWith(phrase);
    }

    public void compareResults(String number, String button) {
        if (button.equals("words"))
            assertEquals(Integer.parseInt(number), generatedText.getText().split(" ").length);
        else if (button.equals("bytes"))
            assertEquals(Integer.parseInt(number), generatedText.getText()
                    .getBytes(StandardCharsets.UTF_8).length);
    }

    public void startingPhrase(String phrase) {
        assertFalse(firstPhrase.getText().startsWith(phrase));
    }
}


