package com.jcg.mapstruct.mapper;

import com.jcg.mapstruct.dto.CommerceDto;
import com.jcg.mapstruct.model.Commerce;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

// @Mapper(componentModel = "spring", imports = UUID.class)
@Mapper(componentModel = "spring")
public interface CommerceMapper {

    CommerceMapper INSTANCE = Mappers.getMapper(CommerceMapper.class);

   // @Mapping(source = "commerce.promotionCode", target = "code")
        // @Mapping(target = "refId", expression = "java(UUID.randomUUID().toString())")
    CommerceDto modelToDto(Commerce commerce);

    List<CommerceDto> modelsToDtos(List<Commerce> commerces);

    @InheritInverseConfiguration
    Commerce dtoToModel(CommerceDto commerceDto);
}
