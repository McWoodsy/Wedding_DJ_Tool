package com.converter.repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CsvRepositoryImpl implements ConverterRepository {

    private static String src = "csv/playlist.csv";

    @Override
    public List<String> getTrackList(String src) {

        List<String> trackList = new LinkedList<>();

        try (CSVReader reader = new CSVReader(new FileReader(getSrc()))) {
            String[] line;
            line = reader.readNext();
            while ((line = reader.readNext()) != null) {

                //  Create artistAndTrack string
                String artistAndTrack = line[2] + " " + line[1];
                trackList.add(artistAndTrack);
    };
        }
        catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        };
        return trackList;
    };

    public static String getSrc() {
        return src;
    }

    
}
