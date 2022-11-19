import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class DeleteProduct {

    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Logger logger;

    public DeleteProduct(WebDriverWait webDriverWait, WebDriver webDriver, Logger logger) {
        this.webDriver=webDriver;
        this.webDriverWait=webDriverWait;
        this.logger=logger;
    }

    //Product deleted
    public void DeleteProduct() throws InterruptedException {
        By removeProduct = By.cssSelector(".removeProd.svgIcon.svgIcon_trash");
        webDriver.findElement(removeProduct).click();
        Thread.sleep(2000);
        logger.info("Current Status : Product deleted.");
    }


    public void BasketControl() throws InterruptedException{
        String basket = "Sepetiniz Boş";
        By basketControl = By.xpath("//*[@id=\"wrapper\"]/div[3]/div/div[1]/div[1]/h2");
        String basketText = webDriver.findElement(basketControl).getText();
        Thread.sleep(2000);

        if (basket.equals(basketText)) {
            logger.info("There are no products in your basket.");
        } else {
            logger.info("There are products in your basket.");
        }
        logger.info("Current Status: Basket is empty.");
    }
}
