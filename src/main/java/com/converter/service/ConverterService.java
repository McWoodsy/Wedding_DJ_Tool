package com.converter.service;

import java.util.List;

public interface ConverterService {

    //  These should go elsewhere
    public void setup();
    public void teardown();

    public List<String> getTrackList();
    public void searchAndDownload();
    
}
