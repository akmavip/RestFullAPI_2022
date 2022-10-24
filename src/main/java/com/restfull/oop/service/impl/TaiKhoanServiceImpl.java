package com.restfull.oop.service.impl;

import com.restfull.oop.dto.TaiKhoanDTO;
import com.restfull.oop.exception.NotFoundException;
import com.restfull.oop.mapper.TaiKhoanMapper;
import com.restfull.oop.model.TaiKhoan;
import com.restfull.oop.repository.TaiKhoanRepository;
import com.restfull.oop.service.TaiKhoanService;
import com.restfull.oop.vm.TaiKhoanVM;
import com.restfull.oop.vm.mapper.TaiKhoanMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaiKhoanServiceImpl implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private TaiKhoanMapper taiKhoanMapper;

    @Autowired
    private TaiKhoanMapperVM taiKhoanMapperVM;

    @Override
    @Transactional(readOnly = true)
    public List<TaiKhoanVM> getList() {
        return taiKhoanRepository.findAll().stream().map(taiKhoanMapperVM::toDto).collect(Collectors.toList());
    }

    @Override
    public TaiKhoanVM getDetail(Long maTk) {
        Optional<TaiKhoan> taiKhoan = taiKhoanRepository.findById(maTk);
        if(!taiKhoan.isPresent() || taiKhoan.isEmpty()){
            throw new NotFoundException("Tài khoản không được tìm thấy");
        }
        return taiKhoanMapperVM.toDto(taiKhoan.get());
    }

    @Override
    public TaiKhoanVM create(TaiKhoanDTO taiKhoanDTO) {
        TaiKhoan taiKhoan = taiKhoanMapper.toEntity(taiKhoanDTO);
        taiKhoanRepository.save(taiKhoan);
        TaiKhoanVM taiKhoanVM = taiKhoanMapperVM.toDto(taiKhoan);
        return taiKhoanVM;
    }

    @Override
    public TaiKhoanVM update(TaiKhoanDTO taiKhoanDTO) {
        Optional<TaiKhoan> taiKhoan = taiKhoanRepository.findById(taiKhoanDTO.getMaTK());
        if(!taiKhoan.isPresent()|| taiKhoan.isEmpty())  {
            throw new NotFoundException("Tài khoản không được tìm thấy");
        }
        taiKhoanMapper.partialUpdate(taiKhoan.get(), taiKhoanDTO);
        TaiKhoanVM taiKhoanVM = taiKhoanMapperVM.toDto(taiKhoan.get());
        return taiKhoanVM;
    }

    @Override
    public void delete(Long maTK) {
        TaiKhoan taiKhoan = taiKhoanRepository.findById(maTK).get();
        taiKhoanRepository.delete(taiKhoan);
    }
}
