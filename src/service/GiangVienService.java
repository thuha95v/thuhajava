/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.GiangVien;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class GiangVienService {
        private FileService fcl;
    private String fileName;
    
    public GiangVienService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }
    
    //GiangVien(String maGV, String tenGV, String khoa, String soDT, String email, String id)
    public List<GiangVien> getAllGiangVien() {
        fcl.openFileToRead();
        List<GiangVien> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){
            String data = fcl.getScanner().nextLine();
            output.add(getGiangVienByData(data));
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    
    public GiangVien getGiangVienByData(String data) {
        String[] datas = StringUtils.split(data);
        return new GiangVien(datas[0],datas[1],datas[2],datas[3],datas[4], datas[5]);
    }

    public void insertList(List<GiangVien> giangViens) {
        fcl.openFileToWrite();
        
        for(GiangVien gv : giangViens){
            fcl.getPrintWriter().println(
                    gv.getMaGV()+ "|" 
                    + gv.getTenGV()+ "|" 
                    + gv.getKhoa()+ "|" 
                    + gv.getSoDT()+ "|" 
                    + gv.getEmail()+ "|" 
                    + gv.getId()
            );
        }
        fcl.closeFileAfterWrite();
    }
}
