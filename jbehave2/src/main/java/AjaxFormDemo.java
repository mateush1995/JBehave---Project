import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AjaxFormDemo {

    WebDriver driver;

    public AjaxFormDemo(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on a Ajax Form test site")
    public void navigateTo(){
        driver.navigate().to("http://www.seleniumeasy.com/test/ajax-form-submit-demo.html");
    }

    @When("I type $name into the Name form and $comment into the Comment form")
    public void ajaxForm(@Named("name") String name, @Named("comment") String comment) throws InterruptedException {
        driver.findElement(By.name("title")).sendKeys(name);
        driver.findElement(By.name("description")).sendKeys(comment);
        driver.findElement(By.id("btn-submit")).click();

        Thread.sleep(2000);
    }

    @Then("I check if the form was submitted succesfully")
    public void assertion(){
        Assert.assertTrue(driver.getPageSource().contains("Form submited Successfully!"));
    }


}
