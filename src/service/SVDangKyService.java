/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.SVDangKy;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class SVDangKyService {
     private FileService fcl;
    private String fileName;
    
    public SVDangKyService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }
    
    //SVDangKy(String maSV, String maLH)
    public List<SVDangKy> getAllSVDangKy() {
        fcl.openFileToRead();
        List<SVDangKy> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){
            String data = fcl.getScanner().nextLine();
            SVDangKy sv = getSVDangKyByData(data);
            output.add(sv);
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    
    public SVDangKy getSVDangKyByData(String data) {
        String[] datas = StringUtils.split(data);
        return new SVDangKy(datas[0],datas[1]);
    }

    public void insertList(List<SVDangKy> lst) {
        fcl.openFileToWrite();
        
        for(SVDangKy svDangKy : lst){
            fcl.getPrintWriter().println(svDangKy.getMaSV()+ "|" + svDangKy.getMaLH());
        }
        fcl.closeFileAfterWrite();
    }


}
