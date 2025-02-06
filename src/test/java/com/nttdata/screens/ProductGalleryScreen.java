package com.nttdata.screens;

import com.nttdata.steps.CartSteps;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductGalleryScreen extends PageObject {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productsTitle;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc='Displays all products of catalog']/android.view.ViewGroup")
    private List<WebElement> allProducts;


    public ProductGalleryScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }

    public boolean productsTitleIsVIsible() {
        return productsTitle.isDisplayed();
    }

    public List<WebElement> getProductos() {
        return allProducts;
    }


    public void tapProduct(String productName) {
        for(WebElement product : allProducts) {
            String accessibilityId = product.findElement(By.xpath(".//android.widget.ImageView")).getAttribute("content-desc").trim();
            System.out.println("Producto: "+ accessibilityId);
            if(accessibilityId.equals(productName)) {
                product.click();
                //Guardando el nombre del producto encontrado para usarlo mas adelante en comprobar el carrito
                CartSteps.lastProductName = productName;
                return;
            }
        }
        Assert.fail("No se encontró el producto: " + productName);

    }



}