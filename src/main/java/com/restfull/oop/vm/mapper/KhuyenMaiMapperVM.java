package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.KhuyenMai;
import com.restfull.oop.vm.KhuyenMaiVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface KhuyenMaiMapperVM extends EntityMapper<KhuyenMaiVM, KhuyenMai> {
}
