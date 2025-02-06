package com.nttdata.hooks;

import io.cucumber.java.Before;
import net.thucydides.core.webdriver.WebDriverFacade;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

public class AppiumHooks {

    private AndroidDriver getAndroidDriver() {
        return (AndroidDriver) ((WebDriverFacade) ThucydidesWebDriverSupport.getDriver()).getProxiedDriver();
    }

    @Before
    public void beforeScenario() {
        try {
            AndroidDriver androidDriver = getAndroidDriver();
            androidDriver.terminateApp("com.saucelabs.mydemoapp.android");
            Thread.sleep(2000); // Espera 2 segundos antes de iniciar
            androidDriver.activateApp("com.saucelabs.mydemoapp.android");
        } catch (Exception e) {
            StepEventBus.getEventBus().testFailed(new RuntimeException("Error al iniciar la aplicación: " + e.getMessage()));
        }
    }


}