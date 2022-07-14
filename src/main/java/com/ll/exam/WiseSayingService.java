package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int lastIdx;
    private List<WiseSaying> wiseSayings;
    WiseSayingService(){
        lastIdx=0;
        wiseSayings=new ArrayList<>();
    }
    public WiseSaying write(String content,String author){
        WiseSaying wiseSaying=new WiseSaying(++lastIdx,content,author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> list() {
        return wiseSayings;
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

    public void remove(int id) {
        WiseSaying wiseSaying=findById(id);
        wiseSayings.remove(wiseSaying);
        return;
    }

    public void modify(int id, String content, String author) {
        WiseSaying wiseSaying=findById(id);
        wiseSaying.content=content;
        wiseSaying.author=author;
        return ;
    }
}
