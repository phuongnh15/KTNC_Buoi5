package com.example.ontap_buoi5.utils;

public class TinhTong {
    public int tinhTongSoChan(int n){
        if(n<1){
            throw new IllegalArgumentException("n phai > 1");
        }
        int tong = 0;
        for (int i = 1; i<=n;i++){
            if(i%2==0){
                tong+=i;
            }
        }
        return tong;
    }
}
