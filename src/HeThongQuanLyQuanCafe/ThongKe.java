/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;

import Object.HoaDon;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class ThongKe {
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private ArrayList<HoaDon> dsHoaDon = new ArrayList<>();

    public ThongKe() {
        
    }
    public void themDSHoaDon(HoaDon... hd) {
        dsHoaDon.addAll(Arrays.asList(hd));
    }

    public void thongKeDoanhThuTheoThang() {
        for (int i = 1; i <= 12; i++) {
            int thang = i;
            double tongDoanhThuMotThang = 0;
            List<HoaDon> dsHoaDonTheoThang = dsHoaDon.stream().filter(hd -> hd.getNgayThanhToan().getMonthValue() == thang).collect(Collectors.toList());
            if (!dsHoaDonTheoThang.isEmpty()) {
                for (HoaDon hd : dsHoaDonTheoThang) {
                    tongDoanhThuMotThang += hd.getTongSoTien();
                }
                System.out.println("Doanh thu thang " + i + ": " + tongDoanhThuMotThang);
            }
        }
    }

    public void thongKeDoanhThuTheoThoiGianChiDinh() {
        String ngayBatDau, ngayKetThuc;
        boolean flag = false;
        double tongDoanhThuMotThang = 0;
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.now();
        do {
            System.out.print("Nhap ngay thang bat dau: ");
            ngayBatDau = sc.nextLine();
            if (kiemTraNgayHopLe(ngayBatDau)) {
                date1 = LocalDate.parse(ngayBatDau, format);
                flag = true;
            }      
            else {
                System.out.println("Nhap sai. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);
        
        do {
            System.out.print("Nhap ngay thang ket thuc: ");
            ngayKetThuc = sc.nextLine();
            if (kiemTraNgayHopLe(ngayKetThuc)) {
                date2 = LocalDate.parse(ngayKetThuc, format);
                flag = true;
            }         
            else {
                System.out.println("Nhap sai. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);
        
        for (HoaDon hd : dsHoaDon) {
            if ((hd.getNgayThanhToan().compareTo(date1) > 0 || hd.getNgayThanhToan().compareTo(date1) == 0) 
                    && (hd.getNgayThanhToan().compareTo(date2) < 0 || hd.getNgayThanhToan().compareTo(date2) == 0)) {
                tongDoanhThuMotThang += hd.getTongSoTien();
            }
        }
        System.out.println(tongDoanhThuMotThang);
    }
    
    public boolean kiemTraNgayHopLe(String date) {
        try {
            LocalDate localdate = LocalDate.parse(date, format);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
