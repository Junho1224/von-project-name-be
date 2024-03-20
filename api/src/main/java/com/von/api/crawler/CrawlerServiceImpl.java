package com.von.api.crawler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CrawlerServiceImpl implements CrawlerService{
   private final CrawlerRepository repository;
    @Override
    public Map<String, ?> findNamesFromWeb(Map<String, String> paramMap) throws IOException {
        return repository.save(paramMap);
    }
}
