import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HerokuLoginPage extends PageBase {
    private static final String URL = "https://the-internet.herokuapp.com/login";

    // Locators for the login form
    private By usernameBy   = By.id("username");
    private By passwordBy   = By.id("password");
    private By loginButton  = By.cssSelector("button.radius");
    private By flashMessage = By.id("flash");
    private By logoutButton = By.xpath(
    "//a[contains(@class,'button') and contains(@class,'secondary') and contains(@class,'radius')]"
);

    public HerokuLoginPage(WebDriver driver) {
        super(driver);
        driver.get(URL);
        // Wait until the username field is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBy));
    }

    /** Fills in username and password, then clicks Login */
    public void loginAs(String user, String pass) {
        WebElement userInput = waitAndReturnElement(usernameBy);
        userInput.clear();
        userInput.sendKeys(user);

        WebElement passInput = waitAndReturnElement(passwordBy);
        passInput.clear();
        passInput.sendKeys(pass);

        waitAndReturnElement(loginButton).click();
    }


    public String getFlashText() {
        return waitAndReturnElement(flashMessage).getText();
    }

 
    public boolean isLogoutVisible() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(logoutButton)
        ) != null;
    }

    public void logout() {
        WebElement logoutButtonElement = waitAndReturnElement(logoutButton);
        if (logoutButtonElement != null) {
            logoutButtonElement.click();
        }
    }
}