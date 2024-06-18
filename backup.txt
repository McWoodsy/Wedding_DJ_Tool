package com.converter.pom;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SliderPage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    private String sliderUrl = "https://hayqbhgr.slider.kz/";

    By downloadButton = By.xpath("//*[@id=\"liveaudio\"]/div[2]/div[2]/div[2]/a");

    By popup = By.xpath("//*[@id=\"fullwrapper\"]/div");

    By searchbar = By.className("buttonQuery");

    //  Check this xpath
    By searchButton = By.id("searchButton");



    // CONTRUCTOR
    public SliderPage() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    

    //  Opens slider and clicks away the initial popup
    public void openSlider() {
        driver.get(sliderUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(popup));
        driver.findElement(popup).click();
    }

    public void closeSlider() {
        driver.close();
    }

    public void enterQuery(String songAndTitle) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchbar));
        driver.findElement(searchbar).sendKeys(songAndTitle);
    };

    public void hitSearch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
    };

    public void clickDownload() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
        driver.findElement(downloadButton).click();
    };

    public void clearSearchBar(String songAndTitle) {
        char[] songAndTitleCharArray = songAndTitle.toCharArray();
        for (char character : songAndTitleCharArray) {
            driver.findElement(searchbar).sendKeys(Keys.BACK_SPACE);
        }
    };

        


}

    

