/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Ban {
    private int sucChua;
    private boolean tinhTrang;
    private static int dem;
    private int maBan = ++dem;

    public Ban(int sucChua, boolean tinhTrang) {
        this.sucChua = sucChua;
        this.tinhTrang = tinhTrang;
    }
    
    public Ban() {
       
    }
    /**
     * @return the maBan
     */
    public int getMaBan() {
        return maBan;
    }

    /**
     * @param maBan the maBan to set
     */
    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    /**
     * @return the sucChua
     */
    public int getSucChua() {
        return sucChua;
    }

    /**
     * @param sucChua the sucChua to set
     */
    public void setSucChua(int sucChua) {
        this.sucChua = sucChua;
    }

    /**
     * @return the tinhTrang
     */
    public boolean getTinhTrang() {
        return tinhTrang;
    }

    /**
     * @param tinhTrang the tinhTrang to set
     */
    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    public void hienThi() {
        String tinhTrangBan;
        if (this.tinhTrang)
            tinhTrangBan = "trong";   
        else
            tinhTrangBan = "khong trong";   
        System.out.printf("B%03d %s %-20d %s\n", this.maBan, "", this.sucChua, tinhTrangBan);
    }
}
