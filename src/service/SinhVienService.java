/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class SinhVienService {
    private FileService fcl;
    private String fileName;
    
    public SinhVienService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }

    public List<SinhVien> getAllSinhVien() {
        fcl.openFileToRead();
        List<SinhVien> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){ //true
            //SV001|Quyền Minh Hải|CNTT06-K13|0123111001|Nam Định|quyenminhhai1608@gmail.com|sv001
            String data = fcl.getScanner().nextLine();
            output.add(getSinhVienByData(data));
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    
    public SinhVien getSinhVienByData(String data) {
        String[] datas = StringUtils.split(data);
        return new SinhVien(datas[0],datas[1],datas[2],datas[3],datas[4],datas[5],datas[6]);
    }
    
    //String maSV, String tenSV, String lop, String soDT, String diaChi, String email, String id
    public void insertList(List<SinhVien> sinhViens) {
        fcl.openFileToWrite();
        
        for(SinhVien sv : sinhViens){
            fcl.getPrintWriter().println(
                    sv.getMaSV()+ "|" + sv.getTenSV()+ "|" + sv.getLop()+ "|" 
                            + sv.getSoDT()+ "|" + sv.getDiaChi()+ "|" 
                            + sv.getEmail() + "|" + sv.getId());
        }
        
        fcl.closeFileAfterWrite();
    }
    
}
