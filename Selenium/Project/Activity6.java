package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity6 {
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
    public void Activity6Validation() throws InterruptedException {

        WebElement ele = driver.findElement(By.id("menu-item-24"));
        ele.click();
        Thread.sleep(2000);

        //Section B
        WebElement input = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        input.sendKeys("Banking");
        WebElement submit = driver.findElement(By.xpath("//*[@class='search_submit']"));
        submit.click();
        Thread.sleep(3000);

        //Section C
        WebElement selectJob = driver.findElement(By.xpath("//li[@class='post-4475 job_listing type-job_listing status-publish hentry job-type-internship']"));
        selectJob.click();
        Thread.sleep(4000);

        //Section D
        WebElement applyJob = driver.findElement(By.className("application_button"));
        //WebElement applyJob = driver.findElement(By.xpath("//input[@class='application_button button']"));
        applyJob.click();
        WebElement email = driver.findElement(By.className("job_application_email"));
        System.out.println(email.getText());

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
