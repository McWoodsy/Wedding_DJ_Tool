package com.converter;

import com.converter.service.ConverterService;
import com.converter.service.SliderServiceImpl;


public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {

        ConverterService converterService = new SliderServiceImpl();

        //  Open page
        converterService.setup();

        //  Iterate through source and download each song
        converterService.searchAndDownload();

        //  Close webdriver instance
        converterService.teardown();



    }
}
