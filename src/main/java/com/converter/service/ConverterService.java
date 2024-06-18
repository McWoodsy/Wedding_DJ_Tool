package com.converter.service;

import java.util.List;

public interface ConverterService {
    
    public void pasteAndSearch(String artistAndTrack);

    public List<String> getTrackList(String srcFilePath);

}
