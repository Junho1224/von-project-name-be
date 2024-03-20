package com.von.api.crawling;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class CrawlerView {
    public static void main(Scanner sc) throws IOException {

        CrawlerController controller = new CrawlerController();
        while(true){
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-벅스 뮤직\n " +
                    "2-멜론 뮤직\n ");
            switch (sc.next()){
                case "0":
                    System.out.println("종료");return;
                case "1":
                    System.out.println("1-벅스뮤직");
                    Map<String, ?> map = controller.findBugsMusic(sc);
                    Iterator<Element> rank = (Iterator<Element>) map.get("rank");
                    Iterator<Element> artist = (Iterator<Element>) map.get("artist");
                    Iterator<Element> title = (Iterator<Element>) map.get("title");

                    System.out.println(" 벅스뮤직 결과 :: ");

                    while(rank.hasNext()) {
                        System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " +
                                title.next().text());

                    }
                    System.out.println(" ");
                    break;
                case "2":
                    Map<String, ?> map1 = controller.findMelonMusic(sc);
                    Iterator<Element> rank1 = (Iterator<Element>) map1.get("rank");
                    Iterator<Element> artist1 = (Iterator<Element>) map1.get("artist");
                    Iterator<Element> title1 = (Iterator<Element>) map1.get("title");

                    System.out.println(" 멜론뮤직 결과 :: ");

                    while(rank1.hasNext()) {
                        System.out.println(rank1.next().text() + "위 " + artist1.next().text() + " - " +
                                title1.next().text());





                    }
                    System.out.println(" ");
                    break;
                case "3":


            }

        }

    }
}