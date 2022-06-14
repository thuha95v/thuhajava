/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.LopHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import service.LopHocService;

/**
 *
 * @author Minh Hai
 */
public class QLLopHocController {

    LopHocService service = new LopHocService(FileNameConstant.LOP_HOC);

    public List<LopHoc> getListLH() throws ParseException {
        return service.getAllLopHoc();
    }

    public LopHoc getLH(String maLH) throws ParseException {
        List<LopHoc> lst = service.getAllLopHoc();
        for(LopHoc item : lst) {
            if(item.getMaLH().equals(maLH)) {
                return item;
            }
        }
        JOptionPane.showMessageDialog(null, "Lớp học không tồn tại");
        return null;
    }

    public boolean themLH(LopHoc lh) throws ParseException {
        List<LopHoc> lst = service.getAllLopHoc();
        boolean isOk = true;
        for(LopHoc item : lst) {
            if(item.getMaLH().equals(lh.getMaLH())) {
                isOk = false;
            }
        }
        
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nLớp học này đã tồn tại");
            return false;
        }
        lst.add(lh);
        service.insertList(lst);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        return true;
    }

    public void xoaLH(String maLH) throws ParseException {
        List<LopHoc> lst = service.getAllLopHoc();
        boolean isOk = false;
        for(LopHoc item : lst) {
            if(item.getMaLH().equals(maLH)) {
                isOk = true;
            }
        }
        
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            return;
        }
        
        service.insertList(lst.stream().filter(item -> !item.getMaLH().equals(maLH)).collect(Collectors.toList()));
        JOptionPane.showMessageDialog(null, "Xóa thành công");
    }

    public boolean suaLH(LopHoc lh) throws ParseException {
        List<LopHoc> lst = service.getAllLopHoc();
        boolean isOk = false;
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getMaLH().equals(lh.getMaLH())) {
                isOk = true;
                lst.set(i, lh);
                break;
            }
        }
        
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            return false;
        }
        
        service.insertList(lst);
        return true;
    }

    public LopHoc timKiemByMaLH(String maLH) throws ParseException {
        return getLH(maLH);
    }

    public List<LopHoc> timKiemByMaMH(String maMH) throws ParseException {
        List<LopHoc> lstLopHoc = service.getAllLopHoc();
        
        List<LopHoc> output = lstLopHoc.stream().filter(item -> item.getMaMH().equals(maMH)).collect(Collectors.toList());
        if(output.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học");
        }
        
        return output;
    }
}
