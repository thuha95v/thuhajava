/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.SinhVien;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import service.SinhVienService;

/**
 *
 * @author admin
 */
public class QLSinhVienController {

    private SinhVienService sinhVienService = new SinhVienService(FileNameConstant.SINH_VIEN);

    public List<SinhVien> getListSV() {
        return sinhVienService.getAllSinhVien();
    }

    public SinhVien getSVById(String id) {
        List<SinhVien> lstSV = getListSV();
        for(SinhVien item : lstSV) {
            if(item.getId().equals(id)) {
                return item;
            }
        }
        JOptionPane.showMessageDialog(null, "Sinh viên không tồn tại\nHãy nhập đúng ID");
        return null;
    }
    
    public SinhVien getSVByMaSV(String maSV) {
        List<SinhVien> lstSV = getListSV();
        for(SinhVien item : lstSV) {
            if(item.getMaSV().equals(maSV)) {
                return item;
            }
        }
        JOptionPane.showMessageDialog(null, "Sinh viên không tồn tại\nHãy nhập đúng mã sinh viên");
        return null;
    }

    public void xoaSV(String id) {
        SinhVien sv = getSVById(id);
        if(sv != null) {
            List<SinhVien> lst = getListSV().stream()                
                .filter(item -> !item.getId().equals(id))     
                .collect(Collectors.toList());
            sinhVienService.insertList(lst);
        } 
    }

    public void suaSV(SinhVien sv) {
        List<SinhVien> lst = getListSV();
        boolean isOk = false;
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getMaSV().equals(sv.getMaSV())) {
                lst.set(i, sv);
                isOk = true;
                break;
            }
        }
        
        if(isOk) {
            sinhVienService.insertList(lst);
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại\nHãy nhập đúng mã sinh viên");
        }
    }

    public SinhVien timKiemByMaSV(String maSV) {
        List<SinhVien> lst = getListSV();
        for(SinhVien sv : lst) {
            if(sv.getMaSV().equals(maSV)) {
                return sv;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Không có sinh viên này trong hệ thống");
        return null;
    }

    public void themSV(SinhVien sv) {
        boolean isOk = true;
        List<SinhVien> lst = getListSV();
        for(SinhVien item : lst) {
            if(item.getMaSV().equals(sv.getMaSV())) {
                isOk = false;
                break;
            }
        }
        
        if(isOk) {
            lst.add(sv);
            sinhVienService.insertList(lst);
        } else {
            JOptionPane.showMessageDialog(null, "Đã tồn tại mã sinh viên: " + sv.getMaSV());
        }
    }

}
