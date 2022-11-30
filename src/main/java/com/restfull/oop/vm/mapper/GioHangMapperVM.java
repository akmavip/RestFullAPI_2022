package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.GioHang;
import com.restfull.oop.vm.GioHangVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface GioHangMapperVM extends EntityMapper<GioHangVM, GioHang> {
}
