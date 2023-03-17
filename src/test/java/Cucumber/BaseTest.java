package Cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.ValidatableResponse;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BaseTest {
    // API
    protected static String apiServer;
    protected static ValidatableResponse response;
    protected static String baseURL="https://dummyapi.io/data/v1/";
    protected static String appToken="64107d98e0e8a162f871809d";
    protected static int page,limit;
    protected static String title,firstName,lastName,gender,tags;


    // Web UI
    protected static WebDriver driver;
    protected  static FluentWait<WebDriver> wait;
    public void getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    public void setWait(){
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(100));
        wait.ignoring(NoSuchElementException.class);
    }
}
