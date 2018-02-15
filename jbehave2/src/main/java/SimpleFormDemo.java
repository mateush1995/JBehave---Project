import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemo {
    WebDriver driver;
    WebElement element;

    public SimpleFormDemo(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on a Simple Form test site")
    public void navigateTo(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-first-form-demo.html");

    }

    @When("I type $value into form box and click the button")
    public void enterMessage(@Named("value") String text) throws InterruptedException {
        element = driver.findElement(By.xpath("//input[@id='user-message']"));
        element.sendKeys(text);

        element = driver.findElement(By.xpath("//button[@onclick='showInput();']"));
        element.click();
        Thread.sleep(1000);
    }

    @When("I type $firstNumber and $secondNumber numbers and sum them up")
    public void twoInput(@Named("firstNumber") String first, @Named("secondNumber") String second) throws InterruptedException {
        element = driver.findElement(By.xpath("//input[@id='sum1']"));
        element.sendKeys(first);

        element = driver.findElement(By.xpath("//input[@id='sum2']"));
        element.sendKeys(second);

        element = driver.findElement(By.xpath("//button[@onclick='return total()']"));
        element.click();
        Thread.sleep(1000);
    }

    @Then("I assert whether I am getting $test message and sum of $sum")
    public void assertifTrue(@Named("test") String test, @Named("sum") String sum){
        Assert.assertTrue(driver.getPageSource().contains(test));
        Assert.assertTrue(driver.getPageSource().contains(sum));
    }
}
