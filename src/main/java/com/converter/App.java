package com.converter;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {

        // Create driver
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://hayqbhgr.slider.kz/");
        driver.manage().window().maximize();
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fullwrapper\"]/div")));
        popup.click();


        String csvFile = "csv/playlist.csv";

        //  For line in CSV:
        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {

            
            String[] line;
            line = reader.readNext();
            while ((line = reader.readNext()) != null) {

                //  Create artistAndTrack string
                String artistAndTrack = line[2] + " " + line[1];
                System.out.println(artistAndTrack);

                //  Enter search
                WebElement searchbar =wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("buttonQuery")));
                searchbar.sendKeys(artistAndTrack);
                searchbar.sendKeys(Keys.ENTER);
                //  Hit search
                driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();

                //  Wait for a result to appear or if there are no results just continue
                WebElement downloadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"liveaudio\"]/div[2]/div[2]/div[2]/a")));
                downloadButton.click();

                char[] trackNameArray = artistAndTrack.toCharArray();

                for (char character : trackNameArray) {
                    searchbar.sendKeys(Keys.BACK_SPACE);
                }

            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }
}
