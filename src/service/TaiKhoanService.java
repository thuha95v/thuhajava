/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import util.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.TaiKhoan;

/**
 *
 * @author admin
 */
public class TaiKhoanService {

    private FileService fcl;
    private String fileName;

    public TaiKhoanService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }

    public TaiKhoan getTaiKhoanByIdAndPassword(String id, String matKhau) {
        fcl.openFileToRead();

        List<TaiKhoan> taiKhoans = getAllTaiKhoan();

        for (TaiKhoan item : taiKhoans) {
            if (item.getId().equals(id) && item.getMatKhau().equals(matKhau)) {
                return item;
            }
        }

        fcl.closeFileAfterRead();
        return null;
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        fcl.openFileToRead();
        List<TaiKhoan> list = new ArrayList<>();
        while (fcl.getScanner().hasNext()) {
            String data = fcl.getScanner().nextLine();
            TaiKhoan acc = getTaiKhoanByData(data);
            list.add(acc);
        }
        fcl.closeFileAfterRead();
        return list;
    }

    //String id, String matKhau, String loaiTK
    private TaiKhoan getTaiKhoanByData(String data) {
        String[] datas = StringUtils.split(data);
        return new TaiKhoan(datas[0], datas[1], datas[2]);
    }

    public Boolean insertTaiKhoan(TaiKhoan taiKhoan) {
        try {
            List<TaiKhoan> taiKhoans = getAllTaiKhoan();

            for (TaiKhoan tk : taiKhoans) {
                if (tk.getId().equals(taiKhoan.getId())) {
                    return false;
                }
            }

            taiKhoans.add(taiKhoan);

            insertList(taiKhoans);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void insertList(List<TaiKhoan> taiKhoans) {
        fcl.openFileToWrite();
        for (TaiKhoan acc : taiKhoans) {
            fcl.getPrintWriter().println(acc.getId() + "|" + acc.getMatKhau() + "|" + acc.getLoaiTK());
        }
        fcl.closeFileAfterWrite();
    }

}
