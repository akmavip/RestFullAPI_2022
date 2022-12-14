package com.restfull.oop.service.impl;

import com.restfull.oop.model.KhachHang;
import com.restfull.oop.model.NhanVien;
import com.restfull.oop.model.TaiKhoan;
import com.restfull.oop.repository.KhachHangRepository;
import com.restfull.oop.repository.NhanVienRepository;
import com.restfull.oop.repository.TaiKhoanRepository;
import com.restfull.oop.service.LoginService;
import com.restfull.oop.vm.KhachHangVM;
import com.restfull.oop.vm.TaiKhoanVM;
import com.restfull.oop.vm.mapper.KhachHangMapperVM;
import com.restfull.oop.vm.mapper.TaiKhoanMapperVM;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private KhachHangMapperVM khachHangMapperVM;
    @Override
    public JSONObject getAll(String email, String password) {
        NhanVien nv = nhanVienRepository.findEmployeeByEmail(email);
        KhachHang kh = khachHangRepository.findUserByEmail(email);

        TaiKhoan tk = new TaiKhoan();
        JSONObject res = new JSONObject();

        if(kh != null) {
            tk = taiKhoanRepository.findAccount(kh.getMaTK(), password);
            res.put("maTK", kh.getMaTK());
            res.put("hoTen",kh.getHoTen());
            res.put("diaChi",kh.getDiaChi());
            res.put("email",kh.getEmail());
            res.put("maKH",kh.getMaKH());
            res.put("maSoThue",kh.getMaSoThue());
            res.put("sdt",kh.getSdt());
            res.put("maQuyen", tk.getQuyen().getMaQuyen());

            return res;

        } else if (nv != null){
            tk = taiKhoanRepository.findAccount(nv.getMaTK(), password);
            res.put("maTK", nv.getMaTK());
            res.put("hoTen",nv.getHoTen());
            res.put("diaChi",nv.getDiaChi());
            res.put("email",nv.getEmail());
            res.put("maNV",nv.getMaNV());
            res.put("maSoThue",nv.getCmnd());
            res.put("sdt",nv.getSdt());
            res.put("maQuyen", tk.getQuyen().getMaQuyen());
            return res;

        }
        else return new JSONObject();

    }
}
