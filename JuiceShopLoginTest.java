// import static org.junit.Assert.assertTrue;  
// import org.junit.After;  
// import org.junit.Before;  
// import org.junit.Test;  
// import org.openqa.selenium.chrome.ChromeOptions;  
// import org.openqa.selenium.remote.RemoteWebDriver;  

// import java.net.URL;  

// public class JuiceShopLoginTest {
//     private RemoteWebDriver driver;  
//     private LoginPage loginPage;  

//     @Before
//     public void setUp() throws Exception {
//         ChromeOptions options = new ChromeOptions();  
//         driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);  // remote Selenium Grid :contentReference[oaicite:6]{index=6}  
//         driver.manage().window().maximize();  
//         loginPage = new LoginPage(driver);  
//     }

//     @Test
//     public void testPageTitle() {
//         driver.get("https://juice-shop.herokuapp.com/#/");  // :contentReference[oaicite:4]{index=4}
//         String title = driver.getTitle();  
//         System.out.println("Page title is: " + title);  
//         assertTrue(
//             "Title should mention 'Juice Shop'", 
//             title.toLowerCase().contains("juice shop")  // :contentReference[oaicite:5]{index=5}
//         );
//     }

//     @Test
//     public void testValidLogin() {
//         Boolean loginSuccess = loginPage.loginAs("asdasd@asdasd.com", "asdasd");       // valid Juice Shop creds :contentReference[oaicite:7]{index=7}
//         assertTrue(
//             "Login should be successful",
//             loginSuccess
//         );
//     }

//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();                                                         
//         }
//     }
// }