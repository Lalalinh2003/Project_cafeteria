/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class HoaDon {
    private LocalDate ngayThanhToan;
    private double tongSoTien;
    public HoaDon(LocalDate ngayThanhToan, double tongSoTien) {
        this.ngayThanhToan = ngayThanhToan;
        this.tongSoTien = tongSoTien;
    }

    /**
     * @return the ngayThanhToan
     */
    public LocalDate getNgayThanhToan() {
        return ngayThanhToan;
    }

    /**
     * @param ngayThanhToan the ngayThanhToan to set
     */
    public void setNgayThanhToan(LocalDate ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    /**
     * @return the tongSoTien
     */
    public double getTongSoTien() {
        return tongSoTien;
    }

    /**
     * @param tongSoTien the tongSoTien to set
     */
    public void setTongSoTien(double tongSoTien) {
        this.tongSoTien = tongSoTien;
    }
}