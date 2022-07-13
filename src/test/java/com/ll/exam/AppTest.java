package com.ll.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
@Test
    public void 문자열을_파일에_저장()
{
    Util.file.mkdir("test_data");
    Util.file.saveToFile("test_data/1.txt","안녕");

    String body=Util.file.readFromFile("test_data/1.txt");
    assertEquals("안녕",body);
}}