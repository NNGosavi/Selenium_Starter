package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IMDBRating {

    ChromeDriver driver;
    public IMDBRating()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: IMDBRating");
        driver.close();
        driver.quit();

    }


    public  void testCase01(){
        try {
//            Enter URL  https://www.imdb.com/chart/top
            driver.get("https://www.imdb.com/chart/top");

//            Click on the Sort by dropdown Using Locator "Tag Name" select
            driver.findElement(By.tagName("select")).click();

//            Select the IMDB rating option Using Locator "XPath" //select//option[text()='IMDb rating'] | click()
            driver.findElement(By.xpath("//select//option[text()='IMDb rating']")).click();

//            Locate the Ratings of the first movie Using Locator "XPath" //select//option[text()='IMDb rating'] | click()
            driver.findElement(By.xpath("//select//option[text()='IMDb rating']")).click();

            System.out.println();
//            Print the rating value text  System.out.println(located rating .getText())
            String ratingValue = driver.findElement(By.xpath("(//li//img)[1]/ancestor::li//h3/ancestor::div[@class='ipc-metadata-list-summary-item__tc']//*[@class='ipc-icon ipc-icon--star-inline']/parent::*")).getText();
            System.out.println(ratingValue.substring(0, ratingValue.indexOf(" ")).trim());

//            To count the included movie in the table create an ArrayList  movieCount
            List<WebElement> movieCount = driver.findElements(By.xpath("//li//img"));
            System.out.println(movieCount.size());

//            To find the oldest movie on the list
//            Click on the Sort by dropdown Using Locator "Tag Name" select
            driver.findElement(By.tagName("select")).click();

//            Select the Release date option Using Locator "XPath" //select//option[text()='Release date'] | click()
            driver.findElement(By.xpath("//select//option[text()='Release date']")).click();

//            Click on the swap-sort button Using Locator "ID" swap-sort-order-button | click()
            driver.findElement(By.id("swap-sort-order-button")).click();

//            Get the name of the oldest movie on the list Using Locator "XPath" (//li//img)[1]/ancestor::li//h3 | getText()
            String oldestMovie = driver.findElement(By.xpath("(//li//img)[1]/ancestor::li//h3")).getText();

//            Print the oldest movie  System.out.println()
            System.out.println(oldestMovie);

//            To get the name of the most recent movie
//            Click on the swap-sort button Using Locator "ID" swap-sort-order-button | click()
            driver.findElement(By.id("swap-sort-order-button")).click();

//            Get the name of the most recent movie on the list Using Locator "XPath" (//li//img)[1]/ancestor::li//h3 | getText()
            String latestMovie = driver.findElement(By.xpath("(//li//img)[1]/ancestor::li//h3")).getText();

//            Print the oldest movie  System.out.println()
            System.out.println(latestMovie);

//            To get the name of the movie that has the highest user ratings
//            Click on the Sort by dropdown Using Locator "Tag Name" select
            driver.findElement(By.tagName("select")).click();

//            Select the Number of ratings option Using Locator "XPath" //select//option[text()='Number of ratings'] | click()
            driver.findElement(By.xpath("//select//option[text()='Number of ratings']")).click();

//            Get the name of the highest rated movie on the list Using Locator "XPath" (//li//img)[1]/ancestor::li//h3 | getText()
            String highestRated = driver.findElement(By.xpath("(//li//img)[1]/ancestor::li//h3")).getText();

//            Print the highest rated movie  System.out.println()
            System.out.println(highestRated);

        }catch (Exception e){
            System.out.println("IMDBRating Test case failed");
        }
    }

}
