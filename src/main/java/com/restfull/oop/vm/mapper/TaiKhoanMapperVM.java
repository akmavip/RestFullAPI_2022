package com.restfull.oop.vm.mapper;


import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.model.TaiKhoan;
import com.restfull.oop.vm.TaiKhoanVM;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TaiKhoanMapperVM extends EntityMapper<TaiKhoanVM, TaiKhoan> {}
