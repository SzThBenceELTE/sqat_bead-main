import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class HerokuDragAndDropTest {
    private RemoteWebDriver driver;
    private HerokuDragAndDropPage page;

    @Before
    public void setUp() throws Exception {
        ChromeOptions opts = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), opts);
        page = new HerokuDragAndDropPage(driver);
    }

    // @Test
    // public void testDragAndDropWithActions() {
    //     String before = page.getColumnAText();
    //     assertEquals("Initial column A should be 'A'", "A", before);  // sanity check :contentReference[oaicite:7]{index=7}

    //     page.dragAndDropWithActions();  // attempt native Actions
    //     String after = page.getColumnAText();
    //     assertEquals("After Actions, column A should be 'B'", "B", after);  // may fail in some browsers :contentReference[oaicite:8]{index=8}
    // }

    @Test
    public void testDragAndDropWithJS() {
        String before = page.getColumnAText();
        assertEquals("Initial column A should be 'A'", "A", before);  // consistency check :contentReference[oaicite:9]{index=9}

        page.dragAndDropWithJS();  // use JS helper
        String after = page.getColumnAText();
        assertEquals("After JS simulation, column A should be 'B'", "B", after);  // reliable in HTML5 :contentReference[oaicite:10]{index=10}
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}