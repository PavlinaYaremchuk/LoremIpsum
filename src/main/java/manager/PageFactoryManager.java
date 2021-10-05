package manager;

import org.openqa.selenium.WebDriver;
import pages.GeneratedPage;
import pages.HomePage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {this.driver = driver;}

    public HomePage getHomePage() {return new HomePage(driver);}

    public GeneratedPage getGeneratedPage() {return new GeneratedPage(driver);}
}
