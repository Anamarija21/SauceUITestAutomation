
package base;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    
    protected static WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() {
    //Initialize driver
    driver = new ChromeDriver();
    //Maximize browser
    driver.manage().window().maximize();
    //Go to login page
    driver.get("https://www.saucedemo.com/");
    }
    
    @AfterClass
    public static void tearDownClass() throws InterruptedException {
    //Wait
    //Thread.sleep(4000);
    //Close the browser
    driver.quit();
    }


}
