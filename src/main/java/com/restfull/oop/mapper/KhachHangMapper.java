package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.KhachHangDTO;
import com.restfull.oop.model.KhachHang;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})

public interface KhachHangMapper extends EntityMapper<KhachHangDTO, KhachHang> {
}
