package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.GioHangDTO;
import com.restfull.oop.model.GioHang;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface GioHangMapper extends EntityMapper<GioHangDTO, GioHang> {
}
