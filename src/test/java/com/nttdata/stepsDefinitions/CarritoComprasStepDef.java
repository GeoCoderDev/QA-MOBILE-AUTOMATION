package com.nttdata.stepsDefinitions;

import com.nttdata.steps.CartSteps;
import com.nttdata.steps.ProductSteps;
import com.nttdata.steps.ProductsGallerySteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CarritoComprasStepDef {

    @Steps
    ProductsGallerySteps productsGallerySteps;
    @Steps
    ProductSteps productSteps;
    @Steps
    CartSteps cartSteps;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicacionDeSauceLabs() {
        productsGallerySteps.productsTitleIsVisible();
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        productsGallerySteps.validarPresenciaProductos();
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(int cantidadProducto, String nombreProducto) {

        productsGallerySteps.tapOnProduct(nombreProducto);
        productSteps.waitProducScreenLoads();
        productSteps.insertRequiredCuantity(cantidadProducto);
        productSteps.clickOnAddToCartButton();



    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        productSteps.goToCart();
        cartSteps.waitCartScreenLoads();
        cartSteps.validateProductIsAdded();
    }
}
