/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.LopHoc;
import util.StringUtils;

/**
 *
 * @author admin 
 */
public class LopHocService {
    private FileService fcl;
    private String fileName;
    
    public LopHocService(String fileName) {
        this.fileName = fileName;
        this.fcl = new FileService(fileName);
    }
    
    //LopHoc(String maLH, String tenLH, String ngayBatDau, String thu,String tiet, int siSo, String maMH, String maPH)
    public List<LopHoc> getAllLopHoc() throws ParseException {
        fcl.openFileToRead();
        List<LopHoc> output = new ArrayList<>();
        
        while(fcl.getScanner().hasNext()){
            String data = fcl.getScanner().nextLine();
            LopHoc sv = getQuanTriVienByData(data);
            output.add(sv);
        }
        
        fcl.closeFileAfterRead();
        return output;
    }
    
    public LopHoc getQuanTriVienByData(String data) throws ParseException {
        String[] datas = StringUtils.split(data);
        return new LopHoc(datas[0],datas[1],datas[2],datas[3],datas[4],Integer.parseInt(datas[5]),datas[6],datas[7]);
    }

    public void insertList(List<LopHoc> lopHocs) {
        fcl.openFileToWrite();
        
        for(LopHoc lv : lopHocs){
            fcl.getPrintWriter().println(
                    lv.getMaLH()+ "|" 
                    + lv.getTenLH()+ "|" 
                    + lv.getNgayBatDau()+ "|" 
                    + lv.getThu()+ "|" 
                    + lv.getTiet()+ "|" 
                    + lv.getSiSo()+ "|" 
                    + lv.getMaMH()+ "|" 
                    + lv.getMaPH()
            );
        }
        fcl.closeFileAfterWrite();
    }
}
