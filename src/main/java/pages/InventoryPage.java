
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

private WebDriver driver;
private By optionsDropdownLocator = By.className("bm-burger-button");
private By logoutButtonLocator =By.xpath("//*[@id=\"logout_sidebar_link\"]");
private final By firstProductLocator = By.linkText("Sauce Labs Backpack");
private final By addProductToCart = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button");
private final By backButton = By.className("inventory_details_back_button");
private final By removeProduct = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button");

public InventoryPage(WebDriver driver){
    this.driver = driver;
} 

private void clickOnOptionsDropdown(){
    driver.findElement(optionsDropdownLocator).click();
}

private void clickOnLogoutButtonFromDropdown(){
    driver.findElement(logoutButtonLocator).click();
}

public void logout(){
   clickOnOptionsDropdown();
   clickOnLogoutButtonFromDropdown();
}
public void clickOnFirstProduct(){
   driver.findElement(firstProductLocator).click();
}

public void clickOnAddToCart(){
   driver.findElement(addProductToCart).click();
}

public void clickOnBackButton(){
   driver.findElement(backButton).click();
}

public void clickOnRemoveProductButton(){
   driver.findElement(removeProduct).click();
}


}

