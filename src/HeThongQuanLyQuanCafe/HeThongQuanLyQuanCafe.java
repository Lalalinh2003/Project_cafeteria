/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;

import Object.Ban;
import Object.BoPhan;
import Object.HoaDon;
import Object.NhanVien;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import object.SanPham;
import object.ThucAn;
import object.ThucUong;

/**
 *
 * @author ASUS
 */
public class HeThongQuanLyQuanCafe {

    public static void main(String[] args) {
        NhanVien nv1 = new NhanVien("Nguyen Van A", "Nam", LocalDate.of(1998, 02, 20), "Binh Duong", 1, LocalDate.of(2015, 02, 20));
        NhanVien nv2 = new NhanVien("Tran Thi A", "Nu", LocalDate.of(2000, 07, 15), "Binh Duong", 2, LocalDate.of(2015, 02, 20));
        NhanVien nv3 = new NhanVien("Nguyen Thi B", "Nu", LocalDate.of(2001, 10, 23), "Long An", 3, LocalDate.of(2015, 02, 20));
        Scanner sc = new Scanner(System.in);
        QuanLyNhanVien qlnv = new QuanLyNhanVien();
        qlnv.themNV(nv1, nv2, nv3);
        String chucNangQuanLy;
        int chucNangChinh, thongTinTraCuu, thongTinCapNhat, thongTinBanCapNhat;
        String kyTu;
        QuanLySanPham qlsp = new QuanLySanPham();
        Ban b1 = new Ban(4, true); //trong: true, khong trong: false
        Ban b2 = new Ban(3, false);
        Ban b3 = new Ban(3, true);
        QuanLyBan qlb = new QuanLyBan();
        qlb.themBan(b1, b2, b3);

        SanPham sp1 = new ThucAn("Banh mi", 20000, true, "Sang, Trua", "Thuc an", true); //con: true; het: false (cai thu 1)
        SanPham sp2 = new ThucUong("Tra sua", 25000, true, "Trua, Toi", "Thuc uong", true);
        SanPham sp3 = new ThucAn("Banh kem", 30000, false, "Trua, Toi", "Thuc an", false);
        SanPham sp4 = new ThucUong("Cafe", 15000, true, "Sang, Toi", "Thuc uong", false);
        qlsp.themDSSanPham(sp1, sp2, sp3, sp4);
        ThongKe tk = new ThongKe();
        
        DatBan order = new DatBan();
        HoaDon hd1 = new HoaDon(LocalDate.of(2022, 05, 01), 250000);
        HoaDon hd2 = new HoaDon(LocalDate.of(2022, 06, 18), 100000);
        HoaDon hd3 = new HoaDon(LocalDate.of(2022, 07, 17), 250000);
       HoaDon hd4 = new HoaDon(LocalDate.of(2022, 06, 20), 400000);
       HoaDon hd5 = new HoaDon(LocalDate.of(2022, 07, 10), 300000);
        HoaDon hd6 = new HoaDon(LocalDate.of(2022, 02, 10), 300000);
        HoaDon hd7 = new HoaDon(LocalDate.of(2022, 07, 10), 300000);
        HoaDon hd8 = new HoaDon(LocalDate.of(2022, 12, 03), 120000);
        HoaDon hd9 = new HoaDon(LocalDate.of(2022, 10, 23), 300000);
        HoaDon hd10 = new HoaDon(LocalDate.of(2022, 11, 23), 300000);
        tk.themDSHoaDon(hd1, hd2, hd3, hd4, hd5, hd6, hd7, hd8, hd9, hd10);
        
        
        do {
            System.out.println("=====HE THONG QUAN LY QUAN CAFE=====");
            System.out.println("Chuong trinh quan ly");
            System.out.println("A. Nhan vien");
            System.out.println("B. Ban");
            System.out.println("C. Thuc an; Thuc uong");
            System.out.println("D. Xac dinh danh sach nhan vien sinh trong thang hien tai");
            System.out.println("E. Dat ban");
            System.out.println("F. Thanh toan hoa don");
            System.out.println("G. Thong ke doanh thu theo thang");
            System.out.println("H. Thong ke doanh thu theo thoi gian chi dinh");
            System.out.print("Chon mot chuc nang: ");
            chucNangQuanLy = sc.nextLine();
            if (chucNangQuanLy.equalsIgnoreCase("A")) {
                qlnv.chucNangQuanLyNhanVien();
                System.out.print("Chon mot chuc nang: ");
                chucNangChinh = sc.nextInt();
                sc.nextLine();
                switch (chucNangChinh) {
                    case 1:
                        System.out.println("== Xem danh sach nhan vien ==");
                        qlnv.xemDSNV();
                        break;
                    case 2:
                        //Tra cuu thong tin nhan vien
                        System.out.print("Tra cuu theo thong tin nao: ");
                        System.out.println("1. Ho ten");
                        System.out.println("2. Gioi tinh");
                        System.out.println("3. Que quan");
                        System.out.println("4. Ngay sinh");
                        System.out.print("Chon: ");
                        thongTinTraCuu = sc.nextInt();
                        sc.nextLine();
                        switch (thongTinTraCuu) {
                            case 1:
                                System.out.println("== Tra cuu nhan vien theo ho ten ==");
                                qlnv.traCuuTheoHoTen();
                                break;
                            case 2:
                                System.out.println("== Tra cuu nhan vien theo gioi tinh ==");
                                qlnv.traCuuTheoGioiTinh();
                                break;
                            case 3:
                                System.out.println("== Tra cuu nhan vien theo que quan ==");
                                qlnv.traCuuTheoQueQuan();
                                break;
                            case 4:
                                System.out.println("== Tra cuu nhan vien theo ngay sinh ==");
                                qlnv.traCuuTheoNgaySinh();
                                break;
                        }
                        break;
                    case 3:
                        //Them thong tin nhan vien
                        System.out.println("== Them thong tin nhan vien ==");
                        qlnv.themThongTinNV();
                        System.out.println("Danh sach sau khi them: ");
                        qlnv.xemDSNV();
                        break;
                    case 4:
                        //Xoa thong tin nhan vien
                        System.out.println("== Xoa thong tin nhan vien ==");
                        qlnv.xoaThongTinNV();
                        System.out.println("== Danh sach sau khi xoa thong tin nhan vien ==");
                        qlnv.xemDSNV();
                        break;
                    case 5:
                        //Cap nhat thong tin nhan vien
                        System.out.println("Cap nhat thong tin nao: ");
                        System.out.println("1. Ho ten");
                        System.out.println("2. Gioi tinh");
                        System.out.println("3. Que quan");
                        System.out.println("4. Ngay sinh");
                        System.out.println("5. Ma bo phan");
                        System.out.println("6. Ngay vao lam");
                        System.out.print("Chon: ");
                        thongTinCapNhat = sc.nextInt();
                        sc.nextLine();
                        switch (thongTinCapNhat) {
                            case 1:
                                System.out.println("== Cap nhat ho ten cua nhan vien ==");
                                qlnv.capNhatHoTen();
                                System.out.println("== Danh sach sau khi cap nhat ==");
                                qlnv.xemDSNV();
                                break;
                            case 2:
                                System.out.println("== Cap nhat gioi tinh cua nhan vien ==");
                                qlnv.capNhatGioiTinh();
                                System.out.println("== Danh sach sau khi cap nhat ==");
                                qlnv.xemDSNV();
                                break;
                            case 3:
                                System.out.println("== Cap nhat que quan cua nhan vien ==");
                                qlnv.capNhatQueQuan();
                                System.out.println("== Danh sach sau khi cap nhat ==");
                                qlnv.xemDSNV();
                                break;
                            case 4:
                                System.out.println("== Cap nhat ngay sinh cua nhan vien ==");
                                qlnv.capNhatNgaySinh();
                                System.out.println("== Danh sach sau khi cap nhat ==");
                                qlnv.xemDSNV();
                                break;
                            case 5:
                                System.out.println("== Cap nhat ma bo phan cua nhan vien ==");
                                qlnv.capNhatMaBoPhan();
                                System.out.println("== Danh sach sau khi cap nhat ==");
                                qlnv.xemDSNV();
                                break;
                            case 6:
                                System.out.println("== Cap nhat ngay vao lam cua nhan vien ==");
                                qlnv.capNhatNgayVaoLam();
                                System.out.println("== Danh sach sau khi cap nhat ==");
                                qlnv.xemDSNV();
                                break;
                        }
                        break;
                    case 6:
                        qlnv.xemDanhSachNhanVienSinhNhatTrongThangHienTai();
                        break;
                }
            } else if (chucNangQuanLy.equalsIgnoreCase("B")) {
                qlb.chucNangQuanLyBan();
                System.out.println("Chon mot chuc nang: ");
                chucNangChinh = sc.nextInt();
                sc.nextLine();
                switch (chucNangChinh) {
                    case 1:
                        System.out.println("== Xem danh sach ban trong ==");
                        qlb.xemDSBanTrong();
                        break;
                    case 2:
                        System.out.println("== Them thong tin ban ==");
                        qlb.themThongTinBan();
                        System.out.println("Danh sach sau khi them: ");
                        qlb.xemDSBan();
                        break;
                    case 3:
                        System.out.println("== Xoa thong tin ban ==");
                        qlb.xoaThongTinBan();
                        System.out.println("Danh sach sau khi xoa: ");
                        qlb.xemDSBan();
                        break;
                    case 4:
                        System.out.println("Cap nhat thong tin nao");
                        System.out.println("1. Suc chua cua ban");
                        System.out.println("2. Tinh trang cua ban");
                        System.out.print("Chon: ");
                        thongTinBanCapNhat = sc.nextInt();
                        sc.nextLine();
                        switch (thongTinBanCapNhat) {
                            case 1:
                                System.out.println("== Cap nhat suc chua cua ban ==");
                                qlb.capNhatSucChuaCuaBan();
                                System.out.println("Danh sach sau khi cap nhat: ");
                                qlb.xemDSBan();
                                break;
                            case 2:
                                System.out.println("== Cap nhat tinh trang cua ban ==");
                                qlb.capNhatTinhTrangCuaBan();
                                System.out.println("Danh sach sau khi cap nhat: ");
                                qlb.xemDSBan();
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("== Tim kiem ban theo suc chua ==");
                        qlb.timKiemTheoSucChua();
                        break;
                }
            } else if (chucNangQuanLy.equalsIgnoreCase("C")) {
                qlsp.hienThi();
                qlsp.chucNangQuanLySanPham();
                System.out.println("Chon mot chuc nang: ");
                chucNangChinh = sc.nextInt();
                sc.nextLine();
                switch (chucNangChinh) {
                    case 1:
                        System.out.println("== Them san pham ==");
                        qlsp.themSanPham();
                        qlsp.hienThi();
                        break;
                    case 2:
                        System.out.println("== Xoa san pham ==");
                        qlsp.xoaSanPham();
                        qlsp.hienThi();
                        break;
                    case 3:
                        System.out.println("== Tim kiem san pham theo ten ==");
                        qlsp.timKiemSanPhamTheoTen();
                        break;
                    case 4:
                        System.out.println("== Tim kiem san pham theo khoang gia ==");
                        qlsp.timKiemSanPhamTheoGia();
                        break;
                    case 5:
                        System.out.println("== Sap xep san pham giam dan theo gia ==");
                        qlsp.sapXepGiam();
                        qlsp.hienThi();
                        break;
                    case 6:
                        System.out.println("== Sap xep san pham tang dan theo gia ==");
                        qlsp.sapXepTang();
                        qlsp.hienThi();
                        break;

                }
            } else if (chucNangQuanLy.equalsIgnoreCase("d")) {
                qlnv.xemDanhSachNhanVienSinhNhatTrongThangHienTai();
            } else if (chucNangQuanLy.equalsIgnoreCase("e")) {
                order.datBan();
                order.hienThiDatBan();
            } else if (chucNangQuanLy.equalsIgnoreCase("f")) {
                double tongSoTien = order.thanhToanHoaDon();
                HoaDon hd = new HoaDon(LocalDate.of(2022, 05, 17), tongSoTien);
                System.out.println("Tong so tien: " + tongSoTien);
            } else if (chucNangQuanLy.equalsIgnoreCase("g")) {
                tk.thongKeDoanhThuTheoThang();
            } else if (chucNangQuanLy.equalsIgnoreCase("h")) {
                tk.thongKeDoanhThuTheoThoiGianChiDinh();
            }
            System.out.print("Nhan 'y' de tiep tuc. Nhan 'n' de ket thuc: ");
            kyTu = sc.nextLine();

        } while (kyTu.equalsIgnoreCase("y"));

    }

}
