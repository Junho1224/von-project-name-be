package com.von.api.crawler;

import com.von.api.common.AbstractRepository;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CrawlerRepository extends AbstractRepository {
    Map<String,?> map = new HashMap<>();

    @Override
    public Map<String, ?> save(Map<String, ?> paramMap) throws IOException {
        Document doc = Jsoup.connect("https://music.bugs.co.kr/chart").timeout(10 * 1000).get();
        Elements elems = doc.select("table.byChart");
        Iterator<Element> title = elems.select("p.title").iterator();
        Iterator<Element> artist = elems.select("p.artist").iterator();
        Iterator<Element> rank = elems.select("strong").iterator();

        Map<String, Iterator<Element>> localMap = new HashMap<>();
        localMap.put("title",title);
        localMap.put("artist",artist);
        localMap.put("rank",rank);
        map = localMap;
        return map;
    }
}
