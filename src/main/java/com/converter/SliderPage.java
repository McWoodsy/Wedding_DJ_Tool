package com.converter;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.converter.service.ConverterService;


public class SliderPage {

    protected WebDriver driver;

    protected WebDriverWait wait;

    private ConverterService converterService;

    

    By downloadButton = By.xpath("//*[@id=\"liveaudio\"]/div[2]/div[2]/div[2]/a");

    By popup = By.xpath("//*[@id=\\\"fullwrapper\\\"]/div");

    By searchbar = By.className("buttonQuery");

    //  Check this xpath
    By searchButton = By.xpath("//*[@id=\"searchButton]");



    public SliderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterQuery(String songAndTitle) {
        //  Not needed? since this is POM is just for executing things, not for logic?
        converterService.getTrackList();
        driver.findElement(searchbar).sendKeys(songAndTitle);
    };

    public void hitSearch() {
        driver.findElement(searchButton).click();
    };

    public void clickDownload() {
        driver.findElement(downloadButton).click();
    };

    public void clearSearchBar(String songAndTitle) {
        char[] songAndTitleCharArray = songAndTitle.toCharArray();
        for (char character : songAndTitleCharArray) {
            driver.findElement(searchbar).sendKeys(Keys.BACK_SPACE);
        }
    };

        


}

    

