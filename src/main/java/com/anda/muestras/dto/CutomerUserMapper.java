package com.anda.muestras.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import com.anda.muestras.model.CustomUser;
@Mapper
public interface CutomerUserMapper {

	CutomerUserMapper mapper = Mappers.getMapper(CutomerUserMapper.class);
	
	 CustomerUserDto customerUsertoCustomerUserDto(CustomUser customUser);
}
