import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonDemo {
    WebDriver driver;
    WebElement element;

    public RadioButtonDemo(WebDriver driver){
        this.driver = driver;
    }

    @Given("user is on a Radio Button test site")
    public void navigateTo(){
        driver.navigate().to("http://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
    }

    @When("I click on a Radio Button")
    public void singleRadionButton(){
        element = driver.findElement(By.xpath("//input[@name='optradio' and @value='Male']"));
        element.click();
        element = driver.findElement(By.xpath("//button[@id='buttoncheck']"));
        element.click();
    }

    @When("I click on a Group Radio Button")
    public void groupRadioButton(){
        element = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
        element.click();
        element = driver.findElement(By.xpath("//input[@value='15 - 50' and @name='ageGroup']"));
        element.click();
        element = driver.findElement(By.xpath("//button[@onclick='getValues();']"));
        element.click();
    }

    @Then("I make sure radio buttons are correctly checked")
    public void assertIfTrue(){
        Assert.assertTrue(driver.getPageSource().contains("Radio button 'Male' is checked"));
        Assert.assertTrue(driver.getPageSource().contains(""));

        Assert.assertTrue(driver.getPageSource().contains("Sex : Female"));
        Assert.assertTrue(driver.getPageSource().contains("Age group: 15 - 50"));
    }
}
