package com.von.api.crawling;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CrawlerService {
    Map<String, ?> findNamesBugsMusic(Map<String, String>paraMap) throws IOException;
    Map<String, ?> findNamesMelonMusic(Map<String, String>paraMap) throws IOException;

}
