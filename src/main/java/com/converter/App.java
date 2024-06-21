package com.converter;

import com.converter.service.ConverterService;
import com.converter.service.SliderServiceImpl;
import com.converter.service.YouTubeService;


public class App 
{


    public static void main( String[] args )
    {

        YouTubeService youtubeService = new YouTubeService();


        youtubeService.getTrackList();
        // ConverterService converterService = new SliderServiceImpl();

        // //  Open page
        // converterService.setup();

        // //  Iterate through source and download each song
        // converterService.searchAndDownload();

        // //  Close webdriver instance
        // converterService.teardown();

    }
}
