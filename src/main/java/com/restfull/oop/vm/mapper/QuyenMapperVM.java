package com.restfull.oop.vm.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.Quyen;
import com.restfull.oop.vm.QuyenVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface QuyenMapperVM extends EntityMapper<QuyenVM, Quyen> {
}
