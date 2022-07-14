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
    idx=0;
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
                System.out.printf("%d번 명언이 등록되었습니다.",idx);
                break ;
            case "목록":
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i=wiseSayings.size()-1;i>=0;i--){
                    System.out.printf("%d / %s / %s\n",wiseSayings.get(i).id,wiseSayings.get(i).author,wiseSayings.get(i).content);
                }
                break;
            case "종료":
                break  outer;
        }
    }
}
}
