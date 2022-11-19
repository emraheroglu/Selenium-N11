import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Logger;

public class MainPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    Logger logger;
    JavascriptExecutor jse;

    public MainPage(WebDriver webDriver, WebDriverWait webDriverWait, Logger logger) {
        this.logger = logger;
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    //Homepage
    public void HomePage() {
        webDriver.get("https://n11.com");
        logger.info("Current Status : n11.com Home Page");
    }

    //Login steps
    public void LoginScreen() throws InterruptedException {
        webDriver.get("httpps://n11.com/giris-yap");

        By later = By.xpath("//*[@id=\"dengage-push-perm-slide\"]/div/div[2]/div/button[1]");
        webDriver.findElement(later).click();

        By userEmail = By.id("email");
        webDriver.findElement(userEmail).sendKeys("emrherglu_78@hotmail.com");
        Thread.sleep(1000);

        By userPassword = By.id("password");
        webDriver.findElement(userPassword).sendKeys("emrah1907");
        jse.executeScript("window.scrollBy(0,120)");
        Thread.sleep(1000);

        By loginButton = By.id("loginButton");
        Thread.sleep(1000);
        webDriver.findElement(loginButton).click();

        logger.info("Current Status : User logged in.");
    }
}
