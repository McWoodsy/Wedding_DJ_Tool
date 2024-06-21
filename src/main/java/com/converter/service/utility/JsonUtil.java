package com.converter.service.utility;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil{

    public ObjectMapper objectMapper = getDefaultObjectMapper();

    private ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        return defaultObjectMapper;
    }

    public Object parse(String src) {
    try{
        return objectMapper.readTree(src);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
        return "";
    }
}

    public List<String> getTrackList(String src) {
        List<String> tracklist = new ArrayList<>();
        String subJson = (String)src;
        JsonNode srcJson = (JsonNode)parse(subJson);
        JsonNode entriesJson = srcJson.get("entries");
        for (JsonNode entry : entriesJson) {
            String videoTitle = entry.get("title").asText();
            if (videoTitle.equals("[Deleted video]")) {continue;}
            else {tracklist.add(videoTitle);}
        }
        //  delete
        for (String track : tracklist) {
            System.out.println(track);
        }
        return tracklist;
    };
}
