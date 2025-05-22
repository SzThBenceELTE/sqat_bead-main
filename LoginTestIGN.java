// // LoginTestIGN.java
// import static org.junit.Assert.*;
// import org.junit.*;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import java.net.URL;

// public class LoginTestIGN {
//     private RemoteWebDriver driver;
//     private LoginPageIGN loginPage;

//     @Before
//     public void setUp() throws Exception {
//         ChromeOptions opts = new ChromeOptions();
//         driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), opts);
//         driver.manage().window().maximize();
//         loginPage = new LoginPageIGN(driver);
//     }

//     @Test
//     public void testIGNLogin() {
//         loginPage.openLoginModal();
//         loginPage.login("szthbence@gmail.com", "Asdasd123");
//         assertTrue("User should be logged in, avatar must display", loginPage.isLoggedIn());  // Verify success :contentReference[oaicite:16]{index=16}
//     }

//     @After
//     public void tearDown() {
//         if (driver != null) driver.quit();
//     }
// }