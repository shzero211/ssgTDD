package com.ll.exam;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WiseSayingTableTest {
    private WiseSayingTable wiseSayingTable;
    @BeforeAll
    public void beforeAll(){
        App.mode="test";
        wiseSayingTable=new WiseSayingTable(App.getBaseDir());
    }
    @BeforeEach
    public void  beforeEach(){
        Util.file.deleteDir(App.getBaseDir());
        List<WiseSaying> wiseSayings=wiseSayingTable.findAll();
        wiseSayingTable.save("명언1","작가1");
        wiseSayingTable.save("명언2","작가2");
    }
    @Test
    public void 파일_저장_확인(){
        WiseSaying wiseSaying=new WiseSaying(1,"명언1","작가1");
        wiseSayingTable.save(wiseSaying);
        assertTrue(new File("test_data/wise_saying/1.json").exists());
    }
    @Test
    public void save_파라미터2개_테스트(){
        wiseSayingTable.save("명언1","작가1");
        wiseSayingTable.save("명언2","작가2");
        assertTrue(new File("test_data/wise_saying/1.json").exists());
        assertTrue(new File("test_data/wise_saying/2.json").exists());
    }
    @Test
    public void BeForeEach_로_text_data_파일_삭제후_저장_테스트(){
        int id=wiseSayingTable.getLastId()+1;
        wiseSayingTable.save("명언1","작가1");
        assertTrue(new File("%s/wise_saying/%d.json".formatted(App.getBaseDir(),id)).exists());
    }
    @Test
    public void 조회하기(){
        wiseSayingTable.save("명언1","작가1");
        WiseSaying wiseSaying=wiseSayingTable.findById(1);
        assertEquals(1,wiseSaying.id);
        assertEquals("명언1",wiseSaying.content);
        assertEquals("작가1",wiseSaying.author);

    }
    @Test
    public void 전체조회() {
        List<WiseSaying> wiseSayings = wiseSayingTable.findAll();
        assertEquals(2, wiseSayings.size());

        assertEquals(1, wiseSayings.get(0).id);
        assertEquals("명언1", wiseSayings.get(0).content);
        assertEquals("작가1", wiseSayings.get(0).author);

        assertEquals(2, wiseSayings.get(1).id);
        assertEquals("명언2", wiseSayings.get(1).content);
        assertEquals("작가2", wiseSayings.get(1).author);
    }
    @Test
    public void 삭제() {
        wiseSayingTable.removeById(1);

        WiseSaying wiseSaying = wiseSayingTable.findById(1);

        assertEquals(null, wiseSaying);
    }
}
