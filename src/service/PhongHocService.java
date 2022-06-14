/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.PhongHoc;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class PhongHocService {
    private FileService fcl;
    private String fileName;
    
    public PhongHocService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }
    
    
    public List<PhongHoc> getAllPhongHoc() {
        fcl.openFileToRead();
        List<PhongHoc> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){
            String data = fcl.getScanner().nextLine();
            PhongHoc ph = getPhongHocByData(data);
            output.add(ph);
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    //PhongHoc(String maPH, String tenPH, String dienTich)
    public PhongHoc getPhongHocByData(String data) {
        String[] datas = StringUtils.split(data);
        return new PhongHoc(datas[0],datas[1],datas[2]);
    }

    public void insertList(List<PhongHoc> phs) {
        fcl.openFileToWrite();
        
        for(PhongHoc lv : phs){
            fcl.getPrintWriter().println(
                    lv.getMaPH()+ "|" 
                    + lv.getTenPH()+ "|" 
                    + lv.getDienTich()
            );
        }
        fcl.closeFileAfterWrite();
    }
}
