/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.LopHoc;
import model.SVDangKy;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import model.SinhVien;
import service.LopHocService;
import service.SVDangKyService;
import service.SinhVienService;

/**
 *
 * @author admin
 */
public class QLSVDangKyController {
    private SVDangKyService svDangKyService = new SVDangKyService(FileNameConstant.SV_DANG_KY);
    private SinhVienService sinhVienService = new SinhVienService(FileNameConstant.SINH_VIEN);
    private LopHocService lopHocService = new LopHocService(FileNameConstant.LOP_HOC);
    
    public List<SVDangKy> getListLopHocTatCaSVDangKy() {
        List<SVDangKy> listSVDK = svDangKyService.getAllSVDangKy();
        
        if(listSVDK.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        
        return listSVDK;
    }

    public List<LopHoc> getListLopHoc1SVDangKy(String maSV) throws ParseException {
        List<LopHoc> lstLH = lopHocService.getAllLopHoc();
        List<SVDangKy> lstSVDangKy = svDangKyService.getAllSVDangKy();
        
        List<SVDangKy> temp = new ArrayList<>();
        for(SVDangKy svDangKy : lstSVDangKy) {
            if(svDangKy.getMaSV().equals(maSV)) {
                temp.add(svDangKy);
            }
        }
        
        List<String> maLH = temp.stream().map(item -> item.getMaLH()).collect(Collectors.toList());
        
        List<LopHoc> output = new ArrayList<>();
        System.out.println(lstLH.size());
        System.out.println(lstSVDangKy.size());
        System.out.println(temp.size());
        for(LopHoc lopHoc : lstLH) {
            for(SVDangKy svDangKy : temp) {
                System.out.println(svDangKy.getMaLH() + " - " + lopHoc.getMaLH());
                if(svDangKy.getMaLH().equals(lopHoc.getMaLH())) {
                    output.add(lopHoc);
                }
            }
        }
        
        if(output.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách lớp học đã đăng ký");
        }
        
        return output;
    }

    public List<SinhVien> getListSVDangKy1LopHoc(String maLH) {
        List<SVDangKy> lstSVDangKy = svDangKyService.getAllSVDangKy();
        List<SinhVien> listSV = sinhVienService.getAllSinhVien();
        
        List<SinhVien> lstSinhVien = new ArrayList<>();
        
        List<SVDangKy> temp = new ArrayList<>();
        for(SVDangKy svDangKy : lstSVDangKy) {
            if(svDangKy.getMaLH().equals(maLH)) {
                temp.add(svDangKy);
            }
        }
        
        List<SinhVien> output = new ArrayList<>();
        for(SinhVien sinhVien : listSV) {
            for(SVDangKy svDangKy : temp) {
                if(svDangKy.getMaSV().equals(sinhVien.getMaSV())) {
                    output.add(sinhVien);
                }
            }
        }
        if(output.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Lớp học không tồn tại hoặc không có sinh viên nào đã đăng ký ");
        }
        
        return output;
    }

    public boolean dangKyLopHocSV(String maSV, String maLH) {
        try {
            List<SVDangKy> svDangKy = svDangKyService.getAllSVDangKy();
            svDangKy.add(new SVDangKy(maSV, maLH));

            svDangKyService.insertList(svDangKy);
            
            JOptionPane.showMessageDialog(null, "Đăng ký thành công");
            return true;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi. Đăng ký thất bại\nCó thể lớp học này đã được đăng ký");
            return false;
        }
    }

    public boolean xoaLopHocSV(String maSV, String maLH) {
         try {
            List<SVDangKy> svDangKy = svDangKyService.getAllSVDangKy();
            svDangKyService.insertList(
                    svDangKy
                            .stream()
                            .filter(item -> !item.getMaLH().equals(maLH) || !item.getMaSV().equals(maSV))
                            .collect(Collectors.toList())
            );
            
            JOptionPane.showMessageDialog(null, "Xóa thành công");
            return true;
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
            return false;
        }
    }

    public LopHoc timKiemLopHocSV(String maSV, String maLH) throws ParseException {
        List<LopHoc> lstLopHoc = lopHocService.getAllLopHoc();
        List<SVDangKy> lstSVDangKy = svDangKyService.getAllSVDangKy();
        
        for(SVDangKy item : lstSVDangKy) {
            if(item.getMaLH().equals(maLH) && item.getMaSV().equals(maSV)) {
                for(LopHoc lh : lstLopHoc) {
                    if(lh.getMaLH().equals(item.getMaLH())) {
                        return lh;
                    }
                }
            }
        }
        
        JOptionPane.showMessageDialog(null, "Lớp học này chưa được đăng ký");
        return null;
    }
}
