import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HerokuDragAndDropPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "http://the-internet.herokuapp.com/drag_and_drop";

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public HerokuDragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        driver.get(url);  // load the demo page :contentReference[oaicite:3]{index=3}
        wait.until(ExpectedConditions.visibilityOfElementLocated(columnA));  // ensure it's ready :contentReference[oaicite:4]{index=4}
    }

    /** Returns the visible text of column A (either "A" or "B") */
    public String getColumnAText() {
        return driver.findElement(columnA).getText();
    }

    /** Approach 1: Use Selenium Actions (may be flaky) */
    // public void dragAndDropWithActions() {
    //     WebElement from = driver.findElement(columnA);
    //     WebElement to   = driver.findElement(columnB);
    //     new Actions(driver)
    //         .dragAndDrop(from, to)
    //         .perform();  // perform native DnD :contentReference[oaicite:5]{index=5}
    // }

    /** Approach 2: Inject JS to simulate HTML5 drag-and-drop */
    public void dragAndDropWithJS() {
        // Load helper from a JS file or embed here
        String js = 
          "function simulateDragDrop(source, target) {" +
          "  var dataTransfer = new DataTransfer();" +
          "  ['dragstart','drop','dragend'].forEach(function(eventName){" +
          "    var event = new DragEvent(eventName, { dataTransfer: dataTransfer });" +
          "    source.dispatchEvent(event);" +
          "    if(eventName==='drop') target.dispatchEvent(event);" +
          "  });" +
          "}" +
          "simulateDragDrop(arguments[0], arguments[1]);";
        ((JavascriptExecutor) driver)
          .executeScript(js,
            driver.findElement(columnA),
            driver.findElement(columnB)
          );  // simulate HTML5 DnD :contentReference[oaicite:6]{index=6}
    }
}