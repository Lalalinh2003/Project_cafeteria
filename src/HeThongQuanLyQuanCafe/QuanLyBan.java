/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;

import Object.Ban;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class QuanLyBan {

    private ArrayList<Ban> dsBan = new ArrayList<Ban>();
    Scanner sc = new Scanner(System.in);

    /**
     * @return the dsBan
     */
    public ArrayList<Ban> getDsBan() {
        return dsBan;
    }

    /**
     * @param dsBan the dsBan to set
     */
    public void setDsBan(ArrayList<Ban> dsBan) {
        this.dsBan = dsBan;
    }

    public void themBan(Ban... b) {
        this.dsBan.addAll(Arrays.asList(b));
    }

    public void xemDSBanTrong() {
        this.dsBan.stream().filter(b -> b.getTinhTrang() == true).forEach((b) -> b.hienThi());
    }

    public void xemDSBan() {
        this.dsBan.forEach((b) -> b.hienThi());
    }

    public void themThongTinBan() {
        String tinhTrang, sucChua;
        Ban b = new Ban();
        boolean flag = false;
        do {
            System.out.print("Nhap suc chua cua ban: ");
            sucChua = sc.nextLine();
            if (kiemTraChuoiLaSo(sucChua)) {
                b.setSucChua(Integer.parseInt(sucChua));
            } else {
                System.out.println("Nhap sai suc chua. Vui long nhap lai");
            }
        } while (b.getSucChua() == 0);

        do {
            System.out.print("Nhap tinh trang cua ban: ");
            tinhTrang = sc.nextLine();
            if (kiemTraTinhTrangBan(tinhTrang)) {
                if (tinhTrang.equalsIgnoreCase("trong")) {
                    b.setTinhTrang(true);
                } else {
                    b.setTinhTrang(false);
                }
                flag = true;
            } else {
                System.out.println("Nhap sai tinh trang ban. Vui long nhap lai");
            }
        } while (flag == false);
        dsBan.add(b);
    }

    public void xoaThongTinBan() {
        String maBanCanXoa;
        boolean flag = false;
        int viTriMaBanCanXoa = -1;
        do {
            xemDSBan();
            System.out.print("Nhap ma ban can xoa theo danh sach tren: ");
            maBanCanXoa = sc.nextLine();
            if (kiemTraMaBanHopLe(maBanCanXoa)) {
                String maBanKiTuCuoi = maBanCanXoa.substring(3);
                int index = 0;
                int maBanKiTuCuoiKieuSo = Integer.parseInt(maBanKiTuCuoi);
                for (Ban b : dsBan) {
                    if (b.getMaBan() == maBanKiTuCuoiKieuSo) {
                        viTriMaBanCanXoa = index;
                        break;
                    }
                    index++;
                }

                if (viTriMaBanCanXoa > -1) {
                    dsBan.remove(viTriMaBanCanXoa);
                    System.out.println("Ban co ma so " + maBanCanXoa + " da xoa thanh cong");
                } else {
                    System.out.println("Ban co ma so " + maBanCanXoa + " khong duoc tim thay");
                }
                flag = true;
            } else {
                System.out.println("Ma ban khong hop le. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);
    }

    public void capNhatSucChuaCuaBan() {
        String maBanCanCapNhat;
        boolean flag = true;
        int viTriMaBanCanCapNhat = -1;
        String sucChuaMoi;
        do {
            xemDSBan();
            System.out.print("Nhap ma ban can cap nhat theo danh sach tren: ");
            maBanCanCapNhat = sc.nextLine();
            if (kiemTraMaBanHopLe(maBanCanCapNhat)) {
                String maBanKiTuCuoi = maBanCanCapNhat.substring(3);
                int index = 0;
                int maBanKiTuCuoiKieuSo = Integer.parseInt(maBanKiTuCuoi);
                for (Ban b : dsBan) {
                    if (b.getMaBan() == maBanKiTuCuoiKieuSo) {
                        viTriMaBanCanCapNhat = index;
                        break;
                    }
                    index++;
                }

                if (viTriMaBanCanCapNhat > -1) {
                    do {
                        System.out.print("Nhap suc chua moi cua ban: ");
                        sucChuaMoi = sc.nextLine();
                        if (kiemTraChuoiLaSo(sucChuaMoi)) {
                            dsBan.get(viTriMaBanCanCapNhat).setSucChua(Integer.parseInt(sucChuaMoi));
                            flag = true;
                        } else {
                            System.out.println("Suc chua khong hop le. Vui long nhap lai");
                            flag = false;
                        }
                    } while (flag == false);
                } else {
                    System.out.println("Ban co ma so " + maBanCanCapNhat + " khong duoc tim thay");
                }
                flag = true;
            } else {
                System.out.println("Ma ban khong hop le. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);
    }

    public void capNhatTinhTrangCuaBan() {
        String maBanCanCapNhat;
        boolean flag = true;
        int viTriMaBanCanCapNhat = -1;
        String tinhTrangMoi;
        do {
            xemDSBan();
            System.out.print("Nhap ma ban can cap nhat theo danh sach tren: ");
            maBanCanCapNhat = sc.nextLine();
            if (kiemTraMaBanHopLe(maBanCanCapNhat)) {
                String maBanKiTuCuoi = maBanCanCapNhat.substring(3);
                int index = 0;
                int maBanKiTuCuoiKieuSo = Integer.parseInt(maBanKiTuCuoi);
                for (Ban b : dsBan) {
                    if (b.getMaBan() == maBanKiTuCuoiKieuSo) {
                        viTriMaBanCanCapNhat = index;
                        break;
                    }
                    index++;
                }

                if (viTriMaBanCanCapNhat > -1) {
                    do {
                        System.out.print("Nhap tinh trang moi cua ban: ");
                        tinhTrangMoi = sc.nextLine();
                        if (kiemTraTinhTrangBan(tinhTrangMoi)) {
                            if (tinhTrangMoi.equalsIgnoreCase("trong")) {
                                dsBan.get(viTriMaBanCanCapNhat).setTinhTrang(true);
                            } else {
                                dsBan.get(viTriMaBanCanCapNhat).setTinhTrang(false);
                            }
                            flag = true;
                        } else {
                            System.out.println("Tinh trang cua ban khong hop le. Vui long nhap lai");
                            flag = false;
                        }
                    } while (flag == false);
                } else {
                    System.out.println("Ban co ma so " + maBanCanCapNhat + " khong duoc tim thay");
                }
                flag = true;
            } else {
                System.out.println("Ma ban khong hop le. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);
    }

    public void timKiemTheoSucChua() {
        String stringSucChua;
        boolean flag = true;
        do {
            System.out.print("Nhap suc chua cua ban : ");
            stringSucChua = sc.nextLine();
            if (kiemTraChuoiLaSo(stringSucChua)) {
                int sucChua = Integer.parseInt(stringSucChua);
                List<Ban> ds = this.dsBan.stream().filter(b -> b.getSucChua() == sucChua).collect(Collectors.toList());
                if (ds.isEmpty()) {
                    System.out.println("[Error] Khong tim thay ban co thong tin tren trong trong danh sach");
                } else {
                    for (Ban b : ds) {
                        b.hienThi();
                    }
                }
                flag = true;
            } else {
                System.out.println("Suc chua khong hop le. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

    }

    public boolean kiemTraChuoiLaSo(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean kiemTraTinhTrangBan(String tinhTrangBan) {
        if (tinhTrangBan.equalsIgnoreCase("trong") || tinhTrangBan.equalsIgnoreCase("khong trong")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean kiemTraMaBanHopLe(String maBan) {
        String chuoiMacDinh = maBan.substring(0, 3);
        String kiTuCuoi = maBan.substring(3);
        if (chuoiMacDinh.equalsIgnoreCase("B00")) {
            return kiemTraChuoiLaSo(kiTuCuoi);
        }
        return false;
    }

    public void chucNangQuanLyBan() {
        System.out.println("1. Xem danh sach ban trong");
        System.out.println("2. Them thong tin ban");
        System.out.println("3. Xoa thong tin ban");
        System.out.println("4. Cap nhat thong tin ban");
        System.out.println("5. Tim kiem ban theo suc chua");  
    }
}
