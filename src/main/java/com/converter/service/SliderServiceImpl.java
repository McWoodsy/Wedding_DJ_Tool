package com.converter.service;

import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;

import com.converter.SliderPage;
import com.converter.repository.ConverterRepository;
import com.converter.repository.CsvRepositoryImpl;

public class SliderServiceImpl implements ConverterService {

    private ConverterRepository converterRepository = new CsvRepositoryImpl();

    private SliderPage sliderPage = new SliderPage(new ChromeDriver());


    // public SliderServiceImpl(ConverterRepository converterRepository, SliderPage sliderPage) {
    //     this.converterRepository = converterRepository;
    //     this.sliderPage = sliderPage;
    // }


    public void setup() {
        sliderPage.openSlider();
    };

    public void teardown() {
        sliderPage.closeSlider();
    };

    @Override
    public void searchAndDownload() {
        for (String track : getTrackList()) {
            sliderPage.enterQuery(track);
            sliderPage.hitSearch();
            sliderPage.clickDownload();
            sliderPage.clearSearchBar(track);
        }
    };

    @Override
    public List<String> getTrackList() {
        return converterRepository.getTrackList();
    };
    
}
