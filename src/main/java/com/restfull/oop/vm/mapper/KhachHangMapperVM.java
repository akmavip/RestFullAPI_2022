package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.KhachHang;
import com.restfull.oop.vm.KhachHangVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface KhachHangMapperVM extends EntityMapper<KhachHangVM, KhachHang> {
}
