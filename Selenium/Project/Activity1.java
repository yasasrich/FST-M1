package LiveProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    @BeforeTest
    public void loadingBrowser(){
        //Section A
        driver = new FirefoxDriver();

        //Section B
        driver.get("https://alchemy.hguy.co/jobs");
        driver.manage().window().maximize();
    }

    @Test
    public void Activity1validation() {

        String actual = driver.getTitle();
        String expected = "Alchemy Jobs – Job Board Application";
        if(actual.equals(expected)) {
            System.out.println("Title is displayed as expected");
            Reporter.log("Title is displayed as expected");
        }
        else{
            System.out.println("Actual not matched with Expected");
            System.out.println("Actual : " + actual);
            System.out.println("Expected : " + expected);
        }
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
