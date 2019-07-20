package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LandingPage;
import page.UhodPage;



public class FilterTest {
    private WebDriver driver;
    private LandingPage landingPage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://intertop.ua");
        landingPage = new LandingPage(driver);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void verifyFilterByColorTest() {
        Assert.assertTrue(landingPage.isLoaded(), "Landing page is not loaded");
        UhodPage uhodPage = landingPage.clickUhodLink();
        Assert.assertTrue(uhodPage.isLoaded(), "Uhod page is not loaded");
        int expectedItemsCount = uhodPage.getGubkaFilterItemCount();
        uhodPage.clickGubkaFilterItem();
        uhodPage.waitUntilProductCountIs(expectedItemsCount);
        Assert.assertEquals(uhodPage.getProductItemsCount(), expectedItemsCount,
                "Expected and actual number of products do not match.");
    }

}
