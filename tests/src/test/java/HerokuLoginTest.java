import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class HerokuLoginTest {
    private RemoteWebDriver driver;
    private HerokuLoginPage loginPage;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        // Uncomment to run headless:
        // options.addArguments("--headless", "--disable-gpu");
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
        loginPage = new HerokuLoginPage(driver);
    }

    @Test
    public void testPageTitle() {
        // 1. Navigate
        driver.get("http://the-internet.herokuapp.com/login");  
        // 2. Retrieve the <title>
        String title = driver.getTitle();              // :contentReference[oaicite:0]{index=0}:contentReference[oaicite:1]{index=1}
        System.out.println("Page title is: " + title);
        // 3. Basic assertion
        assertTrue(
            "Title should mention 'The Internet'", 
            title.toLowerCase().contains("the internet")
        );                                            // :contentReference[oaicite:2]{index=2}
    }

    @Test
    public void testSuccessfulLogin() {
        // 1. Perform login with valid credentials
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");  // :contentReference[oaicite:2]{index=2}

        // 2. Verify the flash message contains success text
        String flash = loginPage.getFlashText();
        assertTrue(
            "Flash message should indicate successful login",
            flash.toLowerCase().contains("you logged into a secure area!")  // :contentReference[oaicite:3]{index=3}
        );

        // 3. Verify the Logout button is now visible
        assertTrue(
            "Logout button should be visible after login",
            loginPage.isLogoutVisible()
        );
    }

    @Test
    public void testSuccessfulLogout() {
        // 1. Perform login with valid credentials
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");  // :contentReference[oaicite:2]{index=2}

        // 2. Verify the flash message contains success text
        String flash = loginPage.getFlashText();
        assertTrue(
            "Flash message should indicate successful login",
            flash.toLowerCase().contains("you logged into a secure area!")  // :contentReference[oaicite:3]{index=3}
        );

        // 3. Verify the Logout button is now visible
        assertTrue(
            "Logout button should be visible after login",
            loginPage.isLogoutVisible()
        );
    }

    @Test
    public void testLogout() {
        // 1. Perform login with valid credentials
        loginPage.loginAs("tomsmith", "SuperSecretPassword!");  // :contentReference[oaicite:2]{index=2}
        // 2. Click the Logout button
        loginPage.logout();

        assertTrue(
            "Flash message should indicate successful logout",
            loginPage.getFlashText().toLowerCase().contains("you logged out")
        );

    }

    // @Test
    // public void testLogoIsVisible() {
    //     assertTrue("Brand logo should be displayed", home.isLogoDisplayed());
    // }

    // @Test
    // public void testInitialProductListing() {
    //     int count = home.getProductCount();
    //     assertTrue(
    //         "Home page should list at least 20 products initially",
    //         count >= 20
    //     );
    // }

    // @Test
    // public void testSearchReturnsResults() {
    //     home.openSearch();
    //     home.searchFor("apple");
    //     int count = home.getProductCount();
    //     assertTrue(
    //         "Searching 'apple' should return at least one product",
    //         count > 0
    //     );
    // }

    // @Test
    // public void testSearchNoResults() {
    //     home.openSearch();
    //     home.searchFor("xyz-not-real-123");
    //     int count = home.getProductCount();
    //     assertEquals(
    //         "Gibberish search should return zero products",
    //         0, count
    //     );
    // }

    // @Test
    // public void testCategoryFilter() {
    //     // e.g. filter to 'Beverages'
    //     home.selectCategory("Beverages");
    //     int count = home.getProductCount();
    //     assertTrue(
    //         "Filtering by 'Beverages' should show at least one product",
    //         count > 0
    //     );
    // }

    // @Test
    // public void testBasketStartsEmpty() {
    //     assertEquals(
    //         "Basket should start with zero items",
    //         0, home.getBasketCount()
    //     );
    // }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}