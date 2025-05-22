// import org.openqa.selenium.By;  
// import org.openqa.selenium.WebDriver;  
// import org.openqa.selenium.WebElement;  
// import org.openqa.selenium.support.ui.ExpectedConditions;  
// import org.openqa.selenium.support.ui.WebDriverWait;  

// public class LoginPage {
//     private static final String URL = "https://demo.owasp-juice.shop/#/login";  
//     private final WebDriver driver;  
//     private final WebDriverWait wait;  

//     //private static By titleBy = By.tagName("title");

//     // 1. Locators for the login form elements  
//     private final By emailField    = By.id("email");                       
//     private final By passwordField = By.id("password");        
//     private final By loginButton = By.cssSelector("button[aria-label='Login']");            
//     //private final By loginButton   = By.id("loginButton");
//     // private final By loginButton = By.xpath("//button[contains(., 'Login')]");
//     //private final By bannerToast   = By.cssSelector("div.mat-snack-bar-container");  

//     public LoginPage(WebDriver driver) {
//         this.driver = driver;  
//         this.wait   = new WebDriverWait(driver, 10);                        // 10-second explicit wait :contentReference[oaicite:0]{index=0}
//         driver.get(URL);                                                    // navigate to the login hash route :contentReference[oaicite:1]{index=1}
//         wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));  
//     }

//     /**  
//      * Fills in credentials and clicks the login button,  
//      * then waits for the post-login toast/banner to appear.  
//      * @param email    the user's email address  
//      * @param password the user's password  
//      * @return the text of the success or error banner  
//      */  
//     public Boolean loginAs(String email, String password) {
//         WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(emailField));  
//         emailInput.clear();  
//         emailInput.sendKeys(email);                                          // enter email :contentReference[oaicite:2]{index=2}
//         System.out.println("Email: " + email);                            // print email to console
//         WebElement passInput = wait.until(ExpectedConditions.elementToBeClickable(passwordField));  
//         passInput.clear();  
//         passInput.sendKeys(password);                                        // enter password :contentReference[oaicite:3]{index=3}
//         System.out.println("Password: " + password);                      // print password to console
//         wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();  // click 'Log in' :contentReference[oaicite:4]{index=4}
//         System.out.println("Login button clicked");                       // print message to console
//         // wait for the snack-bar banner to show up (success or failure)  
//         //WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(bannerToast));  
//         return true;                                          // return its message text :contentReference[oaicite:5]{index=5}
//     }

//     public String getPageTitle() {
//         return driver.getTitle();  
//     }
// }