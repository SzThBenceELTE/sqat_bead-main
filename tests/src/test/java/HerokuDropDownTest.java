import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class HerokuDropDownTest {
    private RemoteWebDriver driver;
    private HerokuDropDownPage dropdownPage;

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(
            new URL("http://selenium:4444/wd/hub"), 
            options
        );
        driver.manage().window().maximize();
        dropdownPage = new HerokuDropDownPage(driver);
    }

    @Test
    public void testDropdownOptions() {
        List<String> expectedTexts  = Arrays.asList(
            "Please select an option",
            "Option 1",
            "Option 2"
        );
        List<String> expectedValues = Arrays.asList(
            "", "1", "2"
        );

        // 1) Verify option texts
        List<String> actualTexts = dropdownPage.getOptionTexts();
        assertEquals(
            "Dropdown should contain exactly the three expected texts",
            expectedTexts, actualTexts
        );

        // 2) Verify option values
        List<String> actualValues = dropdownPage.getOptionValues();
        assertEquals(
            "Dropdown option values should match expected",
            expectedValues, actualValues
        );
    }

    // @Test
    // public void testSelectEachOption() {
    //     for (String optionText : Arrays.asList("Option 1", "Option 2")) {
    //         // Select it
    //         dropdownPage.selectByVisibleText(optionText);

    //         // Assert it's now the selected one
    //         String selected = dropdownPage.getSelectedOptionText();
    //         assertEquals(
    //             "After selecting, the dropdown's selected option should be " + optionText,
    //             optionText, selected
    //         );
    //     }

    //     // Finally, select the placeholder again
    //     dropdownPage.selectByVisibleText("Please select an option");
    //     assertEquals(
    //         "Selecting the placeholder should reset selection",
    //         "Please select an option", 
    //         dropdownPage.getSelectedOptionText()
    //     );
    // }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}