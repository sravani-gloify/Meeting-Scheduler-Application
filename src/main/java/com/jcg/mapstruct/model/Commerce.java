package com.jcg.mapstruct.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "commerce")
public class Commerce {

    @Id
    int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String name;
    String price;
    String promotionCode;
    String refId;
    int quantity;
}
