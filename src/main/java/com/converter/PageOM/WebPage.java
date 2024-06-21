package com.converter.PageOM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.converter.service.utility.WebUtil;

public abstract class WebPage {

    protected String url;
    protected WebUtil webUtil;

    public WebPage() {
        this.webUtil = new WebUtil();
    }




    
}
