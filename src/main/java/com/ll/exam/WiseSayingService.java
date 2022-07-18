package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WiseSayingService {
 WiseSayingRepository wiseSayingRepository;
    WiseSayingService(){
    wiseSayingRepository=new WiseSayingRepository();
    }
    public WiseSaying write(String content,String author){
     return wiseSayingRepository.write(content,author);

    }

    public List<WiseSaying> list() {
        return wiseSayingRepository.findAll();
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

    public void dumpToJson() {
        List<WiseSaying> wiseSayings=wiseSayingRepository.findAll();
        String json="["+wiseSayings.stream().map(wiseSaying -> wiseSaying.toJson())
                .collect(Collectors.joining(","))+"]";
        Util.file.saveToFile("%s/data.json".formatted(App.getBaseDir()),json);
    }
}
