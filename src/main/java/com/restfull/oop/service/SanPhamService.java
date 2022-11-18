package com.restfull.oop.service;

import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.model.SanPham;
import com.restfull.oop.vm.SanPhamVM;

import java.util.List;

public interface SanPhamService {

    List<SanPhamVM> getAll();

    List<SanPhamVM> getHotProducts();

    SanPhamVM getDetail(Long id);

    SanPhamVM create(SanPhamDTO sanPhamDTO);

    void delete(Long maTK);
}
