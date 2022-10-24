package com.restfull.oop.service.impl;

import com.restfull.oop.model.Quyen;
import com.restfull.oop.repository.QuyenRepository;
import com.restfull.oop.service.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuyenServiceImpl implements QuyenService {

    @Autowired
    private QuyenRepository quyenRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Quyen> getList() {
        return quyenRepository.findAll();
    }
}
