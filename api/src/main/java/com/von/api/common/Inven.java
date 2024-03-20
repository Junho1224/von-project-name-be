package com.von.api.common;

import java.util.ArrayList;

/*
제네릭
 */
public class Inven<T> {

    private ArrayList<T> inventory;

    public Inven(ArrayList<T> inventory) {
        this.inventory = new ArrayList<>();
    }

    public void add(T t) {
        inventory.add(t);

    }

    public T remove(int t) {
        return inventory.remove(t);
    }

    public boolean contains(T t) {
        return inventory.contains(t);
    }


    public T get(int i) {
        return inventory.get(i);
    }

    public void clear() {
        inventory.clear();
    }


}








//    public T content; //타입 파라미터로 T 사용
//
//    public T getContent(T content){
//        return content;
//    }
//
//
//    public void setContent(T content){
//        this.content = content;
//
//    }
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("오늘이 며칠입니까");
//
//        Inven<String> inven = new Inven<>();
//        inven.setContent(sc.next());
//        System.out.println(inven.getContent());
//
//
//
//
//    }
//}
