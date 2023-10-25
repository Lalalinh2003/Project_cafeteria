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
public class ThucAn extends SanPham{   //do chay: true ; ko chay
    

    /**
     * @return the doChay
     */
    public boolean isDoChay() {
        return doChay;
    }

    /**
     * @param doChay the doChay to set
     */
    public void setDoChay(boolean doChay) {
        this.doChay = doChay;
    }
    private boolean doChay;

    public ThucAn() {
        
    }
    public ThucAn( String tenSanPham, double giaSanPham, boolean tinhTrangSanPham, String thoiDiemBanSanPham, String danhMuc,boolean doChay) {
        super(tenSanPham, giaSanPham, tinhTrangSanPham, thoiDiemBanSanPham, danhMuc);
        this.doChay = doChay;
    }

    @Override
    public void hienThiSanPham() {
        String tinhTrangThucAn;
        super.hienThiSanPham(); 
        if (this.doChay) {
            tinhTrangThucAn = "Chay";
        }
        else {
            tinhTrangThucAn = "Khong chay";
        }
        System.out.printf("%s\n",tinhTrangThucAn);
    }
    
    
    
    
    
}
