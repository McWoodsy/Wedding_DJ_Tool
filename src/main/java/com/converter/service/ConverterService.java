package com.converter.service;

import java.util.List;

public interface ConverterService {

    public void setup();
    public List<String> getTrackList();
    public void searchAndDownload();
    public void teardown();
    
}
