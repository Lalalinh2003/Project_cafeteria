/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Object;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class NhanVien {
 
    /**
     * @param args the command line arguments
     */
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy, MM, dd");
    private String hoTenNV, gioiTinh, queQuan;
    private LocalDate ngayVaoLam, ngaySinh;
    private static int dem;
    private int maNV = ++dem;
    private int maBoPhan;
    
    public NhanVien(String hotenNV, String gioiTinh, LocalDate ngaySinh, String queQuan, int maBP, LocalDate ngayVaoLam) {
        this.hoTenNV = hotenNV;
        this.gioiTinh = gioiTinh;
        this.queQuan = queQuan;
        this.maBoPhan = maBP;
        this.ngaySinh = ngaySinh;
        this.ngayVaoLam = ngayVaoLam;
    }

    public NhanVien() {
        
    }
    /**
     * @return the maNV
     */
    public int getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    /**
     * @return the hoTenNV
     */
    public String getHoTenNV() {
        return hoTenNV;
    }

    /**
     * @param hoTenNV the hoTenNV to set
     */
    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the queQuan
     */
    public String getQueQuan() {
        return queQuan;
    }

    /**
     * @param queQuan the queQuan to set
     */
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public void hienThi() {
        System.out.printf("%-5s %-20s %-5s %-15s %-20s %-15s %s\n", this.maNV, this.hoTenNV
        , this.gioiTinh, this.ngaySinh, this.queQuan, this.ngayVaoLam, this.maBoPhan);
    }

    /**
     * @return the ngayVaoLam
     */
    public LocalDate getNgayVaoLam() {
        return ngayVaoLam;
    }

    /**
     * @param ngayVaoLam the ngayVaoLam to set
     */
    public void setNgayVaoLam(LocalDate ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    /**
     * @return the ngaySinh
     */
    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the format
     */
    public DateTimeFormatter getFormat() {
        return format;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(DateTimeFormatter format) {
        this.format = format;
    }

    /**
     * @return the maBoPhan
     */
    public int getMaBoPhan() {
        return maBoPhan;
    }

    /**
     * @param maBoPhan the maBoPhan to set
     */
    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    
    
    
}
