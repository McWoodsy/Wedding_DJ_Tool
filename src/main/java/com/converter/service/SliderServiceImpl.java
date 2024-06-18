package com.converter.service;

import java.util.List;

import com.converter.SliderPage;
import com.converter.repository.ConverterRepository;

public class SliderServiceImpl implements ConverterService {

    private ConverterRepository converterRepository;

    private SliderPage sliderPage;

    @Override
    public void pasteAndSearch() {
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
