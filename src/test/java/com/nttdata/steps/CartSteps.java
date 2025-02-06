package com.nttdata.steps;

import com.nttdata.screens.CartScreen;
import org.junit.Assert;

public class CartSteps {


    public static String lastProductName;
    public static int lastProductQuantity;

    CartScreen cartScreen;

    public void waitCartScreenLoads(){
        cartScreen.waitProcedToCheckoutButtonDisplayed();
    }


    public void validateProductIsAdded() {

        Assert.assertTrue( cartScreen.validateProductInCart (CartSteps.lastProductName,CartSteps.lastProductQuantity));

    }

}

