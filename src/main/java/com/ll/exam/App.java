package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
private Scanner sc;
private List<WiseSaying> wiseSayings;
private int lastIdx;
public App(Scanner sc){
    this.sc=sc;
    wiseSayings=new ArrayList<>();
    lastIdx=0;
}
public void run(){
    System.out.println("== 명언 SSG ==");
    outer:
    while(true){
        System.out.printf("명령) ");
        String cmd=sc.nextLine().trim();
        Rq rq=new Rq(cmd);
        switch (rq.getPath()){
            case "등록":
                System.out.printf("명언 : ");
                String content=sc.nextLine().trim();
                System.out.printf("작가 : ");
                String author=sc.nextLine().trim();
                WiseSaying wiseSaying=new WiseSaying(++lastIdx,content,author);
                wiseSayings.add(wiseSaying);
                System.out.printf("%d번 명언이 등록되었습니다.\n",lastIdx);
                break ;
            case "목록":
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");
                for(int i=wiseSayings.size()-1;i>=0;i--){
                    System.out.printf("%d / %s / %s\n",wiseSayings.get(i).id,wiseSayings.get(i).author,wiseSayings.get(i).content);
                }
                break;
            case "수정":
                modify(rq);
                break;
            case "삭제":
                remove(rq);
                break;
            case "종료":
                break  outer;
        }
    }
}
public void modify(Rq rq){
    int id=rq.getIntValue("id",0);

    if(id==0){
        System.out.println("번호를 입력해주세요.");
        return;
    }
    WiseSaying wiseSaying=findById(id);
    if(wiseSaying==null){
        System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
        return;
    }
    System.out.printf("명언(기존) : %s\n",wiseSaying.content);
    System.out.print("명언 : ");
    String content=sc.nextLine().trim();
    System.out.printf("작가(기존) : %s\n",wiseSaying.author);
    System.out.print("작가 : ");
    String author=sc.nextLine().trim();
    wiseSaying.content=content;
    wiseSaying.author=author;
}

    public void remove(Rq rq){
        int id=rq.getIntValue("id",0);

        //Rq의 예외처리가 발생시
        if(id==0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying=findById(id);

        //id와 일치하는 wiseSaying_이 없으면 예외처리
        if(wiseSaying==null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        wiseSayings.remove(wiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n",id);
    }
public WiseSaying findById(int id){
    WiseSaying foundWiseSaying=null;
    for(WiseSaying wiseSaying_:wiseSayings){
        if(wiseSaying_.id==id){
            foundWiseSaying=wiseSaying_;
        }
    }
    return foundWiseSaying;
}
}
