package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BMSImgUrls {

    ChromeDriver driver;
    public BMSImgUrls()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: BMSImgUrls");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){

        System.out.println("BMSImgUrls testcase started");

        try {
//            Enter URL  https://in.bookmyshow.com/explore/home/chennai
            driver.get("https://in.bookmyshow.com/explore/home/chennai");

//            Find the elements and store them in a ArrayList Using Locator "XPath" //h2[text()='Recommended Movies']/ancestor::div[contains(@class,'commonStyles__HorizontalFlexBox')]/following-sibling::div//img
            List<String> imgURLS = new ArrayList<>();
            imgURLS.addAll(Collections.singleton(driver.findElement(By.xpath("//h2[text()='Recommended Movies']/ancestor::div[contains(@class,'commonStyles__HorizontalFlexBox')]/following-sibling::div//img")).getAttribute("src")));

//            Using the for each loop iterate over the Arraylist and print all the URLs
            for(int i = 0; i < imgURLS.size(); i++){
                System.out.println(imgURLS.get(i));
            }

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[text()='Premieres']"))));
//            Locate the Name of this 2nd element Using Locator "XPath" (//h2[text()='Premieres']/ancestor::div[@class='sc-133848s-3 cZuToi']/following-sibling::div//a[2]//div[contains(@class, 'sc-7o7nez-0')])[1]
            String secMovieName = driver.findElement(By.xpath("(//h2[text()='Premieres']/ancestor::div[@class='sc-133848s-3 cZuToi']/following-sibling::div//a[2]//div[contains(@class, 'sc-7o7nez-0')])[1]")).getText();

//            Print the name  System.out.println(2nd element name)
            System.out.println(secMovieName);

//            Locate the Language of this 2nd element Using Locator "XPath" (//h2[text()='Premieres']/ancestor::div[@class='sc-133848s-3 cZuToi']/following-sibling::div//a[2]//div[contains(@class, 'sc-7o7nez-0')])[2]
            String movieLanguage = driver.findElement(By.xpath("(//h2[text()='Premieres']/ancestor::div[@class='sc-133848s-3 cZuToi']/following-sibling::div//a[2]//div[contains(@class, 'sc-7o7nez-0')])[2]")).getText();

//            Print the language  System.out.println(2nd element language)
            System.out.println(movieLanguage);

        }catch (Exception e){
            System.out.println("BMSImgUrls Test case failed");
        }
    }

}
