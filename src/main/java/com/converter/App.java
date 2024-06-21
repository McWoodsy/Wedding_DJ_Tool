package com.converter;

import com.converter.service.ConverterService;
import com.converter.service.SliderServiceImpl;
import com.converter.service.YouTubeServiceImpl;


public class App 
{


    public static void main( String[] args )
    {

        ConverterService converterService = new YouTubeServiceImpl();

        //  Open page
        converterService.setup();

        //  Iterate through source and download each song
        converterService.searchAndDownload();

        //  Close webdriver instance
        converterService.teardown();

    }
}
