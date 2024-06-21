package com.converter.PageOM;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.converter.service.utility.WebUtil;


public class SliderPage extends WebPage{


    By downloadButton = By.xpath("//*[@id=\"liveaudio\"]/div[2]/div[2]/div[2]/a");

    By popup = By.xpath("//*[@id=\"fullwrapper\"]/div");

    By searchbar = By.className("buttonQuery");

    //  Check this xpath
    By searchButton = By.id("searchButton");


    // CONTRUCTOR
    public SliderPage() {
        super.url = "https://hayqbhgr.slider.kz/";
    }

    //  Opens slider and clicks away the initial popup
    // public void openSlider() {
    //     super.webUtil.getDriver().get(url);
    //     super.webUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(popup));
    //     super.webUtil.getDriver().findElement(popup).click();
    // }

    public void closeSlider() {
        super.webUtil.getDriver().close();
    }

    public void enterQuery(String songAndTitle) {
        super.webUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(searchbar));
        super.webUtil.getDriver().findElement(searchbar).sendKeys(songAndTitle);
    };

    public void hitSearch() {
        super.webUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        super.webUtil.getDriver().findElement(searchButton).click();
    };

    public void clickDownload() {
        try {
            super.webUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
            super.webUtil.getDriver().findElement(downloadButton).click();
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    };

    public void clearSearchBar(String songAndTitle) {
        char[] songAndTitleCharArray = songAndTitle.toCharArray();
        for (char character : songAndTitleCharArray) {
            super.webUtil.getDriver().findElement(searchbar).sendKeys(Keys.BACK_SPACE);
        }
    };

    @Override 
    public void setup() {
        super.webUtil.getDriver().get("https://hayqbhgr.slider.kz/");
        try{
            super.webUtil.getWait().until(ExpectedConditions.visibilityOfElementLocated(popup));
            super.webUtil.getDriver().findElement(popup).click();   
        }
        catch (NoSuchElementException e) {
            e.printStackTrace();
        }    };



        


}

    

