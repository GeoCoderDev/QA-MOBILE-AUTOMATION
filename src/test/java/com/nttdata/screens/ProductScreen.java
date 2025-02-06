package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductScreen extends PageObject {

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(accessibility = "Decrease item quantity")
    private WebElement decreaseQuantityButton;
    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.saucelabs.mydemoapp.android:id/noTV\"]")
    private WebElement currentQuantityLabel;

    @AndroidFindBy(accessibility = "Displays number of items in your cart")
    private WebElement cartIconButton;


    public void waitAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
    }


    public int getCurrentQuantity(){
        return Integer.parseInt(currentQuantityLabel.getText());
    }

    public void increaseQuantityIn(int additionalQuantity){

        for (int i=1; i<=additionalQuantity; i++){
            increaseQuantityButton.click();
        };

    }

    public void descreaseQuantityIn(int quantityToRemove){

        for (int i=1; i<=quantityToRemove; i++){
            decreaseQuantityButton.click();
        };

    }

    public void clickOnAddToCartButton(){
        addToCartButton.click();
    }

    public void clickOnCartIconButton(){
        cartIconButton.click();
    }

}