package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

public class WindowHandle {

    ChromeDriver driver;
    public WindowHandle()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: WindowHandle");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        try {
//            Enter URL  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
            driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

//            Switch to result frame using driver.switchTo().frame(iframeResult)
            driver.switchTo().frame("iframeResult");

//            Click on the Try it buttons Using Locator "XPath" //button[text()='Try it'] | click()
            driver.findElement(By.tagName("button")).click();

//            Store the parent window Handle as string in variable parent  getWindowHandle()
            String parent = driver.getWindowHandle();

//            Store the child window Handle as string in variable child  getWindowHandles()
            Set<String> windows = driver.getWindowHandles();
            Iterator<String> itr = windows.iterator();

            while (itr.hasNext()){
                String window = itr.next();
//            Switch to the child window that opened on clicking the Try it button  driver.switchTo().window(child)
                driver.switchTo().window(window);
                if(driver.getTitle().equals("W3Schools Online Web Tutorials")){

//            Print the title of the child window  getTitle()
                    String childTitle = driver.getTitle();
                    System.out.println(childTitle);

//            Print the URL of the child window  getCurrentUrl()
                    String childURL = driver.getCurrentUrl();
                    System.out.println(childURL);

//            To take the ScreenShot of the webpage
//            Create a File class object and use the getScreenShotAs method  getScreenShotAs()
                    TakesScreenshot ts = (TakesScreenshot) driver;
                    File file = ts.getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(file, new File("./ScreenShots/image1.png"));

//            Close the Child window  driver.close()
                    driver.close();
                }
            }
//            Switch to the original window  driver.switchTo().window(parent)
            driver.switchTo().window(parent);

        }catch (Exception e){
            System.out.println("WindowHandle Test case failed");
        }
    }

}
