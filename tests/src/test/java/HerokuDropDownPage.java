import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class HerokuDropDownPage extends PageBase {
    private static final String URL = "https://the-internet.herokuapp.com/dropdown";

    private By dropdownBy = By.id("dropdown");

    public HerokuDropDownPage(WebDriver driver) {
        super(driver);
        driver.get(URL);
        // Wait until the <select> is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownBy));
    }

    public List<String> getOptionTexts() {
        Select select = new Select(waitAndReturnElement(dropdownBy));
        return select.getOptions()
                     .stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    public List<String> getOptionValues() {
        Select select = new Select(waitAndReturnElement(dropdownBy));
        return select.getOptions()
                     .stream()
                     .map(opt -> opt.getAttribute("value"))
                     .collect(Collectors.toList());
    }

    public void selectByVisibleText(String text) {
        Select select = new Select(waitAndReturnElement(dropdownBy));
        select.selectByVisibleText(text);

        
        ExpectedCondition<Boolean> optionSelected = driver ->
            select.getAllSelectedOptions()
                .stream()
                .anyMatch(opt -> opt.getText().equals(text));

        wait.until(optionSelected);
    }

    
    public String getSelectedOptionText() {
        Select select = new Select(waitAndReturnElement(dropdownBy));
        return select.getFirstSelectedOption().getText();
    }
}