package com.example.iintern.configFile;

import com.example.iintern.model.Source;
import com.example.iintern.service.NewsInterface;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@RequiredArgsConstructor
public class NewsTask implements Runnable {
    private final NewsInterface newsInterface;
    private final String filePath;

    @Override
    public void run() {
        try {
            Map<Source, Integer> sourceNewsCount = newsInterface.getNewsCountBySource();

            StringBuilder fileContent = new StringBuilder();
            for (Map.Entry<Source, Integer> entry : sourceNewsCount.entrySet()) {
                Source sourceId = entry.getKey();
                Integer newsCount = entry.getValue();
                fileContent.append(sourceId).append(": ").append(newsCount).append("\n");
                fileContent.append("date time").append("\n");
            }

            File file = new File(filePath);
            FileWriter writer = new FileWriter(file);
            writer.write(fileContent.toString());
            writer.close();

            System.out.println("News count file created successfully at " + filePath);
        } catch (IOException e) {
            System.out.println("Error creating news count file: " + e.getMessage());
        }
    }

}

