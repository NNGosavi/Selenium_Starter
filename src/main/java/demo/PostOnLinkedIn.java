package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class PostOnLinkedIn {
    ChromeDriver driver;
    public PostOnLinkedIn()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: PostOnLinkedIn");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        try {
//            Enter Url  https://www.linkedin.com/
            driver.get("https://www.linkedin.com/");

//            Locate and enter the Email or Phone into the input area Using Locator "ID" "session_key" | sendKeys("<Enter your Email address>")
            driver.findElement(By.id("session_key")).sendKeys("<Enter your Email address>");

//            Locate an enter the Password into the input area Using Locator "ID" "session_password" | sendKeys("<Enter your Password>")
            driver.findElement(By.id("session_password")).sendKeys("<Enter your Password>");

//            Click on the Sign in button Using Locator "XPath" //button[contains(text(), 'Sign in')]
            driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();

//            Verify if you have logged in to your account
            boolean loggedIn = driver.findElement(By.xpath("//button//*[text()='Me']")).isDisplayed();

            if(loggedIn){
//            Click on the Profile Picture Using Locator "XPATH" (//a[contains(@class,'ember-view')]//img)[1]
                driver.findElement(By.xpath("(//a[contains(@class,'ember-view')]//img)[1]")).click();

//            Locate the Who viewed your profile element Using Locator "XPath" //a//*[contains(text(),' profile views')][1]
                String whoViewedProfile = driver.findElement(By.xpath("//a//*[contains(text(),' profile views')][1]")).getText();
                System.out.println(whoViewedProfile.substring(0, whoViewedProfile.indexOf(" ")));

//            Locate the Who viewed your profile element Using Locator "XPath" //a//*[contains(text(),' post impressions')][1]
                String postImpression = driver.findElement(By.xpath("//a//*[contains(text(),' post impressions')][1]")).getText();
                System.out.println(postImpression.substring(0, postImpression.indexOf(" ")));

//            Open the home page by clicking on the LinkedIn logo in the header  Using Locator "XPath" //header//a[@class='app-aware-link '] | click()
                driver.findElement(By.xpath("//header//a[@class='app-aware-link ']")).click();

//            Click on the start a post button  Using Locator "XPath" //a[@class='ember-view']/following-sibling::button | click()
                driver.findElement(By.xpath("//a[@class='ember-view']/following-sibling::button")).click();

//            Verify that the post is for connections only Using Locator "XPath" //button[@class='share-unified-settings-entry-button']/child::div | click()
                driver.findElement(By.xpath("//button[@class='share-unified-settings-entry-button']/child::div")).click();
                driver.findElement(By.id("CONNECTIONS_ONLY")).click();
                driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]")).click();

//            Click on the text input area Using Locator "XPath" //div[contains(@class, 'editor-container')]//p | click()
                driver.findElement(By.xpath("//div[contains(@class, 'editor-container')]//p")).click();

//            Insert text "This is an automated post Happy Testing" Using Locator "XPath" //div[contains(@class, 'editor-container')]//p | sendKeys("This is an automated post Happy Testing")
                driver.findElement(By.xpath("//div[contains(@class, 'editor-container')]//p")).sendKeys("This is an automated post Happy Testing");

//            Click on the post button Using Locator "XPath" //button/*[text()='Post'] | click()
                driver.findElement(By.xpath("//button/*[text()='Post']")).click();

//            Verify if the Post Successful message is displayed Using Locator "Class" Name artdeco-toast-item__message | isDisplayed()
                boolean postPosted = driver.findElement(By.className("artdeco-toast-item__message")).isDisplayed();
                if(postPosted){
                    System.out.println(postPosted);
                }else{
                    System.out.println(false);
                }

            }
        }catch (Exception e){
            System.out.println("PostOnLinkedIn Test case failed");
        }
    }

}
