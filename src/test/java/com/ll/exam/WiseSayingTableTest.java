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
}
