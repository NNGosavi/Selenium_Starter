package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AlertPrompt {

    ChromeDriver driver;
    public AlertPrompt()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: AlertPrompt");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        try {
//            Enter URL  https://web-locators-static-site-qa.vercel.app/Alerts
            driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");

//            Click on the Add Remark Button  Using Locator "XPath" //p[text()='Add Remarks'] | click()
            driver.findElement(By.xpath("//p[text()='Add Remarks']")).click();

//            Switch to Alert and Enter text using  driver.switchTo().alert().sendKeys("Automation Rocks")
            driver.switchTo().alert().sendKeys("Automation Rocks");

//            Click on the OK button using  accept()
            driver.switchTo().alert().accept();

//            Verify that the entered text is printed  Using Locator "XPath" //p[@class='Alert_remarkContent'] | assertEquals()
            boolean alertText = driver.findElement(By.xpath("//p[@class='Alert_remarkContent']")).isDisplayed();

            if(alertText){
                System.out.println("Alert Displayed: " + alertText);
            }else{
                System.out.println("Alert Displayed: " + alertText);
            }

        }catch (Exception e){
            System.out.println("AlertPrompt Test case failed");
        }
    }

}
