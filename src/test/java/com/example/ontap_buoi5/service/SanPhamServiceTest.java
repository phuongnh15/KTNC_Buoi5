package com.example.ontap_buoi5.service;

import com.example.ontap_buoi5.entity.SanPham;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SanPhamServiceTest {
    private SanPhamService sanPhamService;
    @BeforeEach
    void setUp(){
        sanPhamService = new SanPhamService();
    }

    @Test
    void testAddSanPhamHopLe() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertEquals(1,sanPhamService.getAll().size());
    }

    @Test
    void testAddWithSanPhamNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(null));
    }

    @Test
    void testAddWithInvalidMa(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(new SanPham("","Banh gao",2,20000f,2,"Banh")));
    }

    @Test
    void testAddWithInvalidTen(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(new SanPham("SP1","",2,20000f,2,"Banh")));
    }

    @Test
    void testAddWithInvalidNamBaoHanh(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(new SanPham("SP1","",-2,20000f,2,"Banh")));
    }

    @Test
    void testAddWithInvalidGia(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(new SanPham("SP1","Banh gao",2,-20000f,2,"Banh")));
    }

    @Test
    void testAddWithInvalidSoLuong(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(new SanPham("SP1","Banh gao",2,20000f,-2,"Banh")));
    }

    @Test
    void testAddWithInvalidDanhMuc(){
        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.addSanPham(new SanPham("SP1","Banh gao",2,20000f,2,"")));
    }

    @Test
    void testDeleteSanPhamTrue() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertTrue(sanPhamService.deleteSanPham("SP1"));
    }

    @Test
    void testDeleteSanPhamFalse() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertFalse(sanPhamService.deleteSanPham("SP2"));
    }

    @Test
    void testDeleteSanPhamWithMaNull() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.deleteSanPham(null));
    }
    @Test
    void testUpdateWithSanPhamHopLe() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        sanPham.setTen("Keo ngo");
        sanPham.setGia(30000f);
        sanPhamService.updateSanPham(sanPham);

        Assertions.assertEquals("Keo ngo",sanPhamService.getOneSanPham("SP1").getTen());
        Assertions.assertEquals(30000,sanPhamService.getOneSanPham("SP1").getGia());
    }

    @Test
    void testUpdateWithInvalidTen() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.updateSanPham(new SanPham("SP1","",2,20000f,2,"Banh")));
    }

    @Test
    void testUpdateWithInvalidNamBaoHanh() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.updateSanPham(new SanPham("SP1","Banh gao",-2,20000f,2,"Banh")));
    }

    @Test
    void testUpdateWithInvalidGia() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.updateSanPham(new SanPham("SP1","Banh gao",2,-20000f,2,"Banh")));
    }

    @Test
    void testUpdateWithInvalidSoLuong() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.updateSanPham(new SanPham("SP1","Banh gao",2,20000f,-2,"Banh")));
    }

    @Test
    void testUpdateWithInvalidDanhMuc() {
        SanPham sanPham = new SanPham("SP1","Banh gao",2,20000f,2,"Banh");
        sanPhamService.addSanPham(sanPham);

        Assertions.assertThrows(IllegalArgumentException.class,()->sanPhamService.updateSanPham(new SanPham("SP1","Banh gao",2,20000f,2,"")));
    }

}