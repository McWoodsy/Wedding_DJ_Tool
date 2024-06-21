package com.converter.service.utility;

import java.util.List;

public interface Formatter {
    
    Object parse(String src);
    List<String> getTrackList(Object src);

}
