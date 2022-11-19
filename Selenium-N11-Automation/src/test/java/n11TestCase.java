import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.logging.Logger;

public class n11TestCase {

    public static WebDriver webDriver;
    public static WebDriverWait webDriverWait;
    final static Logger logger = Logger.getLogger(String.valueOf(n11TestCase.class));

    @Before
    public void n11TestAutomation(){
        System.setProperty("webdriver.chrome.driver", "C:/JAVA Kamp/Selenium-N11-Automation/driver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        logger.info("Test started successfully.");
    }

    @Test
    public void n11TestSteps() throws InterruptedException{
        MainPage mainPage = new MainPage(webDriver, webDriverWait, logger);
        mainPage.HomePage();

        MainPage login = new MainPage(webDriver,webDriverWait,logger);
        login.LoginScreen();

        ProductSearchPage productSearchPage = new ProductSearchPage(webDriver, webDriverWait, logger);
        productSearchPage.Search();

        ProductSearchPage secondPage = new ProductSearchPage(webDriver,webDriverWait,logger);
        secondPage.SecondPage();

        AddBasket addBasket = new AddBasket(webDriver,webDriverWait,logger);
        addBasket.AddToBasket();
        addBasket.IncreaseProduct();

        DeleteProduct deleteProduct = new DeleteProduct(webDriverWait,webDriver,logger);
        deleteProduct.DeleteProduct();
        deleteProduct.BasketControl();

    }

    @After
    public void EndTest(){
        webDriver.quit();
        logger.info("Test completed successfully.");
    }

}
