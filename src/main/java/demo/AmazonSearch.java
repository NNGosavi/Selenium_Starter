package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
///


public class AmazonSearch {
    ChromeDriver driver;
    public AmazonSearch()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: AmazonSearch");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        try {

            System.out.println("Start Test case: AmazonSearch");

//        Enter URL  https://www.google.com
            driver.get("https://www.google.com");

//        Search for text in the search bar Using Locator "ID" APjFqb | sendKeys("amazon")
            driver.findElement(By.id("APjFqb")).sendKeys("amazon");

//        Click on the Google search button Using Locator "Name" btnK | click()
            driver.findElement(By.name("btnK")).click();

//        Search the 'a' tag having value "www.amazon.in" or "www.amazon.com" Using Locator "XPath" //a[contains(@href,'amazon.in') or contains(@href,'amazon.com')]
            boolean tagPresent = driver.findElement(By.tagName("a")).isDisplayed();

//        Return True if desired value is present else false.
            if (tagPresent) {
                System.out.println(tagPresent);
            } else {
                System.out.println(false);
            }

            System.out.println("end Test case: AmazonSearch");
        }catch (Exception e){
            System.out.println("Amazon search Test case failed");
        }
    }

}
