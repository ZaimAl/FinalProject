package Cucumber.WebUITest;

import Cucumber.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyStepdefs extends BaseTest {

    @Given("user is on home page")
    public void userIsOnHomePage() {
        getDriver();
        setWait();
        driver.get("https://www.demoblaze.com/index.html");
    }

    @And("user choose the item")
    public void userChooseTheItem() {
        List<WebElement> elementMonitor = driver.findElements(By.xpath("//*[@id=\"itemc\"]"));
        elementMonitor.get(2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/a")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @And("user check the item")
    public void userCheckTheItem() {
        driver.findElement(By.id("cartur")).click();
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    }

    @Then("user input the every information that needed")
    public void userInputTheEveryInformationThatNeeded() {
        driver.findElement(By.id("name")).sendKeys("UserTest123");
        driver.findElement(By.id("country")).sendKeys("Indonesia");
        driver.findElement(By.id("city")).sendKeys("jakarta");
        driver.findElement(By.id("card")).sendKeys("123");
        driver.findElement(By.id("month")).sendKeys("11");
        driver.findElement(By.id("year")).sendKeys("2033");
        driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click();
    }

    @And("user get the notify massage {string}")
    public void userGetTheNotifyMassage(String notify) {
        By purchaseTest = By.xpath("/html/body/div[10]/h2");
        WebElement productElement = driver.findElement(purchaseTest);
        assertTrue(driver.findElement(purchaseTest).isDisplayed());
        assertEquals(notify, productElement.getText());
        driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
        driver.close();
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginusername")));
        driver.findElement(By.id("loginusername")).sendKeys(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        driver.findElement(By.id("loginpassword")).sendKeys(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
    }

    @Then("user is on homepage with information {string}")
    public void userIsOnHomepageWithInformation(String welcome) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        By welcomeUser = By.id("nameofuser");
        WebElement productElement = driver.findElement(welcomeUser);
        assertTrue(driver.findElement(welcomeUser).isDisplayed());
        assertEquals(welcome, productElement.getText());
    }

    @And("User try to logout")
    public void userTryToLogout() {
        driver.findElement(By.id("logout2")).click();
        driver.close();
    }

    @And("user choose several item")
    public void userChooseSeveralItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[6]/div/div/h4/a")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
        List<WebElement>  elementMonitor = driver.findElements(By.xpath("//*[@id=\"itemc\"]"));
        elementMonitor.get(1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[5]/div/div/h4/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[5]/div/div/h4/a")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    @When("user click delete button for several item")
    public void userClickDeleteButtonForSeveralItem() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")));
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[1]/td[4]/a")).click();
    }

    @Then("the item from the checkout empty")
    public void theItemFromTheCheckoutEmpty() {
        driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[4]/a")).click();
    }

    @And("user continue shopping in home page")
    public void userContinueShoppingInHomePage() {
        driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[1]/a")).click();
        driver.close();
    }
}
