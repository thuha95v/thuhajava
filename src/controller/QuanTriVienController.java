/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.QuanTriVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import service.QuanTriVienService;

/**
 *
 * @author admin
 */
public class QuanTriVienController {
    QuanTriVienService quanTriVienService = new QuanTriVienService(FileNameConstant.QUAN_TRI_VIEN);

    public QuanTriVien getQTV(String id) {
        List<QuanTriVien> lst = quanTriVienService.getAllQuanTriVien();
        for(QuanTriVien item : lst) {
            if(item.getId().equals(id)) {
                return item;
            }
        }
       
        JOptionPane.showMessageDialog(null, "Không tồn tại quản trị viên");
        return null;
    }
    
    public void suaQTV(QuanTriVien qtv){
        boolean isOk = false;
        List<QuanTriVien> lst = quanTriVienService.getAllQuanTriVien();
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getMaQTV().equals(qtv.getMaQTV())) {
                lst.get(i).setMaQTV(qtv.getMaQTV());
                lst.get(i).setTenQTV(qtv.getTenQTV());
                isOk = true;
                break;
            }
        }
        
        quanTriVienService.insertList(lst);
        
        if(isOk) {
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } else {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
        }
    }
}