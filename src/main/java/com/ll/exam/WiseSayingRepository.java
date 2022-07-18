package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private WiseSayingTable wiseSayingTable;
    private int lastIdx;
    //private List<WiseSaying> wiseSayings;
    WiseSayingRepository(){
        wiseSayingTable=new WiseSayingTable(App.getBaseDir());
       // lastIdx=0;
        //wiseSayings=new ArrayList<>();
    }

    public WiseSaying write(String content, String author) {
        return wiseSayingTable.save(content,author);
//        WiseSaying wiseSaying=new WiseSaying(++lastIdx,content,author);
//        wiseSayings.add(wiseSaying);
//        return wiseSaying;
    }


    public WiseSaying findById(int id) {
        return wiseSayingTable.findById(id);
      /*  WiseSaying foundWiseSaying=null;
        for(WiseSaying wiseSaying_:wiseSayings){
            if(wiseSaying_.id==id){
                foundWiseSaying=wiseSaying_;
            }
        }
        return foundWiseSaying;*/
    }
    public List<WiseSaying> findAll(){
        return wiseSayingTable.findAll();
    }
    public void remove(int id) {
       wiseSayingTable.removeById(id);
//        WiseSaying wiseSaying=findById(id);
//        wiseSayings.remove(wiseSaying);
    }

    public void modify(int id, String content, String author) {
         wiseSayingTable.save(id, content, author);
//        WiseSaying wiseSaying=findById(id);
//        wiseSaying.content=content;
//        wiseSaying.author=author;
    }
}
