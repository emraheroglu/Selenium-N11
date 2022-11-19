import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class AddBasket {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Logger logger;
    JavascriptExecutor jse;


    public AddBasket(WebDriver webDriver, WebDriverWait webDriverWait, Logger logger) {
        this.webDriver=webDriver;
        this.logger=logger;
        this.webDriverWait=webDriverWait;
        this.jse = (JavascriptExecutor) webDriver;
    }

    //Add to basket
    public void AddToBasket() throws InterruptedException{
        jse.executeScript("window.scrollBy(0,1500)");
        By productDetail = By.className("productName");
        webDriver.findElement(productDetail).click();

        jse.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        By btnAddBasket = By.cssSelector(".btn.btnGrey.btnAddBasket");
        webDriver.findElement(btnAddBasket).click();

        By priceDetail = By.cssSelector(".newPrice ins");
        logger.info("info " + webDriver.findElement(priceDetail).getText());
        String priceValue = webDriver.findElement(priceDetail).getText();
        Thread.sleep(2000);

        webDriver.get("https://www.n11.com/sepetim");
        By priceC = By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[3]/div/div/section/div[5]/span[2]");
        String priceArea = webDriver.findElement(priceC).getText();
        Thread.sleep(2000);

        if (priceValue.equals(priceArea)) {
            logger.info("Product prices are equal.");
            logger.info("Price of the item in the basket: " + priceArea);
            logger.info("Price of the item in the product page: " + priceValue);
        } else {
            logger.info("Product prices are not equal.");
        }
        logger.info("Current Status : Basket Page! Product added to basket.");

    }

    //Increased to 2
    public void IncreaseProduct() throws InterruptedException{
        By confirm = By.xpath("//*[@id=\"userKvkkModal\"]/div/div[2]/span");
        webDriver.findElement(confirm).click();

        jse.executeScript("window.scrollBy(0,120)");

        By spinnerUp = By.xpath("//*[@id=\"newCheckout\"]/div/div[1]/div[2]/div[1]/section/table[2]/tbody/tr/td[3]/div[1]/div/span[1]"); // +
        webDriver.findElement(spinnerUp).click();
        Thread.sleep(2000);

        By totalAmount = By.className("quantity");
        String amount = webDriver.findElement(totalAmount).getAttribute("value");
        String amountC= "2";

        if(amount.equals(amountC)){
            logger.info("The number of products in your basket is same. Total amount: " +amount);
        } else{
            logger.info("The number of products in your basket is different.");
        }
        logger.info("Current Status : Basket Page! Number of products : 2");
        Thread.sleep(2000);


    }
}
