package com.restfull.oop.service.impl;

import com.restfull.oop.mapper.CTSanPhamMapper;
import com.restfull.oop.mapper.SanPhamMapper;
import com.restfull.oop.repository.CTSanPhamRepository;
import com.restfull.oop.repository.SanPhamRepository;
import com.restfull.oop.service.SanPhamService;
import com.restfull.oop.vm.CTSanPhamVM;
import com.restfull.oop.vm.SanPhamVM;
import com.restfull.oop.vm.mapper.CTSanPhamMapperVM;
import com.restfull.oop.vm.mapper.SanPhamMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SanPhamMapper sanPhamMapper;

    @Autowired
    private SanPhamMapperVM sanPhamMapperVM;

    @Autowired
    private CTSanPhamRepository ctSanPhamRepository;

    @Autowired
    private CTSanPhamMapper ctSanPhamMapper;

    @Autowired
    private CTSanPhamMapperVM ctSanPhamMapperVM;

    @Override
    @Transactional(readOnly = true)
    public List<SanPhamVM> getAll() {

        List<SanPhamVM> listSanPham = sanPhamRepository.findAll().stream().map(sanPhamMapperVM::toDto).collect(Collectors.toList());
        List<CTSanPhamVM> listChiTietSP = ctSanPhamRepository.findAll().stream().map(ctSanPhamMapperVM::toDto).collect(Collectors.toList());


        for (int i = 0; i < listSanPham.size(); i++) {
            for (int x = 0; x < listChiTietSP.size(); x++) {
                if (listSanPham.get(i).getMaSP() == listChiTietSP.get(x).getSanPham().getMaSP()) {
                    listSanPham.get(i).setDetail(listChiTietSP.get(x));
                    break;
                }
            }
        }
        return listSanPham;
    }
}
