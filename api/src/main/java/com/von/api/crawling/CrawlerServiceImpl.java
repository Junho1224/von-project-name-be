package com.von.api.crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class CrawlerServiceImpl implements CrawlerService {
    private CrawlerRepository repository;

    private static CrawlerServiceImpl instans = new CrawlerServiceImpl();
    private CrawlerServiceImpl(){
        repository = CrawlerRepository.getInstance();

    }
    public static CrawlerServiceImpl getInstance(){return instans;}

    @Override
    public Map<String, ?> findNamesBugsMusic(Map<String, String> paraMap) throws IOException {
        return repository.bugsSave(paraMap);



    }

    @Override
    public Map<String, ?> findNamesMelonMusic(Map<String, String> paraMap) throws IOException {
        return repository.melonSave(paraMap);
    }




}
