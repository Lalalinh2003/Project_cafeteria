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
public class ThucUong extends SanPham{   //co da: true  ; khong da: false
    private boolean choDa;
    /**
     * @return the choDa
     */
    public ThucUong() {
        
    }
    
    public boolean isDa() {
        return choDa;
    }

    /**
     * @param choDa the choDa to set
     */
    public void setDa(boolean choDa) {
        this.choDa = choDa;
    }
    

    public ThucUong(String tenSanPham, double giaSanPham, boolean tinhTrangSanPham, String thoiDiemBanSanPham, String danhMuc,boolean choDa) {
        super(tenSanPham, giaSanPham, tinhTrangSanPham,thoiDiemBanSanPham, danhMuc);
        this.choDa = choDa;
    }

    @Override
    public void hienThiSanPham() {
        String tinhTrangThucUong;
        super.hienThiSanPham(); 
        if (this.choDa) {
            tinhTrangThucUong = "Co da";
        }
        else {
            tinhTrangThucUong = "Khong da";
        }
        System.out.printf("%s\n",tinhTrangThucUong);
    }
    
    
    
    
    
}
