package com.restfull.oop.service;

import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.payload.GioHangPayload;
import com.restfull.oop.vm.GioHangVM;
import com.restfull.oop.vm.KhuyenMaiVM;

import java.util.List;

public interface GioHangService {
//     GioHangVM create(GioHangDTO gioHangDTO);
     List<GioHangVM> getCart();
     List<GioHangVM> getCartByMaKH(Long maKH);


     GioHangPayload create(GioHangPayload gioHangPayload);
     GioHangPayload update(GioHangPayload gioHangPayload);

}

