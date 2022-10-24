package com.restfull.oop.service;

import com.restfull.oop.dto.TaiKhoanDTO;
import com.restfull.oop.vm.TaiKhoanVM;

import java.util.List;

public interface TaiKhoanService {
    List<TaiKhoanVM> getList();
    TaiKhoanVM getDetail(Long maTk);
    TaiKhoanVM create(TaiKhoanDTO taiKhoanDTO);
    TaiKhoanVM update(TaiKhoanDTO taiKhoanDTO);
    void delete(Long maTK);
}
