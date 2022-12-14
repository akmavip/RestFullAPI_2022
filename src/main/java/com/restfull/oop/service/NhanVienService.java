package com.restfull.oop.service;

import com.restfull.oop.model.NhanVien;
import com.restfull.oop.model.SanPham;
import com.restfull.oop.vm.NhanVienVM;
import com.restfull.oop.vm.TaiKhoanVM;
import net.minidev.json.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NhanVienService {
    List <JSONObject> getList();
}
