package com.ll.exam;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input){
        Scanner sc=TestUtil.genScanner(input);
        //출력을 보관하기 위해 선언
        ByteArrayOutputStream output=TestUtil.setOutToByteArray();
        new App(sc).run();
        String rs=output.toString();
        TestUtil.clearSetOutToByteArray(output);
        return rs;
    }
}
