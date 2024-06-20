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

    By searchButton = By.id("searchButton");


    // CONTRUCTOR
    public SliderPage() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }



    //  Opens slider and clicks away the initial popup
    public void openSlider() {
        getDriver().get(sliderUrl);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(popup));
        getDriver().findElement(popup).click();
    }

    public void closeSlider() {
        getDriver().close();
    }

    public void enterQuery(String songAndTitle) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchbar));
        getDriver().findElement(searchbar).sendKeys(songAndTitle);
    };

    public void hitSearch() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        getDriver().findElement(searchButton).click();
    };

    public void clickDownload() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
        getDriver().findElement(downloadButton).click();
    };

    public void clearSearchBar(String songAndTitle) {
        char[] songAndTitleCharArray = songAndTitle.toCharArray();
        for (char character : songAndTitleCharArray) {
            getDriver().findElement(searchbar).sendKeys(Keys.BACK_SPACE);
        }
    };

        


}

    

