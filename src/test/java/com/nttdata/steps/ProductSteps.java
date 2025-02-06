package com.nttdata.steps;

import com.nttdata.screens.ProductScreen;

public class ProductSteps {

    ProductScreen productScreen;



    public void waitProducScreenLoads() {

        productScreen.waitAddToCartButton();

    }

    public void insertRequiredCuantity(int quantity){

        int difference = quantity - productScreen.getCurrentQuantity();

        if(difference>0){
            productScreen.increaseQuantityIn(difference);
        }else{
            productScreen.descreaseQuantityIn(difference);
        }

        CartSteps.lastProductQuantity = quantity;

    }

    public void clickOnAddToCartButton(){
        productScreen.clickOnAddToCartButton();
    }

    public void goToCart(){
        productScreen.clickOnCartIconButton();
    }

}
