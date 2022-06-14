/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.QuanTriVien;
import util.StringUtils;

/**
 *
 * @author admin
 */
public class QuanTriVienService {

    private FileService fcl;
    private String fileName;

    public QuanTriVienService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }

    public QuanTriVienService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //QuanTriVien(String maQTV, String tenQTV, String id)
    public List<QuanTriVien> getAllQuanTriVien() {
        fcl.openFileToRead();
        List<QuanTriVien> output = new ArrayList<>();

        while (fcl.getScanner().hasNext()) {
            String data = fcl.getScanner().nextLine();
            QuanTriVien sv = getQuanTriVienByData(data);
            output.add(sv);
        }

        fcl.closeFileAfterRead();
        return output;
    }

    public QuanTriVien getQuanTriVienByData(String data) {
        String[] datas = StringUtils.split(data);
        return new QuanTriVien(datas[0], datas[1], datas[2]);
    }

    public void insertList(List<QuanTriVien> quanTriViens) {
        fcl.openFileToWrite();

        for (QuanTriVien qtv : quanTriViens) {
            fcl.getPrintWriter().println(qtv.getMaQTV() + "|" + qtv.getTenQTV() + "|" + qtv.getId());
        }
        fcl.closeFileAfterWrite();
    }

}
