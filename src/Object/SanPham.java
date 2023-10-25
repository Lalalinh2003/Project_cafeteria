/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class SanPham {
    public String tenSanPham;
    private double giaSanPham;
    private boolean tinhTrangSanPham;
    private ArrayList<String> thoiDiemBanSanPham = new ArrayList<>();
    private String danhMuc;
    
    public SanPham() {
        
    }

    public SanPham(String tenSanPham, double giaSanPham, boolean tinhTrangSanPham, String thoiDiemBanSP, String danhMuc) {
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.tinhTrangSanPham = tinhTrangSanPham;
        String thoidiem [] = thoiDiemBanSP.split(",");
        for (String td : thoidiem) {
            thoiDiemBanSanPham.add(td);
        }
        this.danhMuc = danhMuc;
    }
     
    
    public void hienThiSanPham(){
        String tinhTrangSP;
        if (this.tinhTrangSanPham == true)
            tinhTrangSP = "con";
        else
            tinhTrangSP = "het";
        System.out.printf("%-20s %-15s %-16s %-20s %-15s", this.tenSanPham, this.giaSanPham, tinhTrangSP, this.thoiDiemBanSanPham, this.danhMuc);
        
    }
    
    
    /**
     * @return the tenSanPham
     */
    public String getTenSanPham() {
        return tenSanPham;
    }

    /**
     * @param tenSanPham the tenSanPham to set
     */
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    /**
     * @return the giaSanPham
     */
    public double getGiaSanPham() {
        return giaSanPham;
    }

    /**
     * @param giaSanPham the giaSanPham to set
     */
    public void setGiaSanPham(double giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    /**
     * @return the tinhTrangSanPham
     */
    public boolean isTinhTrangSanPham() {
        return tinhTrangSanPham;
    }

    /**
     * @param tinhTrangSanPham the tinhTrangSanPham to set
     */
    public void setTinhTrangSanPham(boolean tinhTrangSanPham) {
        this.tinhTrangSanPham = tinhTrangSanPham;
    }

    
    /**
     * @return the danhMuc
     */
    public String getDanhMuc() {
        return danhMuc;
    }

    /**
     * @param danhMuc the danhMuc to set
     */
    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    /**
     * @return the thoiDiemBanSanPham
     */
    public ArrayList<String> getThoiDiemBanSanPham() {
        return thoiDiemBanSanPham;
    }

    /**
     * @param thoiDiemBanSanPham the thoiDiemBanSanPham to set
     */
    public void setThoiDiemBanSanPham(ArrayList<String> thoiDiemBanSanPham) {
        this.thoiDiemBanSanPham = thoiDiemBanSanPham;
    }
            
}
