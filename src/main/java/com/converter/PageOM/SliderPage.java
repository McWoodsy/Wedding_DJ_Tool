package com.converter.PageOM;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SliderPage extends WebPage{


    By downloadButton = By.xpath("//*[@id=\"liveaudio\"]/div[2]/div[2]/div[2]/a");

    By searchbar = By.className("buttonQuery");

    //  Check this xpath
    By searchButton = By.id("searchButton");


    // CONTRUCTOR
    public SliderPage() {
        super.url = "https://hayqbhgr.slider.kz/";
        super.popup = By.xpath("//*[@id=\"fullwrapper\"]/div");
        super.driver = super.getDriver();
    }

    public void closeSlider() {
        super.getDriver().close();
    }

    public void enterQuery(String songAndTitle) {
        super.getWait().until(ExpectedConditions.visibilityOfElementLocated(searchbar));
        super.getDriver().findElement(searchbar).sendKeys(songAndTitle);
    };

    public void hitSearch() {
        super.getWait().until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        super.getDriver().findElement(searchButton).click();
    };

    public void clickDownload() {
        try {
            super.getWait().until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
            super.getDriver().findElement(downloadButton).click();
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    };

    public void clearSearchBar(String songAndTitle) {
        char[] songAndTitleCharArray = songAndTitle.toCharArray();
        for (char character : songAndTitleCharArray) {
            super.getDriver().findElement(searchbar).sendKeys(Keys.BACK_SPACE);
        }
    };

    @Override 
    public void setup() {
        super.getDriver().get("https://hayqbhgr.slider.kz/");
        try{
            super.getWait().until(ExpectedConditions.visibilityOfElementLocated(popup));
            super.getDriver().findElement(popup).click();   
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }    };

        public WebDriver getDriver() {
            return super.getDriver();
        }


        


}

    

