    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.FileNameConstant;
import model.MonHoc;
import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import service.MonHocService;

/**
 *
 * @author admin
 */
public class QLMonHocController {
    MonHocService service = new MonHocService(FileNameConstant.MON_HOC);

    public List<MonHoc> getListMH() throws ParseException {
        return service.getAllMonHoc();
    }

    public MonHoc getMH(String maMH) throws ParseException{
        System.out.println(maMH);
        List<MonHoc> lst = service.getAllMonHoc();
        for(MonHoc mh : lst) {
            if(mh.getMaMH().equals(maMH)) {
                System.out.println(mh.getTenMH());
                return mh;
            }
        }
        JOptionPane.showMessageDialog(null, "Môn học học không tồn tại");
        return null;
    }
    
    public boolean themMH(MonHoc mh) throws ParseException {
        List<MonHoc> lst = service.getAllMonHoc();
        for(MonHoc mhs : lst) {
            if(mhs.getMaMH().equals(mh.getMaMH())) {
                JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại\nMôn học này đã tồn tại");
                return false;
            }
        }
        lst.add(mh);
        service.insertList(lst);
        JOptionPane.showMessageDialog(null, "Thêm thành công");
        return true;
    }

    public void xoaMH(String maMH) throws ParseException {
        boolean isOk = true;
        List<MonHoc> lst = service.getAllMonHoc();
        for(MonHoc mhs : lst) {
            if(mhs.getMaMH().equals(maMH)) {
                isOk = false;
            }
        }
        
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xóa thất bại");
        }
        
        service.insertList(lst.stream().filter(item -> !item.getMaMH().equals(maMH)).collect(Collectors.toList()));
        JOptionPane.showMessageDialog(null, "Xóa thành công");
    }

    public boolean suaMH(MonHoc mh) throws ParseException {
        boolean isOk = false;
        List<MonHoc> lst = service.getAllMonHoc();
        for(int i=0; i<lst.size(); i++) {
            if(lst.get(i).getMaMH().equals(mh.getMaMH())) {
                isOk = true;
                lst.set(i, mh);
                break;
            }
        }
        
        if(!isOk) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại\n Môn học này không tồn tại");
            return false;
        }
        service.insertList(lst);
        JOptionPane.showMessageDialog(null, "Sửa thành công");
        return true;
    }

    public MonHoc timKiemByMaMH(String maMH) throws ParseException {
        List<MonHoc> lst = service.getAllMonHoc();
        for(MonHoc mhs : lst) {
            if(mhs.getMaMH().equals(maMH)) {
                return mhs;
            }
        }
        JOptionPane.showMessageDialog(null, "Không có môn học này trong hệ thống");
        return null;
    }
}
