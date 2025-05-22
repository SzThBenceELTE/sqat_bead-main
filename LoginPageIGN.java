// // LoginPageIGN.java
// import org.openqa.selenium.*;
// import org.openqa.selenium.support.ui.*;

// public class LoginPageIGN {
//     private static final String HOME = "https://www.ign.com";
//     private WebDriver driver;
//     private WebDriverWait wait;

//     // Locators
//     private By signInLink        = By.cssSelector("a[data-testid='auth-login-button']");
//     private By modalRoot         = By.cssSelector("div[data-testid='auth-modal']");
//     private By emailInput        = By.cssSelector("input[name='email']");
//     private By passwordInput     = By.cssSelector("input[name='password']");
//     private By submitButton      = By.cssSelector("button[data-testid='auth-modal-submit-button']");
//     private By avatarIcon        = By.cssSelector("img[data-testid='profile-avatar']");

//     public LoginPageIGN(WebDriver driver) {
//         this.driver = driver;
//         this.wait   = new WebDriverWait(driver, 10);
//         driver.get(HOME);  // Navigate to IGN :contentReference[oaicite:9]{index=9}
//     }

//         public void openLoginModal() {
//         wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
//         wait.until(ExpectedConditions.visibilityOfElementLocated(modalRoot));
//     }

//     public void login(String email, String password) {
//         wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
//         wait.until(ExpectedConditions.elementToBeClickable(passwordInput)).sendKeys(password);
//         wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
//     }

//     public boolean isLoggedIn() {
//         // If the avatar shows up, we're in
//         return wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon)) != null;
//     }
// }