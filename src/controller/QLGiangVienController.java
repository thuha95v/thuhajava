/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.GiangVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import service.GiangVienService;

/**
 *
 * @author Minh Hai
 */
public class QLGiangVienController {
    private GiangVienService service = new GiangVienService(FileNameConstant.GIANG_VIEN);

    public List<GiangVien> getListGV() {
       return service.getAllGiangVien();
    }

    public GiangVien getGVById(String id){
        List<GiangVien> lst = service.getAllGiangVien();
        for(GiangVien gv : lst) {
            if(gv.getId().equals(id)) {
                return gv;
            }
        }
        JOptionPane.showMessageDialog(null, "Giảng viên không tồn tại\nHãy nhập đúng ID");
        return null;
    }
    
    public GiangVien getGVByMaGV(String maGV){
        List<GiangVien> lst = service.getAllGiangVien();
        for(GiangVien gv : lst) {
            if(gv.getMaGV().equals(maGV)) {
                return gv;
            }
        }
        JOptionPane.showMessageDialog(null, "Giảng viên không tồn tại\nHãy nhập đúng mã giảng viên");
        return null;
    }
    
    public boolean themGV(GiangVien record) {
        List<GiangVien> lst = service.getAllGiangVien();
        boolean isOk = true;
        for(GiangVien gv : lst) {
            if(gv.getMaGV().equals(record.getMaGV())) {
                isOk = false;
                break;
            }
        }
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nMã giảng viên không hợp lệ");
            return false;
        }
        lst.add(record);
        service.insertList(lst);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        return true;
    }

    public void xoaGV(String id) {
        List<GiangVien> lst = service.getAllGiangVien();
        boolean isOk = false;
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getId().equals(id)) {
                isOk = true;
                lst.remove(i);
                break;
            }
        }
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            return;
        }
        
        service.insertList(lst);
        
        JOptionPane.showMessageDialog(null, "Xóa thành công");
    }

    public boolean suaGV(GiangVien gv) {
        List<GiangVien> lst = service.getAllGiangVien();
        boolean isOk = false;
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getMaGV().equals(gv.getMaGV())) {
                isOk = true;
                lst.set(i, gv);
                break;
            }
        }
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            return false;
        }
        service.insertList(lst);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
        return true;
    }

    public GiangVien timKiemByMaGV(String maGV) {
        List<GiangVien> lst = service.getAllGiangVien();
        for(GiangVien gv : lst) {
            if(gv.getMaGV().equals(maGV)) {
                return gv;
            }
        }
        JOptionPane.showMessageDialog(null, "Không có giảng viên này trong hệ thống");
        return null;
    }
}
