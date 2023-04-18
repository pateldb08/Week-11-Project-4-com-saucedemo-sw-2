package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //    @After
//    public void tearDown(){
//        closeBrowser();
//   }
    @Test
    public void varifyuserSholdLoginSuccessfullyWithValidCredentials() {
        //Find Username Field and type the username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //Find Password Field and type the password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        // Find Login button field and click on it
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
        //Verify the text 'Products'
        String expectedMessage = "Products";
        WebElement actualTextMessage = driver.findElement(By.className("title"));
        String actualMessage = actualTextMessage.getText();
        Assert.assertEquals("Login Failed", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Find Username Field and type the username
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //Find Password Field and type the password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        // Find Login button field and click on it
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
        //verify that six products are displayed on page
        int expectedProducts = 6;
        //Find multiple elements( 6 elements in this case) and stored in List
        List<WebElement> products = driver.findElements(By.xpath("//button[@class = 'btn btn_primary btn_small btn_inventory']"));
        int actualProducts = products.size();
        Assert.assertEquals("Six products are not displayed" ,expectedProducts,actualProducts);  // validating expected meets actual number of products

    }
}




