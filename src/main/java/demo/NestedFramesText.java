package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NestedFramesText {
    ChromeDriver driver;
    public NestedFramesText()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: NestedFramesText");
        driver.close();
        driver.quit();
    }


    public  void testCase01(){
        try {
//            Enter Url  https://the-internet.herokuapp.com/nested_frames
            driver.get("https://the-internet.herokuapp.com/nested_frames");

//            Switch to Top frame Using Locator "Name"
            driver.switchTo().frame("frame-top");

//            Switch to Left frame Using Locator "Name"
            driver.switchTo().frame("frame-left");

//            Locate the text 'LEFT' Using Locator "Tag Name" body | getText()
            String left = driver.findElement(By.tagName("body")).getText();

//            Print the left text  System.out.println(left)
            System.out.println(left);

//            Switch to parent frame TOP  driver.switchTo().parentFrame()
            driver.switchTo().parentFrame();

//            Switch to Middle frame Using Locator "Name"
            driver.switchTo().frame("frame-middle");

//            Locate the text 'MIDDLE' Using Locator "ID" content
            String middle = driver.findElement(By.id("content")).getText();

//            Print the middle text  System.out.println(middle)
            System.out.println(middle);

//            Switch to parent frame TOP  driver.switchTo().parentFrame()
            driver.switchTo().parentFrame();

//            Switch to Right frame Using Locator "Name"
            driver.switchTo().frame("frame-right");

//            Locate the text 'RIGHT' Using Locator "Tag Name" body
            String right = driver.findElement(By.tagName("body")).getText();

//            Print the right text  System.out.println(right)
            System.out.println(right);

//            Switch to Default Content  driver.switchTo().defaultContent()
            driver.switchTo().defaultContent();

//            Switch to Bottom frame Using Locator "Name"
            driver.switchTo().frame("frame-bottom");

//            Locate the text 'Bottom' Using Locator "Tag Name" body
            String bottom = driver.findElement(By.tagName("body")).getText();

//            Print the bottom text  System.out.println(bottom)
            System.out.println(bottom);

//            Switch to Default Content  driver.switchTo().defaultContent()
            driver.switchTo().defaultContent();

        }catch (Exception e){
            System.out.println("NestedFramesText Test case failed");
        }
    }

}
