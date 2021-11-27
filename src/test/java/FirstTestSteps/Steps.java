package FirstTestSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Steps {
    private WebDriver driver;

    @Given("^Open in browser mystore-testlab.coderslab.pl$")
    public void openMainPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl.");
    }

    @When("click on sign in button")
    public void signIn() {
        driver.findElement(By.id("_desktop_user_info")).click();
    }

    @When("^enter (.*) in the email field$")
    public void enterMail(String email) {
        WebElement element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(email);
    }

    @When("^enter (.*) in the password field$")
    public void enterPassword(String password) {
        WebElement element = driver.findElement(By.name("password"));
        element.clear();
        element.sendKeys(password);
    }

    @And("in login site click on sign in button")
    public void logIn() {
        driver.findElement(By.id("submit-login")).click();
    }

    @When("click on button addresses")
    public void clickAddresses() {
        driver.findElement(By.cssSelector("[title*='Addresses']")).click();
    }

    @When("click on button +Create new address")
    public void clickCreateNewAddress() {
        driver.findElement(By.xpath("//span[.='Create new address']")).click();
    }

    @And("^enter in the alias field (.*)$")
    public void aliasField(String alias) {
        WebElement element = driver.findElement(By.name("alias"));
        element.clear();
        element.sendKeys(alias);
    }

    @And("^enter in the address field (.*)$")
    public void addressField(String address) {
        WebElement element = driver.findElement(By.name("address1"));
        element.clear();
        element.sendKeys(address);
    }

    @And("^enter in the zip field (.*)$")
    public void zipField(String zip) {
        WebElement element = driver.findElement(By.name("postcode"));
        element.clear();
        element.sendKeys(zip);
    }

    @And("^enter in the city field (.*)$")
    public void cityField(String city) {
        WebElement element = driver.findElement(By.cssSelector("input[name='city']"));
        element.clear();
        element.sendKeys(city);
    }

    @And("choose country on select list")
    public void selectCountry() {
        Select dropdown = new Select(driver.findElement(By.name("id_country")));
        dropdown.selectByVisibleText("United Kingdom");
    }

    @And("^enter in the phone field (.*)$")
    public void phoneField(String phone) {
        WebElement element = driver.findElement(By.name("phone"));
        element.clear();
        element.sendKeys(phone);
    }

    @And("click on button save")
    public void saveButton() {
        driver.findElement(By.cssSelector("button[class='btn btn-primary float-xs-right']")).click();
    }

    @Then("address successfully added")
    public void checkSuccessfullyAdded() {
        WebElement successMsg = driver.findElement(By.className("alert-success"));
        Assert.assertEquals("Address successfully added!", successMsg.getText());
    }

    @Then("^user check the form (.*), (.*), (.*), (.*) and (.*)$")
    public void checkAddress(String alias, String address, String city, String zip, String phone) {
        String defaultUser = "Jan Nowak";
        String defaultCountry = "United Kingdom";
        String expectedValue = alias + "\n" + defaultUser + "\n" + address + "\n"  + city + "\n" + zip + "\n" + defaultCountry + "\n" + phone;
        String compareValue = driver.findElement(By.className("address-body")).getText();
        Assert.assertEquals(expectedValue, compareValue);
    }

    @Then("delete address")
    public void deleteAddress() {
        driver.findElement(By.xpath("//span[normalize-space()='Delete']")).click();
    }

    @And("address successfully deleted")
    public void checkSuccessfullyDeleted() {
        WebElement successMsg = driver.findElement(By.xpath("//article[@role='alert']"));
        Assert.assertEquals("Address successfully deleted!", successMsg.getText());
    }

    @And("closed browser")
    public void closeBrowser() {
        driver.quit();
    }
}
