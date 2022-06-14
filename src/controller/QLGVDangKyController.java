/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.LopHoc;
import model.GVDangKy;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.GiangVien;
import service.GVDangKyService;
import service.GiangVienService;
import service.LopHocService;

/**
 *
 * @author admin
 */
public class QLGVDangKyController {

    private GVDangKyService gvDangKyService = new GVDangKyService(FileNameConstant.GV_DANG_KY);
    private LopHocService lopHocService = new LopHocService(FileNameConstant.LOP_HOC);
    private GiangVienService giangVienService = new GiangVienService(FileNameConstant.GIANG_VIEN);
    
    public List<GVDangKy> getListLopHocTatCaGVDangKy() {
        List<GVDangKy> listGVDK = new ArrayList<>();
        try {
            listGVDK = gvDangKyService.getAllGVDangKy();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        return listGVDK;
    }

    public List<LopHoc> getListLopHoc1GVDangKy(String maGV) throws ParseException {
        List<LopHoc> lstLH = lopHocService.getAllLopHoc();
        List<LopHoc> output = new ArrayList<>();
        List<GVDangKy> lstGVDangKy = gvDangKyService.getAllGVDangKy();
        List<GVDangKy> temp = new ArrayList<>();
        
        for(GVDangKy gvDK : lstGVDangKy) {
            if(gvDK.getMaGV().equals(maGV)) {
                temp.add(gvDK);
            }
        }
        
        if(temp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        
        for(LopHoc lh : lstLH) {
            for(GVDangKy gvDK : temp) {
                if(lh.getMaLH().equals(gvDK.getMaLH())) {
                    output.add(lh);
                }
            }
        }
        
        return output;
    }

    public List<GiangVien> getListGVDangKy1LopHoc(String maLH) {
        List<GiangVien> lstGiangVien = giangVienService.getAllGiangVien();
        List<GiangVien> output = new ArrayList<>();
        List<GVDangKy> lstGVDangKy = gvDangKyService.getAllGVDangKy();
        List<GVDangKy> temp = new ArrayList<>();
        
        for(GVDangKy gvDK : lstGVDangKy) {
            if(gvDK.getMaLH().equals(maLH)) {
                temp.add(gvDK);
            }
        }
        
        for(GiangVien gv : lstGiangVien) {
            for(GVDangKy gvDK : temp) {
                if(gv.getMaGV().equals(gvDK.getMaGV())) {
                    output.add(gv);
                }
            }
        }
        
        if(output.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lớp học không tồn tại hoặc không có giảng viên nào đã đăng ký ");
        }
        return output;
    }

    public boolean dangKyLopHocGV(String maGV, String maLH) {
        List<GVDangKy> lst = gvDangKyService.getAllGVDangKy();
        for(GVDangKy gvDK : lst) {
            if(gvDK.getMaGV().equals(maGV) && gvDK.getMaLH().equals(maLH)) {
                JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
                return false;
            }
        }
        lst.add(new GVDangKy(maGV, maLH));
        gvDangKyService.insertList(lst);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        return true;
    }

    public boolean xoaLopHocGV(String maGV, String maLH) {
        boolean isOk = false;
        List<GVDangKy> lst = gvDangKyService.getAllGVDangKy();
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getMaGV().equals(maGV) && lst.get(i).getMaLH().equals(maLH)) {
                isOk = true;
                lst.remove(i);
            }
        }
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            return false;
        }
        
        gvDangKyService.insertList(lst);
        return true;
    }

    public GVDangKy timKiemLopHocGVDaDangKy(String maLH) throws ParseException {
        
        List<LopHoc> lopHocs = lopHocService.getAllLopHoc();
        List<GVDangKy> gvDangKy = gvDangKyService.getAllGVDangKy();
        for(LopHoc lh : lopHocs) {
            if(lh.getMaLH().equals(maLH)) {
                for(GVDangKy gv : gvDangKy) {
                    if(gv.getMaLH().equals(lh.getMaLH())) {
                        return gv;
                    }
                }
            }
        }
        
        return null;
   
        
    }
}
