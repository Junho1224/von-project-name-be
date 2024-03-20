package com.von.api.crawling;

import com.von.api.common.AbstractRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CrawlerRepository extends AbstractRepository {
    private Map<String, ?> map;
    private static CrawlerRepository instans = new CrawlerRepository();
    private CrawlerRepository(){
        map = new HashMap<>();
    }
    public static CrawlerRepository getInstance(){return instans;}
    @Override
    public Map<String, ?> bugsSave(Map<String, ?> paraMap) throws IOException {

        String url = "https://music.bugs.co.kr/chart";
//        String url = (String) paraMap.get("Url");;
        Document doc = Jsoup.connect(url).timeout(10*1000).get();
        Elements elems = doc.select("table.byChart");

        Iterator<Element> title = elems.select("p.title").iterator();

        Iterator<Element> artist = elems.select("p.artist").iterator();

        Iterator<Element> rank = elems.select("strong").iterator();

        //와일드 카드를 바로 담을 수 없기 때문에 다른데에 담았다가 다시 리턴
        Map<String, Iterator<Element>> bugsmap = new HashMap<>();
        bugsmap.put("title", title);
        bugsmap.put("artist", artist);
        bugsmap.put("rank", rank);

        map = bugsmap;
        return map;
        }

    @Override
    public Map<String, ?> melonSave(Map<String, ?> paraMap) throws IOException {

        String url = "https://www.melon.com/chart/index.htm";
//        String melonUrl = (String) paraMap.get("Url");;
        Document doc = Jsoup.connect(url).timeout(10*1000).get();
        Elements elems = doc.select("tbody");

        Iterator<Element> title = elems.select("div.ellipsis.rank01 > span").iterator();

        Iterator<Element> artist = elems.select("div.ellipsis.rank02 span").iterator();

        Iterator<Element> rank = elems.select("td span.rank").iterator();
        Map<String, Iterator<Element>> melonmap = new HashMap<>();
        melonmap.put("title", title);
        melonmap.put("artist", artist);
        melonmap.put("rank", rank);

        map = melonmap;
        return map;
    }
}
