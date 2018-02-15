import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InputFormDemo {

    WebDriver driver;
    WebElement element;
    public String firstName = "John";
    public String lastName = "Doe";
    public String email = "some@mail.com";
    public String phoneNumber = "1234567890";
    public String address = "Boulevard";
    public String city = "Harlan";
    public String zipCode = "12345";
    public String website = "somewebsite.com";
    public String description = "some description";

    public InputFormDemo(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on a Input Form test site")
    public void navigateTo(){
        driver.navigate().to("http://www.seleniumeasy.com/test/input-form-demo.html");
    }

    @When("I insert all values")
    public void inputForm(){
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        driver.findElement(By.name("last_name")).sendKeys(lastName);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys(phoneNumber);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("city")).sendKeys(city);

        Select select = new Select(driver.findElement(By.xpath("//select[@name='state']")));
        select.selectByIndex(3);

        driver.findElement(By.name("zip")).sendKeys(zipCode);
        driver.findElement(By.name("website")).sendKeys(website);
        driver.findElement(By.name("hosting")).click();
        driver.findElement(By.name("comment")).sendKeys(description);

        element = driver.findElement(By.xpath("//button[@type='submit' and @class='btn btn-default']"));
        element.click();

    }

    @Then("I check if Send Button is not disabled")
    public void assertIfTrue(){
        Assert.assertNotEquals(element.getAttribute("disabled"), "disabled");
    }

}
