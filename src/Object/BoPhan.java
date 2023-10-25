/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

/**
 *
 * @author ASUS
 */
public class BoPhan {
    private String tenBoPhan;
    private static int maSoHienTai;
    private int maBoPhan = ++maSoHienTai;

    /**
     * @return the tenBoPhan
     */
    public String getTenBoPhan() {
        return tenBoPhan;
    }

    /**
     * @param tenBoPhan the tenBoPhan to set
     */
    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
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
    
    public BoPhan(String tenBP) {
        this.tenBoPhan = tenBP;
    }
    public void hienThi() {
        System.out.printf("%-5d %s\n", this.maBoPhan, this.tenBoPhan);
    }
}
