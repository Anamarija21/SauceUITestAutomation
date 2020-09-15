
package login;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import base.BaseTest;
import static com.google.common.base.Predicates.or;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import pages.InventoryPage;

public class LoginTests extends BaseTest {
 
@Test
public void testValidLogin(){

    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsernameOfValidUser();
    loginPage.enterPasswordOfValidUser();
    loginPage.clickLoginButton();

    String expectedUrl = "https://www.saucedemo.com/inventory.html";
    String actualUrl =  driver.getCurrentUrl();      
    assertEquals("Failed- Urls don't match", expectedUrl, actualUrl);

    InventoryPage inventoryPage = new InventoryPage(driver);
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    inventoryPage.logout();
}

@Test
public void testEmptyFieldsLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.clickLoginButton();

    String expectedUrl = "https://www.saucedemo.com/index.html";
    String actualUrl =  driver.getCurrentUrl();      
    assertEquals("Failed- Urls don't match", expectedUrl, actualUrl);
    
    String expectedUsernameMessage = "Epic sadface: Username and password do not match any user in this service";
    String actualUsernameMessage = loginPage.getUsernameMessageText();
    Assert.assertTrue("Username message's don't match-Failed", expectedUsernameMessage.equals(actualUsernameMessage));
}

@Test
public void testInvalidUsernameInvalidPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsernameOfNonExistingUser();
    loginPage.enterPasswordOfNonExistingUser();
    loginPage.clickLoginButton();

    String expectedUrl = "https://www.saucedemo.com/index.html";
    String actualUrl =  driver.getCurrentUrl();      
    assertEquals("Failed- Urls don't match", expectedUrl, actualUrl);
    
    String expectedUsernameMessage = "Epic sadface: Username and password do not match any user in this service";
    String actualUsernameMessage = loginPage.getUsernameMessageText();
    Assert.assertTrue("Username message's don't match-Failed", expectedUsernameMessage.equals(actualUsernameMessage));    
}

@Test
public void testValidUsernameInvalidPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsernameOfValidUser();
    loginPage.enterPasswordOfNonExistingUser();
    loginPage.clickLoginButton();
    
    String expectedUrl = "https://www.saucedemo.com/index.html";
    String actualUrl =  driver.getCurrentUrl();      
    assertEquals("Failed- Urls don't match", expectedUrl, actualUrl);
    
    String expectedUsernameMessage = "Epic sadface: Username and password do not match any user in this service";
    String actualUsernameMessage = loginPage.getUsernameMessageText();
    Assert.assertTrue("Username message's don't match-Failed", expectedUsernameMessage.equals(actualUsernameMessage));
}

@Test
public void testInvalidUsernameValidPasswordLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsernameOfNonExistingUser();
    loginPage.enterPasswordOfValidUser();
    loginPage.clickLoginButton();
  
    String expectedUrl = "https://www.saucedemo.com/index.html";
    String actualUrl =  driver.getCurrentUrl();      
    assertEquals("Failed- Urls don't match", expectedUrl, actualUrl);
    
    String expectedUsernameMessage = "Epic sadface: Username and password do not match any user in this service";
    String actualUsernameMessage = loginPage.getUsernameMessageText();
    Assert.assertTrue("Username message's don't match-Failed", expectedUsernameMessage.equals(actualUsernameMessage));  
}

@Test
public void testValidUsernameEmptyPassword(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.enterUsernameOfValidUser();
    loginPage.clickLoginButton();
    
    String expectedPasswordMessage = "Epic sadface: Password is required";
    String actualPasswordMessage = loginPage.getPasswordMessageText();
    
    Assert.assertTrue("Password message's don't match-Failed", expectedPasswordMessage.equals(actualPasswordMessage));
}



}
