package com.restfull.oop.service.impl;

import com.restfull.oop.repository.QuyenRepository;
import com.restfull.oop.service.QuyenService;
import com.restfull.oop.vm.QuyenVM;
import com.restfull.oop.vm.mapper.QuyenMapperVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuyenServiceImpl implements QuyenService {

    @Autowired
    private QuyenRepository quyenRepository;

    @Autowired
    private QuyenMapperVM quyenMapperVM;

    @Override
    @Transactional(readOnly = true)
    public List<QuyenVM> getList() {
        return quyenRepository.findAll().stream().map(quyenMapperVM::toDto).collect(Collectors.toList());
    }
}
