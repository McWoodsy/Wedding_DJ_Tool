package com.converter.service.utility;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.converter.PageOM.SliderPage;

public class WebUtil { //   For now only applies to slider.kz

    protected WebDriver driver;
    protected WebDriverWait wait;


    public WebUtil(){
        this.driver = new ChromeDriver(); // Set up driver manager in this class
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    } 

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }
    

}
