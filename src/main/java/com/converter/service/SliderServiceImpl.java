package com.converter.service;

import java.util.List;

import com.converter.repository.ConverterRepository;

public class SliderServiceImpl implements ConverterService {

    public ConverterRepository converterRepository;

    @Override
    public void pasteAndSearch(String artistAndTrack) {

    };

    @Override
    public List<String> getTrackList(String src) {
        return converterRepository.getTrackList(src);
    };
    
}
