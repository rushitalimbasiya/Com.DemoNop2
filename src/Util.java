import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Util {

    protected static WebDriver driver;
    public static void main(String[] args) {
        // WebDriver driver;
        System.setProperty("Webdriver.chrome.driver","src\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void clickOnElement (By by){
        driver.findElement(by).click();        // for click method
    }

    public static void clearOnElement(By by){
        driver.findElement(by).clear();        // for clear method
    }

    public static void byValue(WebElement element, String value){//for selectByValue
        Select sc = new  Select(element);                        //TextFromDropdown
        sc.selectByValue(value);
    }
    public static void byIndex(WebElement element,int index){//for selectByIndex
        Select sc = new Select(element);                    //TextFromDropdown
        sc.selectByIndex(index);
    }
    public static void byVisibleText(WebElement element,String visibleText ) { //for selectByVisibleText
        Select sc = new Select(element);                                       //TextFromDropdown
        sc.selectByVisibleText(visibleText);
    }
    public static void sendKey(By by,String sendkey) {
        driver.findElement(by).sendKeys(sendkey);

    }
    public static String getText(By by) {
        return driver.findElement(by).getText();


}}
