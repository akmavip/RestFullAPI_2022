package com.restfull.oop.service;

import com.restfull.oop.dto.KhuyenMaiDTO;
import com.restfull.oop.payload.KhuyenMaiPayLoad;
import com.restfull.oop.vm.KhuyenMaiVM;

import java.util.List;

public interface KhuyenMaiService {

    List<KhuyenMaiVM> getPromotion();

    KhuyenMaiPayLoad create(KhuyenMaiPayLoad khuyenMaiPayLoad);
    KhuyenMaiPayLoad addProduct(KhuyenMaiPayLoad khuyenMaiPayLoad);
}
