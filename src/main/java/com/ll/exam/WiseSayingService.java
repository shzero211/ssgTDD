package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
 WiseSayingRepository wiseSayingRepository;
    WiseSayingService(){
    wiseSayingRepository=new WiseSayingRepository();
    }
    public WiseSaying write(String content,String author){
     return wiseSayingRepository.write(content,author);

    }

    public List<WiseSaying> list() {
        return wiseSayingRepository.list();
    }

    public WiseSaying findById(int id){
        return wiseSayingRepository.findById(id);
    }

    public void remove(int id) {
    wiseSayingRepository.remove(id);
    }

    public void modify(int id, String content, String author) {
     wiseSayingRepository.modify(id,content,author) ;
    }
}
