package com.restfull.oop.mapper;

import com.restfull.oop.config.EntityMapper;
import com.restfull.oop.dto.TaiKhoanDTO;
import com.restfull.oop.model.TaiKhoan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface TaiKhoanMapper extends EntityMapper<TaiKhoanDTO, TaiKhoan> {}
