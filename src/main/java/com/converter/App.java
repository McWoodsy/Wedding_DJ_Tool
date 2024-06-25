package com.converter;

import com.converter.PageOM.SliderPage;
import com.converter.PageOM.WebPage;
import com.converter.service.ConverterService;
import com.converter.service.SliderServiceImpl;
import com.converter.service.YouTubeServiceImpl;


public class App 
{
    public static void main( String[] args )
    {
        WebPage webPage = new SliderPage();
        
        ConverterService converterService = new YouTubeServiceImpl((SliderPage)webPage);

        //  Open page
        webPage.setup();

        //  Iterate through source and download each song
        converterService.searchAndDownload();

        //  Close webdriver instance
        webPage.teardown();

    }
}
