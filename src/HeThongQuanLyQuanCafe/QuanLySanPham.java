/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import object.SanPham;
import object.ThucAn;
import object.ThucUong;

/**
 *
 * @author ASUS
 */
public class QuanLySanPham {

    private List<SanPham> dsSP = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    /**
     * @return the dsSP
     */
    public List<SanPham> getDSSP() {
        return dsSP;
    }

    /**
     * @param dsSP the dsSP to set
     */
    public void setDSSP(List<SanPham> dsSP) {
        this.dsSP = dsSP;
    }

    public QuanLySanPham() {

    }

    public void themDSSanPham(SanPham... a) {
        this.dsSP.addAll(Arrays.asList(a));
    }

    public void hienThi() {
        this.dsSP.forEach(s -> s.hienThiSanPham());
    }

    public void hienThiDSThucAn() {
        this.dsSP.stream().filter(sp -> sp.getDanhMuc().equalsIgnoreCase("Thuc an")).forEach(sp -> sp.hienThiSanPham());
    }

    public void hienThiDSThucUong() {
        this.dsSP.stream().filter(sp -> sp.getDanhMuc().equalsIgnoreCase("Thuc uong")).forEach(sp -> sp.hienThiSanPham());
    }

    public void themSanPham() {
        String tenSP, tinhTrang, thoiDiemBan, ghiChu, giaBan, danhMuc;
        boolean flag = false;
        boolean phanLoai = true;
        ThucAn ta = new ThucAn();
        ThucUong tu = new ThucUong();

        do {
            System.out.print("Nhap danh muc san pham: ");
            danhMuc = sc.nextLine();
            danhMuc = chuanHoaChuoi(danhMuc);
            if (kiemTraDanhMuc(danhMuc)) {
                if (danhMuc.equalsIgnoreCase("thuc an")) {
                    phanLoai = true;
                    ta.setDanhMuc(danhMuc);
                }
                if (danhMuc.equalsIgnoreCase("thuc uong")) {
                    phanLoai = false;
                    tu.setDanhMuc(danhMuc);
                }
                flag = true;
            } else {
                System.out.println("Nhap sai danh muc. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

        System.out.print("Nhap ten san pham: ");
        tenSP = sc.nextLine();
        tenSP = chuanHoaChuoi(tenSP);
        if (phanLoai) {
            ta.setTenSanPham(tenSP);
        } else {
            tu.setTenSanPham(tenSP);
        }

        do {
            System.out.println("Nhap gia ban san pham: ");
            giaBan = sc.nextLine();
            if (kiemTraChuoiLaSo(giaBan)) {
                if (phanLoai) {
                    ta.setGiaSanPham(Double.parseDouble(giaBan));
                } else {
                    tu.setGiaSanPham(Double.parseDouble(giaBan));
                }
                flag = true;
            } else {
                System.out.println("Nhap sai gia san pham. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

        do {
            System.out.print("Nhap tinh trang san pham: ");
            tinhTrang = sc.nextLine();
            if (kiemTraTinhTrangSanPham(tinhTrang)) {
                if (tinhTrang.equalsIgnoreCase("con")) {
                    if (phanLoai) {
                        ta.setTinhTrangSanPham(true);
                    } else {
                        tu.setTinhTrangSanPham(true);
                    }

                } else if (tinhTrang.equalsIgnoreCase("het")) {
                    if (phanLoai) {
                        ta.setTinhTrangSanPham(false);
                    } else {
                        tu.setTinhTrangSanPham(false);
                    }
                }
                flag = true;
            } else {
                System.out.println("Nhap sai tinh trang san pham. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

        do {
            System.out.print("Nhap thoi diem ban(sang, trua, toi; ngan cach cac buoi bang dau phay): ");
            thoiDiemBan = sc.nextLine();
            thoiDiemBan = chuanHoaChuoi(thoiDiemBan);
            String s[] = thoiDiemBan.split(", ");
            if (kiemTraChuoiThoiDiemBanHang(s)) {
                if (phanLoai) {
                    for (String td : s) {
                        ta.getThoiDiemBanSanPham().add(td);
                    }
                } else {
                    for (String td : s) {
                        tu.getThoiDiemBanSanPham().add(td);
                    }
                }
                flag = true;
            } else {
                System.out.println("Nhap sai thoi diem. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);

        do {
            System.out.print("Nhap ghi chu them ve san pham(thuc an: chay hay khong chay; thuc uong: co da hay khong da): ");
            ghiChu = sc.nextLine();
            if (kiemTraGhiChuSanPham(ghiChu)) {
                if (ghiChu.equalsIgnoreCase("chay") || ghiChu.equalsIgnoreCase("khong chay")) {
                    if (ghiChu.equalsIgnoreCase("chay")) {
                        //sp3.setDoChay(true);
                        ta.setDoChay(true);

                    } else {
                        //sp3.setDoChay(false);
                        ta.setDoChay(false);
                    }
                } else if (ghiChu.equalsIgnoreCase("co da") || ghiChu.equalsIgnoreCase("khong da")) {
                    if (ghiChu.equalsIgnoreCase("co da")) {
                        //sp4.setDa(true);
                        tu.setDa(true);
                    } else {
                        //sp4.setDa(false);
                        tu.setDa(false);
                    }
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ghi chu san pham. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

        if (phanLoai) {
            dsSP.add(ta);
        } else {
            dsSP.add(tu);
        }
    }

    public void xoaSanPham() {
        String tenSP;
        boolean flag = false;
        int viTriCanXoa = -1, index;
        do {
            System.out.print("Nhap ten san pham can xoa: ");
            tenSP = sc.nextLine();
            tenSP = chuanHoaChuoi(tenSP);
            if (kiemTraTenSP(tenSP)) {
                index = 0;
                for (SanPham sp : dsSP) {
                    if (sp.getTenSanPham().equalsIgnoreCase(tenSP)) {
                        viTriCanXoa = index;
                        break;
                    }
                    index++;
                }
                if (viTriCanXoa > -1) {
                    this.dsSP.remove(viTriCanXoa);
                    System.out.println("San pham co ten " + tenSP + " da duoc xoa thanh cong");
                } else {
                    System.out.println("San pham khong duoc tim thay trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ten san pham. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

    }

    public void xoaSanPham1(SanPham... a) {
        this.dsSP.removeAll(Arrays.asList(a));
    }

    public void timKiemSanPhamTheoTen() {
        boolean flag = false;
        do {
            System.out.print("Nhap ten san pham can xoa: ");
            String tenSP = sc.nextLine();
            String tenSPChuan = chuanHoaChuoi(tenSP);
            if (kiemTraTenSP(tenSP)) {
                List<SanPham> dsTimDuoc = this.dsSP.stream().filter(sp -> sp.getTenSanPham().equalsIgnoreCase(tenSPChuan) == true).collect(Collectors.toList());
                if (dsTimDuoc.isEmpty()) {
                    System.out.println("Khong tim thay san pham nay trong danh sach");
                } else {
                    for (SanPham sp : dsTimDuoc) {
                        sp.hienThiSanPham();
                    }
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ten san pham. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);
    }

    public void timKiemSanPhamTheoGia() {
        double giaBatDau, giaKetThuc;
        System.out.println("Bat dau tu gia: ");
        giaBatDau = sc.nextDouble();
        System.out.println("Den gia: ");
        giaKetThuc = sc.nextDouble();
        for (SanPham sp : dsSP) {
            if (sp.getGiaSanPham() >= giaBatDau && sp.getGiaSanPham() <= giaKetThuc) {
                sp.hienThiSanPham();
            }
        }

    }

    public void sapXepTang() {
        this.dsSP.sort((s1, s2) -> {
            double g1 = s1.getGiaSanPham();
            double g2 = s2.getGiaSanPham();

            return (g1 > g2 ? 1 : (g1 < g2 ? -1 : 0));
        });
    }

    public void sapXepGiam() {
        this.dsSP.sort((s1, s2) -> {
            double g1 = s1.getGiaSanPham();
            double g2 = s2.getGiaSanPham();

            return (g1 < g2 ? 1 : (g1 > g2 ? -1 : 0));
        });
    }

    public String chuanHoaChuoi(String s) {
        String chuoiDuocChuanHoa = " ";
        String tmp = s.trim();
        tmp = tmp.replaceAll("\\s+", " ");
        return tmp;
    }

    public boolean kiemTraChuoiLaSo(String maSo) {
        try {
            int number = Integer.parseInt(maSo);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean kiemTraTinhTrangSanPham(String tinhTrang) {
        if (tinhTrang.equalsIgnoreCase("con") || tinhTrang.equalsIgnoreCase("het")) {
            return true;
        }
        return false;
    }

    public boolean kiemTraGhiChuSanPham(String ghiChu) {
        if (ghiChu.equalsIgnoreCase("chay") || ghiChu.equalsIgnoreCase("khong chay")
                || ghiChu.equalsIgnoreCase("co da") || ghiChu.equalsIgnoreCase("khong da")) {
            return true;
        }
        return false;
    }

    public boolean kiemTraDanhMuc(String danhMuc) {
        if (danhMuc.equalsIgnoreCase("thuc an") || danhMuc.equalsIgnoreCase("thuc uong")) {
            return true;
        }
        return false;
    }

    public boolean kiemTraChuoiThoiDiemBanHang(String s[]) {
        for (String i : s) {
            if (!i.equalsIgnoreCase("sang") && !i.equalsIgnoreCase("trua") && !i.equalsIgnoreCase("toi")) {
                return false;
            }
        }
        return true;
    }

    public boolean kiemTraTenSP(String s) {
        for (SanPham sp : dsSP) {
            if (sp.getTenSanPham().equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    public void chucNangQuanLySanPham() {
        System.out.println("1. Them san pham");
        System.out.println("2. Xoa san pham");
        System.out.println("3. Tim kiem san pham theo ten");
        System.out.println("4. Tim kiem san pham theo khoang gia");
        System.out.println("5. Sap xep danh sach giam dan");
        System.out.println("6. Sap xep danh sach tang dan");
    }
}
