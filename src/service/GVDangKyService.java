/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.GVDangKy;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class GVDangKyService {
     private FileService fcl;
    private String fileName;
    
    public GVDangKyService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }
    
    //GVDangKy(String maGV, String maLH)
    public List<GVDangKy> getAllGVDangKy() {
        fcl.openFileToRead();
        List<GVDangKy> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){
            String data = fcl.getScanner().nextLine();
            output.add(getGVDangKyByData(data));
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    
    public GVDangKy getGVDangKyByData(String data) {
        String[] datas = StringUtils.split(data);
        return new GVDangKy(datas[0],datas[1]);
    }

    public void insertList(List<GVDangKy> lst) {
        fcl.openFileToWrite();
        
        for(GVDangKy gvDangKy : lst){
            fcl.getPrintWriter().println(gvDangKy.getMaGV()+ "|" + gvDangKy.getMaLH());
        }
        
        fcl.closeFileAfterWrite();
    }


}
