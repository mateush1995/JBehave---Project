import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableFilterDemo {

    WebDriver driver;

    public TableFilterDemo(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on Table Filter test site")
    public void navigateTo(){
        driver.navigate().to("http://www.seleniumeasy.com/test/table-records-filter-demo.html");
    }

    @When("I select green elements")
    public void greenElements() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-target='pagado']")).click();
        Thread.sleep(500);
    }

    @When("I select orange elements")
    public void orangeElements() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-target='pendiente']")).click();
        Thread.sleep(500);
    }

    @When("I select red elements")
    public void redElements() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-target='cancelado']")).click();
        Thread.sleep(500);
    }

    @Then("I check if only red elements are selected")
    public void assertion(){
        Assert.assertTrue(!driver.getPageSource().contains("tr data-status='pagado' style='display: none;'") && !driver.getPageSource().contains("tr data-status='pendiente' style='display: none;'"));
    }
}
