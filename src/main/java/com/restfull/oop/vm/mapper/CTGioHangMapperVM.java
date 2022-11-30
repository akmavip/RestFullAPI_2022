package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.CTGioHang;
import com.restfull.oop.vm.CTGioHangVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CTGioHangMapperVM extends EntityMapper<CTGioHangVM, CTGioHang> {
}
