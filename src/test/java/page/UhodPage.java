package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UhodPage {
    protected WebDriver driver;

    @FindBy(xpath = "//div[@class='filter-left']")
    private WebElement leftFilter;

    @FindBy(xpath = "//div[@class='filter-left']//li//span[text() = 'Губка']")
    private WebElement gubkaFilterItem;

    @FindBy(xpath = "//div[@class='filter-left']//li//span[text() = 'Губка']/../span[@class='count']")
    private WebElement gubkaFilterItemCount;

    @FindBy(xpath = "//div[@class='product-thumb']")
    private List<WebElement> productItems;

    public UhodPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilProductCountIs(int expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='product-thumb']"), expectedCount));
    }

    public boolean isLoaded() {
        return leftFilter.isDisplayed()
                && driver.getTitle().equals("Средства по уходу за обувью - купить в Киеве, Украине | интернет-магазин INTERTOP.UA")
                && driver.getCurrentUrl().endsWith("/catalog/sredstva_po_ukhodu/");
    }

    public void clickGubkaFilterItem() {
        gubkaFilterItem.click();
    }

    public int getProductItemsCount() {
        return productItems.size();
    }

    public int getGubkaFilterItemCount() {
        return Integer.parseInt(gubkaFilterItemCount.getText());
    }


}
