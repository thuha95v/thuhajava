/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import constant.FileNameConstant;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.*;
import service.*;

/**
 *
 * @author admin
 */
public class InsertDefaultData {

    public void themTK() {
        TaiKhoanService service = new TaiKhoanService(FileNameConstant.TAI_KHOAN);
        List<TaiKhoan> taiKhoans = new ArrayList<>();
        taiKhoans.add(new TaiKhoan("sv001", "123", "Sinh viên"));
        taiKhoans.add(new TaiKhoan("sv002", "123", "Sinh viên"));
        taiKhoans.add(new TaiKhoan("sv003", "123", "Sinh viên"));
        taiKhoans.add(new TaiKhoan("sv004", "123", "Sinh viên"));
        taiKhoans.add(new TaiKhoan("sv005", "123", "Sinh viên"));
        taiKhoans.add(new TaiKhoan("gv001", "123", "Giảng viên"));
        taiKhoans.add(new TaiKhoan("gv002", "123", "Giảng viên"));
        taiKhoans.add(new TaiKhoan("gv003", "123", "Giảng viên"));
        taiKhoans.add(new TaiKhoan("gv004", "123", "Giảng viên"));
        taiKhoans.add(new TaiKhoan("gv005", "123", "Giảng viên"));
        taiKhoans.add(new TaiKhoan("qtv01", "123", "Quản trị viên"));
        taiKhoans.add(new TaiKhoan("qtv02", "123", "Quản trị viên"));
        taiKhoans.add(new TaiKhoan("qtv03", "123", "Quản trị viên"));
        taiKhoans.add(new TaiKhoan("qtv04", "123", "Quản trị viên"));
        taiKhoans.add(new TaiKhoan("qtv05", "123", "Quản trị viên"));
        
        service.insertList(taiKhoans);
    }

    public void themSV() {
        SinhVienService service = new SinhVienService(FileNameConstant.SINH_VIEN);
        List<SinhVien> lst = new ArrayList<>();
        //String maSV, String tenSV, String lop, String soDT, String diaChi, String email, String id
        lst.add(new SinhVien("SV001", "Nguyễn Hữu Quyết", "HTTT02-K14", "0123111001", "Nam Định", "quyenminhhai1608@gmail.com", "sv001"));
        lst.add(new SinhVien("SV002", "Lê Văn Tài", "HTTT02-K14", "0123111002", "Bắc Ninh", "khiemvn@gmail.com", "sv002"));
        lst.add(new SinhVien("SV003", "Nguyễn Thị Thuỷ", "HTTT02-K14", "0123111003", "Nam Định", "tuannv@gmail.com", "sv003"));
        lst.add(new SinhVien("SV004", "Nguyễn Thị Thu Hà", "HTTT02-K14", "0123111004", "Vĩnh Phúc", "namnd@gmail.com", "sv004"));
        lst.add(new SinhVien("SV005", "Lê Mạnh Cường", "HTTT02-K14", "0123111005", "Vĩnh Phúc", "cuonglm@gmail.com", "sv005"));
        
        service.insertList(lst);
    }

    public void themGV() {
        //GiangVien(String maGV, String tenGV, String khoa, String soDT, String email, String id)
        GiangVienService service = new GiangVienService(FileNameConstant.GIANG_VIEN);
        List<GiangVien> lst = new ArrayList<>();
        
        lst.add(new GiangVien("GV001", "Vũ Thị Dương", "CNTT", "0123222001", "duongvt@gmail.com", "gv001"));
        lst.add(new GiangVien("GV002", "Trần Phương Nhung", "CNTT", "0123222002", "nhungtp@gmail.com", "gv002"));
        lst.add(new GiangVien("GV003", "Hà Mạnh Đào", "CNTT", "0123222003", "daohm@gmail.com", "gv003"));
        
        service.insertList(lst);
    }

    public void themQTV() {
        //QuanTriVien(String maQTV, String tenQTV, String id)
        QuanTriVienService service = new QuanTriVienService(FileNameConstant.QUAN_TRI_VIEN);
        List<QuanTriVien> lst = new ArrayList<>();
        
        lst.add(new QuanTriVien("QTV01", "Nguyễn Văn A", "qtv01"));
        lst.add(new QuanTriVien("QTV02", "Nguyễn Văn B", "qtv02"));
        lst.add(new QuanTriVien("QTV03", "Nguyễn Văn C", "qtv03"));
        lst.add(new QuanTriVien("QTV04", "Nguyễn Văn D", "qtv04"));
        lst.add(new QuanTriVien("QTV05", "Nguyễn Văn E", "qtv05"));
        
        service.insertList(lst);
    }

