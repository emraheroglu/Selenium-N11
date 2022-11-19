import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class ProductSearchPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Logger logger;
    JavascriptExecutor jse;

    public ProductSearchPage(WebDriver webDriver, WebDriverWait webDriverWait, Logger logger) {
        this.logger = logger;
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
        this.jse = (JavascriptExecutor) webDriver;
    }

    //Product Search
    public void Search() {
        webDriver.get("https://www.n11.com");
        By searchData = By.id("searchData");
        webDriver.findElement(searchData).sendKeys("bilgisayar");

        By searchBtn = By.className("searchBtn");
        webDriver.findElement(searchBtn).click();
        logger.info("Current Status : Product Search" );
    }

    //Go to second page
    public void SecondPage() throws InterruptedException{
        jse.executeScript("window.scrollBy(0,6000)");
        String baseURL = "https://www.n11.com/";
        webDriver.get(baseURL +"arama?q=bilgisayar&pg=2");
        Thread.sleep(1000);

        String secondPageURL= "https://www.n11.com/arama?q=bilgisayar&pg=2";
        String secondPageC =webDriver.getCurrentUrl();

        if(secondPageC.equals(secondPageURL)){
            logger.info("Current Status: Second Page");
        }else{
            logger.info("Current Status: Second Page is not work.");
        }


    }
}
