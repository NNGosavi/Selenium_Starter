package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NameGoogleSearch {

    ChromeDriver driver;
    public NameGoogleSearch()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        try {

            System.out.println("Start Test case: NameGoogleSearch");

//        Enter URL  https://www.google.com
            driver.get("https://www.google.com");

//        Search for text in the search bar Using Locator "ID" APjFqb | sendKeys("Nishant")
            driver.findElement(By.id("APjFqb")).sendKeys("Nishant");

//        Click on the Google search button Using Locator "Name" btnK | click()
            driver.findElement(By.name("btnK")).click();

//        Find the link that contain 'nishant' in it and store them in a ArrayList Using Locator "XPath" //a[contains(@href, 'nishant')]
            List<WebElement> nameLinks = driver.findElements(By.xpath("//a[contains(@href, 'nishant')]"));

//        Return the size of the ArrayList using  size()
            System.out.println(nameLinks.size());

            System.out.println("end Test case: NameGoogleSearch");
        }catch (Exception e){
            System.out.println("NameGoogleSearch Test case failed");
        }
    }

}
