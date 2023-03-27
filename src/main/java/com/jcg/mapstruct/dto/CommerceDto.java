package com.jcg.mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
@Getter
@Setter
public class CommerceDto {

    @Id
    int id;
    String name;
    String price;
    String code;
    String refId;
    String quantity;
}
