/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.TaiKhoan;
import java.util.List;
import javax.swing.JOptionPane;
import service.TaiKhoanService;

/**
 *
 * @author admin
 */
public class TaiKhoanController {
    
    TaiKhoanService taiKhoanService;
    
    public TaiKhoanController() {
        this.taiKhoanService = new TaiKhoanService(FileNameConstant.TAI_KHOAN);
    }
    
    public TaiKhoan checkTK(String id, String matKhau){
        return taiKhoanService.getTaiKhoanByIdAndPassword(id, matKhau);
    }
    
    public List<TaiKhoan> getListTK() {
        List<TaiKhoan> taiKhoans = taiKhoanService.getAllTaiKhoan();
        if(taiKhoans.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không có tài khoản nào tồn tại");
        }
        return taiKhoans;
    }
    
    public boolean themTK (TaiKhoan tk){
        boolean isOk = taiKhoanService.insertTaiKhoan(tk);
        if(isOk) {
            JOptionPane.showMessageDialog(null, "Tạo thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi. Tạo thất bại\nCó thể tài khoản đã tồn tại");
        }
        return isOk;
    }
}
