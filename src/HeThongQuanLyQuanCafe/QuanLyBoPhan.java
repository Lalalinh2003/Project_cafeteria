/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HeThongQuanLyQuanCafe;

import Object.BoPhan;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class QuanLyBoPhan {
    private ArrayList<BoPhan> dsBP = new ArrayList<>();
    
    public void themDSBoPhan(BoPhan ...bp) {
        this.dsBP.addAll(Arrays.asList(bp));
    }
    
    public void xemDSBoPhan() {
        this.dsBP.forEach((bp) -> bp.hienThi());
    }

    /**
     * @return the dsBP
     */
    public ArrayList<BoPhan> getDsBP() {
        return dsBP;
    }

    /**
     * @param dsBP the dsBP to set
     */
    public void setDsBP(ArrayList<BoPhan> dsBP) {
        this.dsBP = dsBP;
    }
}
