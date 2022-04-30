package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity3 {
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
    public void Activity3validation() {

        WebElement ele = driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']"));
        String url = ele.getAttribute("src");
        System.out.println("Header Image " + url);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
