package com.converter.PageOM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class WebPage {

    //  Maybe use a subclass for utilities...

    protected String url;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By popup;     //     For cookies (or other) popups

    public WebPage() {
        this.driver = new ChromeDriver(); // Set up driver manager in this class
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));    }

    public void setup()  {
        getDriver().get("https://hayqbhgr.slider.kz/");
     ;}
    public final void teardown() {
        getDriver().quit(); 
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getWait() {
        return this.wait;
    }
}