import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/*  2.	http://demo.nopcommerce.com/, Click on Apparel  click on clothing from left side menu sort by high to low
display 9 per page  click on list(view)  add to comparison custom t-shirt and oversized women t-shirt
click on product comparison from green line link  assert product name - clear compare list
assert message no product for comparison.
 */

public class HomeWork_JUnit2 extends Util {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","src\\Resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        //click on apparel
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']/li[3]/a"));
        //click on clothing from left side menu
        clickOnElement(By.xpath("//ul[@class='sublist']/li[2]/a"));
        //click on sort by
        clickOnElement(By.id("products-orderby"));
        //click on high to low price
        clickOnElement(By.xpath("//select[@id='products-orderby']/option[5]"));
        //click on display
        clickOnElement(By.id("products-pagesize"));
        //click on 9 par page
        clickOnElement(By.xpath("//select[@id='products-pagesize']/option[3]"));
        //click on list(view)
        clickOnElement(By.cssSelector(".product-viewmode>a:nth-child(3)"));

        //click on comparison for Oversized Women T-Shirt Custom T-Shirt
        clickOnElement(By.xpath("//div[@class='item-box'][2]/div/div[2]/div[3]/div/input[2]"));
        //click on green line for close
        clickOnElement(By.cssSelector(".close"));
        //click on comparison for Custom T-Shirt
        clickOnElement(By.xpath("//div[@class='item-box'][3]/div/div[2]/div[3]/div[2]/input[2]"));
        // click on the comparison of the green line to go inside
        clickOnElement(By.cssSelector(".content>a"));

        //assert for product name oversized Tshirt
        String expectedResult="Oversized Women T-Shirt";
        String actualResult = driver.findElement(By.xpath("//tr[@class='product-name']/td[3]/a")).getText();
        Assert.assertEquals(expectedResult,actualResult);

        //assert for product name custom T-shirt
        String exRe = "Custom T-Shirt";
        String acRe = driver.findElement(By.xpath("//tr[@class='product-name']/td[2]/a")).getText();
        Assert.assertEquals(exRe,acRe);

        //// Click on the Clear list of comparison
        clickOnElement(By.cssSelector(".page-body>a"));

        //assert for You have no items to compare
        String expected = "You have no items to compare.";
        String actual = driver.findElement(By.cssSelector(".page-body>div")).getText();
        Assert.assertEquals(expected,actual);

        driver.close();








    }
}
