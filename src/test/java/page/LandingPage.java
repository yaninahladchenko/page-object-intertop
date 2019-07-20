package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    protected WebDriver driver;

    @FindBy(xpath = "//a[@href='/detyam/']")
    private WebElement detyamLink;

    @FindBy(xpath = "//ul[contains(@class, 'top-menu-list') and contains(@class, 'active')]//a[text()='Уход']")
    private WebElement uhodLink;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoaded() {
        return uhodLink.isDisplayed()
                && driver.getTitle().equals("INTERTOP.UA: купить обувь в Украине, каталог обуви 2019, распродажи, цены")
                && driver.getCurrentUrl().endsWith("/");
    }

    public UhodPage clickUhodLink() {
        uhodLink.click();
        return new UhodPage(driver);
    }


}
