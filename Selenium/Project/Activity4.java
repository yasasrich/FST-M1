package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity4 {
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
    public void Activity4validation() {

        WebElement ele = driver.findElement(By.xpath("//*[@id='post-16']/div/p/../h2"));
        String actual = ele.getText();
        String expected = "Quia quis non";
        if(actual.equals(expected)){
            System.out.println("Second heading actual matching with expected");
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
