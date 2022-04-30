package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
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
    public void Activity2Validation() {

        WebElement ele = driver.findElement(By.xpath("//h1[@class='entry-title']"));
        String actual = ele.getText();
        String expected = "Welcome to Alchemy Jobs";
        if(actual.equals(expected)){
            System.out.println("Actual heading matched with expected");
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
