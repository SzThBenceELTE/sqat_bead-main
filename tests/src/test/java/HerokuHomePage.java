import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Models the main landing page of The Internet:
 * http://the-internet.herokuapp.com/
 */
public class HerokuHomePage {
    private static final String URL = "http://the-internet.herokuapp.com/";
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locator for the page's main heading
    private final By headingBy = By.tagName("h1");

    public HerokuHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, 10);
        driver.get(URL);
        // Wait until the <h1> is visible on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(headingBy));  // :contentReference[oaicite:0]{index=0}
    }

    /** @return the text of the <h1> element */
    public String getHeadingText() {
        WebElement heading = driver.findElement(headingBy);
        return heading.getText();                                             // :contentReference[oaicite:1]{index=1}
    }
}