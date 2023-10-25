/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;

import Object.BoPhan;
import Object.NhanVien;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class QuanLyNhanVien {

    private ArrayList<NhanVien> dsNV = new ArrayList<>();
    private DateTimeFormatter datetimeformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    Scanner sc = new Scanner(System.in);

    QuanLyBoPhan qlbp = new QuanLyBoPhan();

    public QuanLyNhanVien() {
        BoPhan bp1 = new BoPhan("Pha che");
        BoPhan bp2 = new BoPhan("Phuc vu");
        BoPhan bp3 = new BoPhan("Tiep tan");
        qlbp.themDSBoPhan(bp1, bp2, bp3);
    }

    public void themNV(NhanVien... nv) {
        this.getDsNV().addAll(Arrays.asList(nv));
    }

    //public List<NhanVien>
    /**
     * @return the dsNV
     */
    public ArrayList<NhanVien> getDsNV() {
        return dsNV;
    }

    /**
     * @param dsNV the dsNV to set
     */
    public void setDsNV(ArrayList<NhanVien> dsNV) {
        this.dsNV = dsNV;
    }

    public void xemDSNV() {
        this.dsNV.forEach((nv) -> nv.hienThi());
    }

    public void traCuuTheoHoTen() {
        System.out.print("Nhap ho ten nhan vien can tim: ");
        String hoTen = sc.nextLine();
        String hoTenDuocChuanHoa = chuanHoaChuoi(hoTen);
        System.out.println(hoTen);
        System.out.println("Ho ten chinh xac: [" + hoTenDuocChuanHoa + "]");
        List<NhanVien> dsTraCuu = dsNV.stream().filter(s -> s.getHoTenNV().contains(hoTenDuocChuanHoa) == true).collect(Collectors.toList());
        if (dsTraCuu.isEmpty()) {
            System.out.println("[Error] Khong tim thay nhan vien co thong tin tren trong trong danh sach");
        } else {
            for (NhanVien nv : dsTraCuu) {
                nv.hienThi();
            }
        }
    }

    public void traCuuTheoGioiTinh() {
        boolean flag = true;
        do {
            System.out.print("Nhap gioi tinh nhan vien: ");
            String gioiTinh = sc.nextLine();
            if (kiemTraGioiTinhHopLe(gioiTinh)) {
                List<NhanVien> dsTraCuu = this.dsNV.stream().filter(s -> s.getGioiTinh().equalsIgnoreCase(gioiTinh) == true).collect(Collectors.toList());
                if (dsTraCuu.isEmpty()) {
                    System.out.println("[Error] Khong tim thay nhan vien co thong tin tren trong trong danh sach");
                } else {
                    for (NhanVien nv : dsTraCuu) {
                        nv.hienThi();
                    }
                }
                flag = true;
            } else {
                System.out.println("Nhap sai gioi tinh. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

    }

    public void traCuuTheoQueQuan() {
        System.out.print("Nhap que quan nhan vien: ");
        String queQuan = sc.nextLine();
        String queQuanDuocChuanHoa = chuanHoaChuoi(queQuan);
        List<NhanVien> dsTraCuu = dsNV.stream().filter(s -> s.getQueQuan().contains(queQuanDuocChuanHoa) == true).collect(Collectors.toList());
        if (dsTraCuu.isEmpty()) {
            System.out.println("[Error] Khong tim thay nhan vien co thong tin tren trong trong danh sach");
        } else {
            for (NhanVien nv : dsTraCuu) {
                nv.hienThi();
            }
        }
    }

    public void traCuuTheoNgaySinh() {
        boolean flag = true;
        do {
            System.out.print("Nhap ngay sinh nhan vien(dd-MM-yyyy): ");
            String ngaySinh = sc.nextLine();
            if (kiemTraNgayHopLe(ngaySinh)) {
                List<NhanVien> dsTraCuu = dsNV.stream().filter(s -> s.getNgaySinh().isEqual(LocalDate.parse(ngaySinh, datetimeformat))).collect(Collectors.toList());
                if (dsTraCuu.isEmpty()) {
                    System.out.println("[Error] Khong tim thay nhan vien co thong tin tren trong trong danh sach");
                } else {
                    for (NhanVien nv : dsTraCuu) {
                        nv.hienThi();
                    }
                }
                flag = true;
            } else {
                System.out.println("Ngay sinh khong hop le. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

    }

    public void themThongTinNV() {
        NhanVien nv = new NhanVien();
        String nhapHoTen, nhapGioiTinh, nhapQueQuan, nhapNgaySinh, nhapNgayVaoLam, nhapBoPhan;
        System.out.print("Nhap ho ten nhan vien: ");
        nhapHoTen = sc.nextLine();
        nhapHoTen = chuanHoaChuoi(nhapHoTen);
        nv.setHoTenNV(nhapHoTen);

        do {
            System.out.print("Nhap gioi tinh nhan vien: ");
            nhapGioiTinh = sc.nextLine();
            if (!nhapGioiTinh.equalsIgnoreCase("Nam") && !nhapGioiTinh.equalsIgnoreCase("Nu")) {
                System.out.println("[Error] Chi duoc nhap <Nam> hoac <Nu>. Xin vui long nhap lai!");
            } else {
                nv.setGioiTinh(nhapGioiTinh);
            }
        } while (nv.getGioiTinh() == null);

        System.out.print("Nhap que quan nhan vien: ");
        nhapQueQuan = sc.nextLine();
        nhapQueQuan = chuanHoaChuoi(nhapQueQuan);
        nv.setQueQuan(nhapQueQuan);

        do {
            System.out.print("Nhap ngay sinh cua nhan vien(dd-MM-yyyy): ");
            nhapNgaySinh = sc.nextLine();
            if (kiemTraNgayHopLe(nhapNgaySinh) == true) {
                nv.setNgaySinh(LocalDate.parse(nhapNgaySinh, datetimeformat));
            } else {
                System.out.println("[Error] Nhap sai ngay. Xin vui long nhap lai!");
            }
        } while (nv.getNgaySinh() == null);

        do {
            System.out.print("Nhap ngay vao lam cua nhan vien(dd-MM-yyyy): ");
            nhapNgayVaoLam = sc.nextLine();
            if (kiemTraNgayHopLe(nhapNgayVaoLam) == true) {
                nv.setNgayVaoLam(LocalDate.parse(nhapNgayVaoLam, datetimeformat));
            } else {
                System.out.println("[Error] Nhap sai ngay. Xin vui long nhap lai!");
            }
        } while (nv.getNgayVaoLam() == null);

        do {
            qlbp.xemDSBoPhan();
            System.out.print("Nhap ma bo phan cua nhan vien theo danh sach: ");
            nhapBoPhan = sc.nextLine();
            if (kiemTraMaBoPhan(nhapBoPhan)) {
                nv.setMaBoPhan(Integer.parseInt(nhapBoPhan));
            } else {
                System.out.println("[Error] Nhap sai ma so bo phan. Vui long nhap lai");
            }
        } while (nv.getMaBoPhan() == 0);
        dsNV.add(nv);
    }

    public void xoaThongTinNV() {
        String maSoNVCanXoa;
        int viTriNVCanXoa = -1;
        boolean flag = false;

        do {
            System.out.print("Nhap ma so nhan vien can xoa: ");
            maSoNVCanXoa = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanXoa)) {  //De phong truong hop nhap chuoi
                int index = 0;
                int maSoNVCanXoaKieuSo = Integer.parseInt(maSoNVCanXoa);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaNV() == maSoNVCanXoaKieuSo) {
                        viTriNVCanXoa = index;
                        break;
                    }
                    index++;
                }

                if (viTriNVCanXoa > -1) {
                    dsNV.remove(viTriNVCanXoa);
                    System.out.println("Nhan vien co ma so " + maSoNVCanXoaKieuSo + " da xoa thanh cong");
                } else {
                    System.out.println("Nhan vien co ma so " + maSoNVCanXoaKieuSo + " khong duoc tim thay trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

    }

    public void capNhatMaBoPhan() {
        String maSoNVCanCapNhat;
        boolean flag = true;
        int viTriNVCanCapNhat = -1;
        String maSoBPMoi;
        do {
            System.out.print("Nhap ma so nhan vien can cap nhat ma bo phan: ");
            maSoNVCanCapNhat = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanCapNhat)) {
                int index = 0;
                int maSoNVCanCapNhatKieuSo = Integer.parseInt(maSoNVCanCapNhat);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaBoPhan() == maSoNVCanCapNhatKieuSo) {
                        viTriNVCanCapNhat = index;
                        break;
                    }
                    index++;
                }
                if (viTriNVCanCapNhat > -1) {
                    do {
                        qlbp.xemDSBoPhan();
                        System.out.print("Nhap ma so bo phan moi(chi nhap ma bo phan trong danh sach tren): ");
                        maSoBPMoi = sc.nextLine();
                        if (kiemTraMaBoPhan(maSoBPMoi)) {
                            dsNV.get(viTriNVCanCapNhat).setMaBoPhan(Integer.parseInt(maSoBPMoi));
                            flag = true;
                        } else {
                            System.out.println("Nhap sai ma bo phan. Vui long nhap lai");
                            flag = false;
                        }
                    } while (flag == false);
                } else {
                    System.out.println("Khong tim thay nhan vien co ma so " + maSoNVCanCapNhat + " trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so. Vui long nhap lai");
                flag = false;
            }
        } while (flag == false);

    }

    public void capNhatHoTen() {
        String maSoNVCanCapNhat;
        boolean flag = true;
        int viTriNVCanCapNhat = -1;
        String hoTenMoi;
        do {
            System.out.print("Nhap ma so nhan vien can cap nhat ho ten: ");
            maSoNVCanCapNhat = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanCapNhat)) {
                int index = 0;
                int maSoNVCanCapNhatKieuSo = Integer.parseInt(maSoNVCanCapNhat);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaNV() == maSoNVCanCapNhatKieuSo) {
                        viTriNVCanCapNhat = index;
                        break;
                    }
                    index++;
                }
                if (viTriNVCanCapNhat > -1) {
                    System.out.print("Nhap ho ten moi cua nhan vien: ");
                    hoTenMoi = sc.nextLine();
                    hoTenMoi = chuanHoaChuoi(hoTenMoi);
                    dsNV.get(viTriNVCanCapNhat).setHoTenNV(hoTenMoi);
                    flag = true;
                } else {
                    System.out.println("Khong tim thay nhan vien co ma so " + maSoNVCanCapNhat + " trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);
    }

    public void capNhatNgaySinh() {
        String maSoNVCanCapNhat;
        boolean flag = true;
        int viTriNVCanCapNhat = -1;
        String ngaySinhMoi;
        do {
            System.out.print("Nhap ma so nhan vien can cap nhat ngay vao lam: ");
            maSoNVCanCapNhat = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanCapNhat)) {
                int index = 0;
                int maSoNVCanCapNhatKieuSo = Integer.parseInt(maSoNVCanCapNhat);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaNV() == maSoNVCanCapNhatKieuSo) {
                        viTriNVCanCapNhat = index;
                        break;
                    }
                    index++;
                }
                if (viTriNVCanCapNhat > -1) {
                    do {
                        System.out.print("Nhap ngay sinh moi cua nhan vien: ");
                        ngaySinhMoi = sc.nextLine();
                        if (kiemTraNgayHopLe(ngaySinhMoi)) {
                            LocalDate localdate = LocalDate.parse(ngaySinhMoi, datetimeformat);
                            dsNV.get(viTriNVCanCapNhat).setNgaySinh(localdate);
                            flag = true;
                        } else {
                            System.out.println("Ngay sinh khong hop le. Vui long nhap lai");
                            flag = false;
                        }
                    } while (flag == false);
                } else {
                    System.out.println("Khong tim thay nhan vien co ma so " + maSoNVCanCapNhat + " trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);
    }

    public void capNhatQueQuan() {
        String maSoNVCanCapNhat;
        boolean flag = true;
        int viTriNVCanCapNhat = -1;
        String queQuanMoi;
        do {
            System.out.print("Nhap ma so nhan vien can cap nhat que quan: ");
            maSoNVCanCapNhat = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanCapNhat)) {
                int index = 0;
                int maSoNVCanCapNhatKieuSo = Integer.parseInt(maSoNVCanCapNhat);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaNV() == maSoNVCanCapNhatKieuSo) {
                        viTriNVCanCapNhat = index;
                        break;
                    }
                    index++;
                }
                if (viTriNVCanCapNhat > -1) {
                    System.out.print("Nhap que quan moi cua nhan vien: ");
                    queQuanMoi = sc.nextLine();
                    queQuanMoi = chuanHoaChuoi(queQuanMoi);
                    dsNV.get(viTriNVCanCapNhat).setQueQuan(queQuanMoi);
                } else {
                    System.out.println("Khong tim thay nhan vien co ma so " + maSoNVCanCapNhat + " trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so nhan vien. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);

    }

    public void capNhatGioiTinh() {
        String maSoNVCanCapNhat;
        int viTriNVCanCapNhat = -1;
        String gioiTinhMoi;
        boolean flag = true;

        do {
            System.out.print("Nhap ma so nhan vien can cap nhat: ");
            maSoNVCanCapNhat = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanCapNhat)) {
                int index = 0;
                int maSoNVCanCapNhatKieuSo = Integer.parseInt(maSoNVCanCapNhat);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaNV() == maSoNVCanCapNhatKieuSo) {
                        viTriNVCanCapNhat = index;
                        break;
                    }
                    index++;
                }
                if (viTriNVCanCapNhat > -1) {
                    do {
                        System.out.print("Nhap gioi tinh moi cua nhan vien: ");
                        gioiTinhMoi = sc.nextLine();
                        if (kiemTraGioiTinhHopLe(gioiTinhMoi)) {
                            dsNV.get(viTriNVCanCapNhat).setGioiTinh(gioiTinhMoi);
                            flag = true;
                        } else {
                            System.out.println("Nhap sai gioi tinh. Vui long nhap lai");
                            flag = false;
                        }
                    } while (flag == false);
                } else {
                    System.out.println("Khong tim thay nhan vien co ma so " + maSoNVCanCapNhat + " trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so nhan vien. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);

    }

    public void capNhatNgayVaoLam() {
        String maSoNVCanCapNhat;
        boolean flag = true;
        int viTriNVCanCapNhat = -1;
        String ngayVaoLamMoi;
        do {
            System.out.print("Nhap ma so nhan vien can cap nhat ngay sinh: ");
            maSoNVCanCapNhat = sc.nextLine();
            if (kiemTraChuoiLaSo(maSoNVCanCapNhat)) {
                int index = 0;
                int maSoNVCanCapNhatKieuSo = Integer.parseInt(maSoNVCanCapNhat);
                for (NhanVien nv : dsNV) {
                    if (nv.getMaNV() == maSoNVCanCapNhatKieuSo) {
                        viTriNVCanCapNhat = index;
                        break;
                    }
                    index++;
                }
                if (viTriNVCanCapNhat > -1) {
                    do {
                        System.out.print("Nhap ngay vao lam moi cua nhan vien: ");
                        ngayVaoLamMoi = sc.nextLine();
                        if (kiemTraNgayHopLe(ngayVaoLamMoi)) {
                            LocalDate localdate = LocalDate.parse(ngayVaoLamMoi, datetimeformat);
                            dsNV.get(viTriNVCanCapNhat).setNgayVaoLam(localdate);
                            flag = true;
                        } else {
                            System.out.println("Ngay vao lam khong hop le. Vui long nhap lai");
                            flag = false;
                        }
                    } while (flag == false);
                } else {
                    System.out.println("Khong tim thay nhan vien co ma so " + maSoNVCanCapNhat + " trong danh sach");
                }
                flag = true;
            } else {
                System.out.println("Nhap sai ma so. Vui long nhap lai");
                flag = false;
            }

        } while (flag == false);
    }

    public boolean kiemTraNgayHopLe(String date) {
        try {
            LocalDate localdate = LocalDate.parse(date, datetimeformat);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean kiemTraMaBoPhan(String maBP) {
        try {
            int maSo = Integer.parseInt(maBP);
            for (BoPhan bp : qlbp.getDsBP()) {
                if (bp.getMaBoPhan() == maSo) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean kiemTraChuoiLaSo(String maSo) {
        try {
            int number = Integer.parseInt(maSo);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean kiemTraGioiTinhHopLe(String gioiTinh) {
        if (gioiTinh.equalsIgnoreCase("nam") || gioiTinh.equalsIgnoreCase("nu")) {
            return true;
        }
        return false;
    }

    public String chuanHoaChuoi(String s) {
        String chuoiDuocChuanHoa = " ";
        String tmp = s.trim();
        tmp = tmp.replaceAll("\\s+", " ");
        return tmp;
    }

    public void xemDanhSachNhanVienSinhNhatTrongThangHienTai() {
        LocalDate currentDate = LocalDate.now();
        int thangSinh = currentDate.getMonthValue();
        List<NhanVien> ds = dsNV.stream().filter(nv -> nv.getNgaySinh().getMonthValue() == thangSinh).collect(Collectors.toList());
        if (ds.isEmpty())  {
            System.out.println("Khong co nhan vien sinh trong thang " + thangSinh);
        }

    }

    public void chucNangQuanLyNhanVien() {
        System.out.println("1. Xem danh sach nhan vien");
        System.out.println("2. Tra cuu nhan vien");
        System.out.println("3. Them thong tin nhan vien");
        System.out.println("4. Xoa thong tin nhan vien");
        System.out.println("5. Cap nhat thong tin nhan vien");
        System.out.println("6. Xem danh sach nhan vien sinh theo thang");
    }
}
