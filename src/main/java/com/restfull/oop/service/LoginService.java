package com.restfull.oop.service;

import com.restfull.oop.vm.KhachHangVM;
import com.restfull.oop.vm.SanPhamVM;
import com.restfull.oop.vm.TaiKhoanVM;
import net.minidev.json.JSONObject;

import java.util.List;

public interface LoginService {

   JSONObject  getAll(String email, String password);

}
