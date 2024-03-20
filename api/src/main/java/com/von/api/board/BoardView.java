package com.von.api.board;

import com.von.api.common.UtilService;
import com.von.api.common.UtilServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class BoardView {
    public static void main() {
        List<Board> articles = new ArrayList<>();  //
        UtilService util = UtilServiceImpl.getInstance();

        for (int i=0; i<5; i++){
            articles.add(Board.builder()
                    .title(util.createRandomTitle())
                    .content(util.createRandomContent())
                    .writer(util.createRandomName())
                    .build());

        }
        System.out.println(articles);



        int size = articles.size(); //크기
        Board board = articles.get(2); //특정 인덱스 객체 가져오기



//        for(BoardDTO b:articles){
//            System.out.println(b.getTitle()+"\t"+
//                    b.getContent() +"\t"+
//                    b.getWriter());
//        }
        /*
        \n: 줄바꿈
        \t: 탭
         */
//        for(BoardDTO b:articles){
//            System.out.println(b.toString());
//        }
//
//        articles.forEach(i->{
//            System.out.println(i.toString());
//        });








    }
}
