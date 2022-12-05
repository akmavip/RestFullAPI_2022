package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.CTKhuyenMai;
import com.restfull.oop.vm.CTKhuyenMaiVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface CTKhuyenMaiMapperVM extends EntityMapper<CTKhuyenMaiVM, CTKhuyenMai> {
}
