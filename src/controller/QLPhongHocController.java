/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.PhongHoc;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import service.PhongHocService;

/**
 *
 * @author admin
 */
public class QLPhongHocController {
    private PhongHocService service = new PhongHocService(FileNameConstant.PHONG_HOC);

    public List<PhongHoc> getListPH() {
        return service.getAllPhongHoc();
    }

    public PhongHoc getPH(String maPH){
        List<PhongHoc> phongHocs = service.getAllPhongHoc();
        for(PhongHoc ph : phongHocs) {
            if(ph.getMaPH().equals(maPH)) {
                return ph;
            }
        }
        JOptionPane.showMessageDialog(null, "Phòng học không tồn tại");
        return null;
    }
    
    public boolean themPH(PhongHoc ph) {
        List<PhongHoc> phongHocs = service.getAllPhongHoc();
        for(PhongHoc phs : phongHocs){
            if(phs.getMaPH().equals(ph.getMaPH())) {
                JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nPhòng học này đã tồn tại");
                return false;
            }
        }
        phongHocs.add(ph);
        service.insertList(phongHocs);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        return true;
    }

    public void xoaPH(String maPH) {
        try {
            List<PhongHoc> phongHocs = service.getAllPhongHoc();
        
            service.insertList(phongHocs.stream().filter(item -> item.getMaPH().equals(maPH)).collect(Collectors.toList()));   
            JOptionPane.showMessageDialog(null, "Xóa thành công");
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
        }
    }

    public void suaPH(PhongHoc ph) {
        try {
            List<PhongHoc> phongHocs = service.getAllPhongHoc();
        
            for(int i=0; i<phongHocs.size(); i++) {
                if(phongHocs.get(i).getMaPH().equals(ph.getMaPH())) {
                    phongHocs.set(i, ph);
                    break;
                }
            }
            service.insertList(phongHocs);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        }catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
        }
    }

    public PhongHoc timKiemByMaPH(String maPH) {
        List<PhongHoc> phongHocs = service.getAllPhongHoc();
        
        for(int i=0; i<phongHocs.size(); i++) {
            if(phongHocs.get(i).getMaPH().equals(maPH)) {
                return phongHocs.get(i);
            }
        }
        JOptionPane.showMessageDialog(null, "Không có phòng học này trong hệ thống");
        return null;
    }
}
