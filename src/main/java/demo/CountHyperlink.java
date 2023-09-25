package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CountHyperlink {
    ChromeDriver driver;
    public CountHyperlink()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: CountHyperlink");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){

        System.out.println("CountHyperlink testcase started");

        try {
//            Enter the url  https://www.bookmyshow.com
            driver.get("https://www.bookmyshow.com");

//            Find the elements and store them in a ArrayList Using Locator "Tag Name" "a" |
            List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));

//            Return the size of the ArrayList
            System.out.println(hyperlinks.size());
        }catch (Exception e){
            System.out.println("Count Hyperlinks on BMS Test case failed");
        }
    }

}
