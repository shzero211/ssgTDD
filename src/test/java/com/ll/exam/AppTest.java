package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
@Test
    public void 문자열을_파일에_저장()
{
    Util.file.mkdir("test_data");
    Util.file.saveToFile("test_data/1.txt","안녕");

    String body=Util.file.readFromFile("test_data/1.txt");
    assertEquals("안녕",body);
}
    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertEquals("안녕", cmd);
    }

    @Test
    public void 출력을_모니터에_하지_않고_문자열로_얻기() {
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertEquals("안녕", rs);
    }
    @Test
    public void 프로그램_시작시_타이틀_출력_그리고_종료() {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);

        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령)"));
    }
@Test
    public void 등록을_입력하면_명언과_작가_출력(){
    //문자열로 입력을 받음
    String rs=AppTestRunner.run("""
            등록
            명언1
            작가1
            종료
            """);

   assertTrue(rs.contains("명언 : "));
    assertTrue(rs.contains("작가 : "));
    assertTrue(rs.contains("1번 명언이 등록되었습니다."));
}

}