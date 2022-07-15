package com.ll.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class WiseSayingTableTest {
    @BeforeEach
    public void  deleteDB(){
        Util.file.deleteDir("test_data");
    }
    @Test
    public void 파일_저장_확인(){
        WiseSayingTable wiseSayingTable=new WiseSayingTable("test_data");
        WiseSaying wiseSaying=new WiseSaying(1,"명언1","작가1");
        wiseSayingTable.save(wiseSaying);
        assertTrue(new File("test_data/wise_saying/1.json").exists());
    }
    @Test
    public void save_파라미터2개_테스트(){
        WiseSayingTable wiseSayingTable=new WiseSayingTable("test_data");
        wiseSayingTable.save("명언1","작가1");
        wiseSayingTable.save("명언2","작가2");
        assertTrue(new File("test_data/wise_saying/1.json").exists());
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }
    @Test
    public void BeForeEach_로_text_data_파일_삭제후_저장_테스트(){
        WiseSayingTable wiseSayingTable=new WiseSayingTable("test_data");
        int id=wiseSayingTable.getLastId()+1;
        wiseSayingTable.save("명언1","작가1");
        assertTrue(new File("test_data/wise_saying/%d.json".formatted(id)).exists());
    }
}