    public void themMH() {
        MonHocService service = new MonHocService(FileNameConstant.MON_HOC);
        List<MonHoc> lst = new ArrayList<>();
        
        //MonHoc(String maMH, String tenMH, int soTinChi)
        lst.add(new MonHoc("MH001", "Lập trình Java", 4));
        lst.add(new MonHoc("MH002", "Lập trình C++", 3));
        lst.add(new MonHoc("MH003", "Lập trình C#", 4));
        lst.add(new MonHoc("MH004", "Hệ quản trị cơ sở dữ liệu", 3));
        lst.add(new MonHoc("MH005", "Phân tích thiết kế hệ thống", 3));
        lst.add(new MonHoc("MH006", "Thiết kế CSDL", 3));
        
        service.insertList(lst);
    }

    public void themPH() {
        PhongHocService service = new PhongHocService(FileNameConstant.PHONG_HOC);
        List<PhongHoc> lst = new ArrayList<>();
        //PhongHoc(String maPH, String tenPH, String dienTich)
        lst.add(new PhongHoc("PH001", "P302 A9", "Vừa"));
        lst.add(new PhongHoc("PH002", "P301 A9", "Vừa"));
        lst.add(new PhongHoc("PH003", "P307 A9", "Nhỏ"));
        lst.add(new PhongHoc("PH004", "PM1 A1", "To"));
        lst.add(new PhongHoc("PH005", "PM2 A1", "To"));
        lst.add(new PhongHoc("PH006", "PM3 A1", "Vừa"));
        
        service.insertList(lst);
    }

    public void themLH() throws ParseException {
        LopHocService service = new LopHocService(FileNameConstant.LOP_HOC);
        List<LopHoc> lst = new ArrayList<>();
        
        //LopHoc(String maLH, String tenLH, String ngayBatDau, String thu,String tiet, int siSo, String maMH, String maPH)
        lst.add(new LopHoc("LH001", "Java 1", "14/06/2022", "Th 2", "13,14,15,16", 75, "MH001", "PH004"));
        lst.add(new LopHoc("LH002", "Java 2", "17/06/2022", "Th 5", "13,14,15,16", 75, "MH001", "PH005"));
        lst.add(new LopHoc("LH003", "C++ 1", "15/06/2022", "Th 3", "13,14,15,16", 75, "MH002", "PH006"));
        lst.add(new LopHoc("LH004", "C# 1", "16/06/2022", "Th 4", "13,14,15,16", 75, "MH003", "PH005"));
        lst.add(new LopHoc("LH005", "SQL 1", "17/06/2022", "Th 5", "13,14,15,16", 75, "MH004", "PH003"));
        lst.add(new LopHoc("LH006", "PTTKHT 1", "18/06/2022", "Th 6", "13,14,15,16", 75, "MH005", "PH001"));
        lst.add(new LopHoc("LH007", "TKCSDL 1", "19/06/2022", "Th 7", "13,14,15,16", 75, "MH006", "PH001"));
        
        service.insertList(lst);
    }

    public void themSVDangKy() {
        SVDangKyService service = new SVDangKyService(FileNameConstant.SV_DANG_KY);
        List<SVDangKy> lst = new ArrayList<>();
        
        //SVDangKy(String maSV, String maLH)
        lst.add(new SVDangKy("sv001", "LH001"));
        lst.add(new SVDangKy("sv001", "LH002"));
        lst.add(new SVDangKy("sv001", "LH003"));
        lst.add(new SVDangKy("sv001", "LH004"));
        lst.add(new SVDangKy("sv001", "LH005"));
        lst.add(new SVDangKy("sv001", "LH006"));
        lst.add(new SVDangKy("sv001", "LH007"));
        lst.add(new SVDangKy("sv002", "LH002"));
        lst.add(new SVDangKy("sv003", "LH003"));
        lst.add(new SVDangKy("sv004", "LH004"));
        lst.add(new SVDangKy("sv002", "LH006"));
        lst.add(new SVDangKy("SV003", "LH007"));
        
        service.insertList(lst);   
    }

    public void themGVDangKy() {
        GVDangKyService service = new GVDangKyService(FileNameConstant.GV_DANG_KY);
        List<GVDangKy> lst = new ArrayList<>();
        
        //GVDangKy(String maGV, String maLH)
        lst.add(new GVDangKy("GV001", "LH001"));
        lst.add(new GVDangKy("GV001", "LH002"));
        lst.add(new GVDangKy("GV002", "LH003"));
        lst.add(new GVDangKy("GV003", "LH004"));
        lst.add(new GVDangKy("GV002", "LH005"));
        lst.add(new GVDangKy("GV003", "LH006"));
        lst.add(new GVDangKy("GV003", "LH007"));
        
        service.insertList(lst);   
    }
}
