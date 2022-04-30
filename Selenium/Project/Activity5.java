package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity5 {
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
    public void Activity5Validation() throws InterruptedException {

        WebElement ele = driver.findElement(By.id("menu-item-24"));
        ele.click();
        Thread.sleep(2000);
        String titleAct = driver.getTitle();
        String titleExp = "Jobs – Alchemy Jobs";
        if(titleAct.equals(titleExp)) {
            System.out.println("On correct page");
            Reporter.log("On correct page");
        }
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
