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
        driver.get(url);  
        wait.until(ExpectedConditions.visibilityOfElementLocated(columnA));  
    }

    public String getColumnAText() {
        return driver.findElement(columnA).getText();
    }


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
          );  
    }
}