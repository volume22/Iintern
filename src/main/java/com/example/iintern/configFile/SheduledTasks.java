package com.example.iintern.configFile;

import com.example.iintern.repository.NewsRepository;
import com.example.iintern.service.NewsInterface;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SheduledTasks {
    private final NewsInterface newsInterface;
    private final String filePath;

    public SheduledTasks(NewsInterface newsInterface) {
        this.newsInterface = newsInterface;
        this.filePath = "C:\\test\\news_count.txt";
    }

    @Scheduled(cron = "0 * * * * *")
    public void createNewsCountFile() {
        Thread thread;
        thread = new Thread(new NewsTask(newsInterface, filePath));
        thread.start();
    }
}
