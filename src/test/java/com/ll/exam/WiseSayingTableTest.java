package com.ll.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class WiseSayingTableTest {
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
}
