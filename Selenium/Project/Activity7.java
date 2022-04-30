package LiveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity7 {
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
    public void Activity7Validation() throws InterruptedException {

        WebElement postJob = driver.findElement(By.id("menu-item-26"));
        postJob.click();
        Thread.sleep(3000);

        fillPostJobDetails();
        fillCompanyDetails();
        //Section D
        WebElement previewBtn = driver.findElement(By.id("job_preview_submit_button"));
        previewBtn.click();
        Thread.sleep(3000);

        WebElement submit = driver.findElement(By.name("submit_job"));
        submit.click();
        Thread.sleep(2000);

        WebElement jobs = driver.findElement(By.id("menu-item-24"));
        jobs.click();

        WebElement jobCheck = driver.findElement(By.xpath("//h3[text()='QA Automation Tester']"));
        if(jobCheck.isDisplayed())
            System.out.println("Test case passed");
        else
            System.out.println("Test case failed");
    }

    private void fillPostJobDetails() throws InterruptedException {
        //Section C
        WebElement email = driver.findElement(By.xpath("//input[@id='create_account_email']"));
        email.sendKeys("aqqqqqwwqwwqq222w2222qywa@gmail.com");

        WebElement jobTitle = driver.findElement(By.xpath("//*[@name='job_title']"));
        jobTitle.sendKeys("QA Automation Tester");

        Select jobType = new Select(driver.findElement(By.id("job_type")));
        jobType.selectByVisibleText("Internship");

        WebElement desc = driver.findElement(By.xpath("//*[@id='job_description_ifr']"));
        desc.sendKeys("This position is for tester");

        WebElement appURL = driver.findElement(By.xpath("//input[@name='application']"));
        appURL.sendKeys("comp2anyw2@gmail.com");
    }

    private void fillCompanyDetails(){
        WebElement compName = driver.findElement(By.xpath("//input[@id='company_name']"));
        compName.sendKeys("IBM");

        WebElement compWebsite = driver.findElement(By.xpath("//input[@name='company_website']"));
        compWebsite.sendKeys("https://ibm/jobs/jobs/");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
