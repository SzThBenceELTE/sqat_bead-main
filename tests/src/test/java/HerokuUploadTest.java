import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuUploadTest {
    private RemoteWebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "http://the-internet.herokuapp.com";

    @Before
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

     @Test
    public void testLoginAndFileUpload() throws URISyntaxException {
        // 1. Login
        driver.get(baseUrl + "/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")))
            .sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button.radius")).click();
        assertTrue(
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")))
                .getText().toLowerCase().contains("secure area")
        );

         driver.get(baseUrl + "/upload");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));

        // 1. Locate the generated file on disk
        File uploadFile = new File(
            System.getProperty("user.dir") +
            "/build/generated/upload.txt"
        );
        assertTrue("Upload file must exist", uploadFile.isFile());

        // 2. Enable file transfer to remote Grid
        driver.setFileDetector(new LocalFileDetector());

        // 3. Upload it
        RemoteWebElement input = 
            (RemoteWebElement) driver.findElement(By.id("file-upload"));
        input.sendKeys(uploadFile.getAbsolutePath());
        driver.findElement(By.id("file-submit")).click();

        // 4. Verify success
        WebElement header = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))
        );
        assertEquals("File Uploaded!", header.getText());
        assertEquals(
            uploadFile.getName(),
            driver.findElement(By.id("uploaded-files")).getText()
        );
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}