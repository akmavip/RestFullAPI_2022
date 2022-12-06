package com.restfull.oop.service;

import com.restfull.oop.dto.SanPhamDTO;
import com.restfull.oop.dto.SanPhamFilterDTO;
import com.restfull.oop.vm.SanPhamVM;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SanPhamService {

    List<SanPhamVM> getAll(SanPhamFilterDTO filters);

    List<SanPhamVM> getHotProducts();

    List<SanPhamVM> getNewProducts();

    SanPhamVM getDetail(Long id);

    SanPhamVM create(SanPhamDTO sanPhamDTO);

    void delete(Long maTK);
}
