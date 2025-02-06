package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;
import java.util.List;

public class CartScreen extends PageObject {

    @AndroidFindBy(accessibility = "Confirms products for checkout")
    private WebElement procedToCheckoutButton;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays list of selected products']/android.view.ViewGroup")
    private List<WebElement> cartProducts;

    public void waitProcedToCheckoutButtonDisplayed(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(procedToCheckoutButton));
    }

    public List<WebElement> getCartProducts() {
        return cartProducts;
    }

    public boolean validateProductInCart(String productNameExpected, int quantityExpected) {
        System.out.println("Buscando producto: " + productNameExpected + " con cantidad: " + quantityExpected);

        for(WebElement product : cartProducts) {
            String name = product.findElement(By.xpath(".//android.widget.TextView[contains(@resource-id,'titleTV')]")).getText();
            int realQuantity = Integer.parseInt(product.findElement(By.xpath(".//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/noTV']")).getText());

            System.out.println("Producto encontrado: " + name + " cantidad: " + realQuantity);

            if(name.equals(productNameExpected) && realQuantity == quantityExpected) {
                return true;
            }
        }
        Assert.fail("No se encontró el producto " + productNameExpected + " con cantidad " + quantityExpected);
        return false;
    }
}