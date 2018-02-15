import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;


public class MainStories extends JUnitStories{

    public MainStories(){
        super();
    }

    @Override
    public Configuration configuration(){
        return new MostUsefulConfiguration();
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        System.setProperty("webdriver.chrome.driver", "F:/Selenium/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        return new InstanceStepsFactory(configuration(),
                new SimpleFormDemo(driver),
                new RadioButtonDemo(driver),
                new InputFormDemo(driver),
                new AjaxFormDemo(driver),
                new TableFilterDemo(driver));
    }

    @Override
    protected List<String> storyPaths(){
        return Arrays.asList("Stories/SimpleFormStory.story", "Stories/RadioButtonStory.story", "Stories/InputFormStory.story", "Stories/AjaxFormStory.story", "Stories/TableFilterStory.story");
    }
}
