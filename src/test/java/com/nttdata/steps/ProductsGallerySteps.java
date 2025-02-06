package com.nttdata.steps;



import com.nttdata.screens.ProductGalleryScreen;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsGallerySteps {

    private ProductGalleryScreen productGalleryScreen;

    public ProductsGallerySteps() {
        this.productGalleryScreen = new ProductGalleryScreen();
    }

    @Step
    public void productsTitleIsVisible() {
        Assert.assertTrue("El título de productos no está visible", productGalleryScreen.productsTitleIsVIsible()); ;
    }

    public void validarPresenciaProductos(){

        List<WebElement> allProducts =  productGalleryScreen.getProductos();
        System.out.println("El tamaño es: " + allProducts.size());
        Assert.assertFalse("No se encontraron productos en la galería", allProducts.isEmpty());

    }

    public void tapOnProduct(String productName){

        productGalleryScreen.tapProduct(productName);

    }



}