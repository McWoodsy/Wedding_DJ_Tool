package com.converter.service;

import java.util.List;

import com.converter.PageOM.SliderPage;
import com.converter.repository.ConverterRepository;
import com.converter.repository.CsvRepositoryImpl;

public class SliderServiceImpl implements ConverterService {

    private ConverterRepository converterRepository;

    private SliderPage sliderPage;


    // Constructor
    public SliderServiceImpl() {
        //this.sliderPage = new SliderPage();
        this.converterRepository = new CsvRepositoryImpl();
    }


    public SliderPage getSliderPage() {
        return this.sliderPage;
    }


    public ConverterRepository getConverterRepository() {
        return this.converterRepository;
    }

    
    public void setup() {
        getSliderPage().openSlider();
    };

    public void teardown() {
        getSliderPage().closeSlider();
    };

    @Override
    public void searchAndDownload() {
        for (String track : getTrackList()) {
            getSliderPage().enterQuery(track);
            getSliderPage().hitSearch();
            getSliderPage().clickDownload();
            getSliderPage().clearSearchBar(track);
        }
    };

    @Override
    public List<String> getTrackList() {
        return getConverterRepository().getTrackList();
    };
    
}
