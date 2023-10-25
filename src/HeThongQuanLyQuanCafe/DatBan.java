/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;
//package com.mycompany.mavenproject1.class SanPham;

import Object.Ban;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import object.SanPham;
import object.ThucAn;
import object.ThucUong;

/**
 *
 * @author ASUS
 */
public class DatBan {
    private int soLuongBan, soNguoi;   
    private ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
    private ArrayList<Ban> dsBanDat = new ArrayList<>();
    private ArrayList<Integer> soLuongThucAn = new ArrayList<>();
    private ArrayList<Integer> soLuongThucUong = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    QuanLySanPham qlsp = new QuanLySanPham();
    QuanLyBan qlb = new QuanLyBan();
    
    public DatBan() {
        Ban b1 = new Ban(4, true); //trong: true, khong trong: false
        Ban b2 = new Ban(3, false);
        Ban b3 = new Ban(3, true);
        qlb.themBan(b1, b2, b3);
        
        SanPham sp1 = new ThucAn("Banh mi", 20000, true, "Sang, Trua", "Thuc an", true); //con: true; het: false (cai thu 1)
        SanPham sp2 = new ThucUong("Tra sua", 25000, true, "Trua, Toi", "Thuc uong", true);  
        SanPham sp3 = new ThucAn("Banh kem", 30000, false, "Trua, Toi", "Thuc an", false);
        SanPham sp4 = new ThucUong("Cafe", 15000, true, "Sang, Toi", "Thuc uong", false);
        qlsp.themDSSanPham(sp1, sp2, sp3, sp4);
    }

    /*public DatBan(int soLuongBan, Ban maBan, SanPham sanPham, List<SanPham> danhSachSanPham) {
        this.soLuongBan = soLuong;
        this.maBan = maBan;
        this.sanPham = sanPham;
        this.danhSachSanPham = danhSachSanPham;
    }*/
    public void hienThiDatBan() {
        System.out.printf("So nguoi:%d\n", this.soNguoi);
        System.out.printf("So ban dat:%d\n", this.soLuongBan);
        System.out.print("Ma ban dat: ");
        this.dsBanDat.stream().forEach(b -> {System.out.println("B00" + b.getMaBan());});
        System.out.print("Danh sach do an: ");
        this.danhSachSanPham.stream().filter(thucan -> thucan.getDanhMuc().equalsIgnoreCase("thuc an")).forEach(thucan -> {System.out.print(thucan.getTenSanPham() + "\t");});
        System.out.print("\nSo luong thuc an: ");
        this.soLuongThucAn.forEach(n -> {System.out.println(n);});
        System.out.print("Danh sach do uong: ");
        this.danhSachSanPham.stream().filter(thucuong -> thucuong.getDanhMuc().equalsIgnoreCase("thuc uong")).forEach(thucuong -> {System.out.print(thucuong.getTenSanPham() + "\t");});
        System.out.print("\nSo luong thuc uong: ");
        this.soLuongThucUong.forEach(n -> {System.out.println(n);});
    }

    /**
     * @return the soLuongBan
     */
    public int getSoLuongBan() {
        return soLuongBan;
    }

    /**
     * @param soLuongBan the soLuongBan to set
     */
    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public void datBan() {
        int i = 0, soLuongLoaiThucAn, soLuongLoaiThucUong;
        String thucAn, thucUong, tinHieu;
        boolean flag = false;

        System.out.println("Nhap so nguoi ngoi: ");
        this.soNguoi = sc.nextInt();
        System.out.println("Nhap so luong ban: ");
        this.soLuongBan = sc.nextInt();
        sc.nextLine();
        do {
            qlb.xemDSBan();
            System.out.println("Nhap ma ban theo danh sach: ");
            String maBan = sc.nextLine();
            if (kiemTraMaBanHopLe(maBan)) {
                int maBanKieuSo = Integer.parseInt(maBan.substring(3));      
                for (Ban b : qlb.getDsBan()) {
                    if (b.getMaBan() == maBanKieuSo) {
                        dsBanDat.add(b);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("Khong co ma ban " + maBan);
                }
            }
            else {
                System.out.println("Nhap sai ma ban. Vui long nhap lai");
                flag = false;
            }
            if (flag)
                i++;
        } while (i <soLuongBan);
        
        flag = false;
        qlsp.hienThiDSThucAn();
        do {
            System.out.println("Nhap loai thuc an theo danh sach: ");
            thucAn = sc.nextLine();
            if (kiemTraTenSP(thucAn)) {
                for (SanPham sp1 : qlsp.getDSSP()) {
                    if (sp1.getTenSanPham().equalsIgnoreCase(thucAn)) {
                        danhSachSanPham.add(sp1);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Nhap so luong cua mon: ");
                    soLuongLoaiThucAn = sc.nextInt();
                    sc.nextLine();
                    soLuongThucAn.add(soLuongLoaiThucAn);
                    i++;
                }
                else {
                    System.out.println("Khong co ten mon an");
                    flag = false;
                }
            } else {
                System.out.println("Khong co ten mon an");
                flag = false;
            }

            System.out.println("Tiep tuc dat them mon an? Nhan 'y' de tiep tuc. Nhan 'n' de ket thuc ");
            tinHieu = sc.nextLine();
            if (tinHieu.equalsIgnoreCase("n"))
                break;
        } while (tinHieu.equalsIgnoreCase("y"));

        qlsp.hienThiDSThucUong();
        do {
            System.out.println("Nhap loai thuc uong theo danh sach: ");
            thucUong = sc.nextLine();
            if (kiemTraTenSP(thucUong)) {
                for (SanPham sp1 : qlsp.getDSSP()) {
                    if (sp1.getTenSanPham().equalsIgnoreCase(thucUong)) {
                        danhSachSanPham.add(sp1);
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Nhap so luong cua do uong: ");
                    soLuongLoaiThucUong = sc.nextInt();
                    sc.nextLine();
                    soLuongThucUong.add(soLuongLoaiThucUong);
                    i++;
                }
                else {
                    System.out.println("Khong co ten mon an");
                    flag = false;
                }
            }
            else {
                System.out.println("Khong co ten mon an");
                flag = false;
            }
            System.out.println("Tiep tuc dat them do uong? Nhan 'y' de tiep tuc. Nhan 'n' de ket thuc ");
            tinHieu = sc.nextLine();
            if (tinHieu.equalsIgnoreCase("n"))
                break;
        } while (tinHieu.equalsIgnoreCase("y"));

    }

    public boolean kiemTraTenSP(String s) {
        for (SanPham sp : qlsp.getDSSP()) {
            if (sp.getTenSanPham().equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean kiemTraChuoiLaSo(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    public boolean kiemTraMaBanHopLe(String maBan) {
        String chuoiMacDinh = maBan.substring(0, 3);
        String kiTuCuoi = maBan.substring(3);
        if (chuoiMacDinh.equalsIgnoreCase("B00")) {
            return kiemTraChuoiLaSo(kiTuCuoi);
        }
        return false;
    }
    
    public double thanhToanHoaDon() {
        double tongSoTien = 0;
        int i = 0, j = 0;
        for (SanPham sp : danhSachSanPham) {
            //soLuongThucAn
            if (sp.getDanhMuc().equalsIgnoreCase("thuc an")) {
                tongSoTien += sp.getGiaSanPham() * soLuongThucAn.get(i);
                i++;
            }
            else {
                tongSoTien += sp.getGiaSanPham() * soLuongThucUong.get(j);
                j++;
            }
        }
        return tongSoTien;
    }
}
