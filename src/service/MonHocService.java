/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.MonHoc;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class MonHocService {
    private FileService fcl;
    private String fileName;
    
    public MonHocService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }
    
    //MonHoc(String maMH, String tenMH, int soTinChi)
    public List<MonHoc> getAllMonHoc() throws ParseException {
        fcl.openFileToRead();
        List<MonHoc> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){
            String data = fcl.getScanner().nextLine();
            output.add(getMonHocByData(data));
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    
    public MonHoc getMonHocByData(String data) throws ParseException {
        String[] datas = StringUtils.split(data);
        return new MonHoc(datas[0],datas[1],Integer.parseInt(datas[2]));
    }

    public void insertList(List<MonHoc> monHocs) {
        fcl.openFileToWrite();
        
        for(MonHoc mh : monHocs){
            fcl.getPrintWriter().println(
                    mh.getMaMH()+ "|" 
                    + mh.getTenMH()+ "|" 
                    + mh.getSoTinChi()
            );
        }
        fcl.closeFileAfterWrite();
    }
}
