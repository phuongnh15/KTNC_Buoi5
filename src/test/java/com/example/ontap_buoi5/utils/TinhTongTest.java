package com.example.ontap_buoi5.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TinhTongTest {
    private TinhTong tinhTong;

    @BeforeEach
    void setUp(){
        tinhTong = new TinhTong();
    }

    @Test
    void testTinhTongWithSoHopLe() {
        Assertions.assertEquals(6,tinhTong.tinhTongSoChan(5));
    }

    @Test
    void testTinhTongWithSoInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class,()->tinhTong.tinhTongSoChan(-1));
    }

}