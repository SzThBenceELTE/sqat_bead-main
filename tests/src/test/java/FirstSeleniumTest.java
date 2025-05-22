// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.assertFalse;
// import org.junit.*;
// import org.openqa.selenium.*;
// import org.openqa.selenium.chrome.*;
// import org.openqa.selenium.support.ui.*;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import java.net.URL;
// import java.net.MalformedURLException;

// public class FirstSeleniumTest {

//     private WebDriver driver;
//     private WebDriverWait wait;

//     @Before
//     public void setup() throws MalformedURLException {
//         ChromeOptions options = new ChromeOptions();
//         driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
//         driver.manage().window().maximize();

//         wait = new WebDriverWait(driver, 10);
//     }

//     private final By bodyLocator = By.tagName("body");
//     private final By searchTogglerLocator = By.className("search-bar-toggler");
//     private final By searchLocator = By.xpath("//div[@class='sliding-search-wrapper']/form/input[@name='search']");



//     private WebElement waitVisibiiltyAndFindElement(By locator) {
//         this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//         return this.driver.findElement(locator);
//     }

//     @Test
//     public void testSearchBar() {
//         this.driver.get("https://www.inf.elte.hu/en/");

//         WebElement resultElement = waitVisibiiltyAndFindElement(bodyLocator );
//         System.out.println(resultElement.getText());
//         Assert.assertTrue(resultElement.getText().contains("2025 ELTE Faculty of Informatics"));


//         WebElement searchTogglerElement = waitVisibiiltyAndFindElement(searchTogglerLocator);
//         searchTogglerElement.click();

//         WebElement searchBarElement = waitVisibiiltyAndFindElement(searchLocator);
//         searchBarElement.sendKeys("Student \n");

//         WebElement bodyElement = waitVisibiiltyAndFindElement(bodyLocator);
//         System.out.println(bodyElement.getText());
//         Assert.assertTrue(bodyElement.getText().contains("Student Support Centre"));

//     }

//     @After
//     public void close() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }
