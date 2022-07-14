package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
private Scanner sc;
private List<WiseSaying> wiseSayings;
private int idx;
public App(Scanner sc){
    this.sc=sc;
    wiseSayings=new ArrayList<>();
    idx=-1;
}
public void run(){
    System.out.println("== 명언 SSG ==");
    outer:
    while(true){
        System.out.printf("명령) ");
        String cmd=sc.nextLine().trim();
        switch (cmd){
            case "등록":
                System.out.printf("명언 : ");
                String content=sc.nextLine().trim();
                System.out.printf("작가 : ");
                String author=sc.nextLine().trim();
                WiseSaying wiseSaying=new WiseSaying(++idx,content,author);
                wiseSayings.add(wiseSaying);
                break ;
            case "종료":
                break  outer;
        }
    }
}
}
