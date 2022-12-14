package com.restfull.oop.service.impl;

import com.restfull.oop.model.NhanVien;
import com.restfull.oop.model.TaiKhoan;
import com.restfull.oop.repository.NhanVienRepository;
import com.restfull.oop.repository.TaiKhoanRepository;
import com.restfull.oop.service.NhanVienService;
import com.restfull.oop.vm.TaiKhoanVM;
import com.restfull.oop.vm.mapper.NhanVienMapperVM;
import com.restfull.oop.vm.mapper.TaiKhoanMapperVM;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private NhanVienMapperVM nhanVienMapperVM;
    @Autowired
    TaiKhoanRepository taiKhoanRepository;
    @Autowired
    TaiKhoanMapperVM taiKhoanMapperVM;
    @Override
    public List <JSONObject> getList() {
        List <JSONObject> ds = new ArrayList<>();
        List <NhanVien> dsnv = nhanVienRepository.findAll().stream().map(nhanVienMapperVM::toDto).collect(Collectors.toList());
        List <TaiKhoanVM> dstk = taiKhoanRepository.findAll().stream().map(taiKhoanMapperVM::toDto).collect(Collectors.toList());
        for(int j = 0; j < dsnv.size() ; j++) {
            for (int i = 0; i < dstk.size()  ; i++ ){
                if(dsnv.get(j).getMaTK() == dstk.get(i).getMaTK()){
                    JSONObject res = new JSONObject();
                    res.put("maTK", dsnv.get(j).getMaTK());
                    res.put("hoTen",dsnv.get(j).getHoTen());
                    res.put("diaChi",dsnv.get(j).getDiaChi());
                    res.put("email",dsnv.get(j).getEmail());
                    res.put("maNV",dsnv.get(j).getMaNV());
                    res.put("maSoThue",dsnv.get(j).getCmnd());
                    res.put("sdt",dsnv.get(j).getSdt());
                    res.put("maQuyen", dstk.get(j).getQuyen().getMaQuyen());
                    ds.add(res);
                    break;
                }
            }
        }
        return ds;
    }

}
