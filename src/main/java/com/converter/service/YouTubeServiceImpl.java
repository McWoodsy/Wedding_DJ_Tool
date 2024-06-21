package com.converter.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder;
import com.converter.PageOM.SliderPage;
import com.converter.service.utility.JsonUtil;
import java.util.List;

//  This bypasses the repo so need to inject any implementation of one
//  unless we want to save the playlist to be used with other sources (e.g. yt/bandcamp)
public class YouTubeServiceImpl implements ConverterService{

    String url;

    JsonUtil jsonUtil = new JsonUtil();

    private SliderPage sliderPage;

    // Constructor
    public YouTubeServiceImpl() {
        this.sliderPage = new SliderPage();
    }

    public static String getJson(String url) {

        // replace with scanner
        //url = "https://www.youtube.com/watch?v=np0YIaHv6LQ&list=PLxV1NrSzB7e4eRHM9JLcW5sCKCE8iYMSX";

        String[] command = {
            "yt-dlp",
            "--flat-playlist",
            "-J",
            url
        };

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String input = null;
            String processOutput = "";
            while ((input = in.readLine()) != null) {
                processOutput += input;
            }
            return processOutput;
            
        }
        catch (IOException e) {
            System.out.println("\n\nERROR\n\n");
        }
        return "";

    }
    //  Here we use JsonUtil to extract the tracklist
    public List<String> getTrackList() {
        return jsonUtil.getTrackList(getJson("https://www.youtube.com/watch?v=np0YIaHv6LQ&list=PLxV1NrSzB7e4eRHM9JLcW5sCKCE8iYMSX"));
    };

    @Override
    public void searchAndDownload() {
        for (String track : getTrackList()) {
            getSliderPage().enterQuery(track);
            getSliderPage().hitSearch();
            getSliderPage().clickDownload(); // NoSuchElement here or in SliderPage???
            getSliderPage().clearSearchBar(track);
        }
    }

    public SliderPage getSliderPage() {
        return this.sliderPage;
    };

    public void setup() {
        getSliderPage().openSlider();
    };

    public void teardown() {
        getSliderPage().closeSlider();
    };
    

}
