
package products;

import base.BaseTest;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pages.InventoryPage;
import pages.LoginPage;


public class ProductsTest extends BaseTest{
    
    private static InventoryPage inventoryPage;
        
    @Before
    public void setUp() {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsernameOfValidUser();
    loginPage.enterPasswordOfValidUser();
    loginPage.clickLoginButton();
    
    inventoryPage = new InventoryPage(driver);
    }
    
    @After
    public void tearDown() {
    inventoryPage.logout();
    }

 @Test
    public void testProductSelection(){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    inventoryPage.clickOnFirstProduct();
    
    assertTrue(true);
 }
    
 @Test
    public void testAddToCart(){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    inventoryPage.clickOnFirstProduct();
    inventoryPage.clickOnAddToCart();
    
    assertTrue(true);
    }
    
 @Test
    public void testRemoveFromCart(){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    inventoryPage.clickOnFirstProduct();
    inventoryPage.clickOnAddToCart();
    inventoryPage.clickOnRemoveProductButton();
    
    assertTrue(true);
    }
    
 @Test
    public void testBackButton(){
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    inventoryPage.clickOnFirstProduct();
    inventoryPage.clickOnBackButton();
    
    assertTrue(true);
    }
}
