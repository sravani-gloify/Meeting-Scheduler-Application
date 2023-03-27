package com.jcg.mapstruct.controller;

import com.jcg.mapstruct.dto.CommerceDto;
import com.jcg.mapstruct.mapper.CommerceMapper;
import com.jcg.mapstruct.model.Commerce;
import com.jcg.mapstruct.service.CommerceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commerce")
public class CommerceController {

    @Autowired
    CommerceService service;

    @Autowired
    CommerceMapper mapper;

    // http://localhost:9090/commerce/
    /*
    Sample postman request -
    {
        "id": "{{$randomInt}}",
        "name": "{{$randomProduct}}",
        "price": "{{$randomPrice}}",
        "code": "{{$randomBankAccountBic}}",
        "refId": "{{$randomInt}}",
        "quantity": "{{$randomInt}}"
    }
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CommerceDto dto) {
        Commerce commerce = mapper.dtoToModel(dto);
        service.save(commerce);
    }

    // http://localhost:9090/commerce/
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<CommerceDto> findAll() {
        return mapper.modelsToDtos(service.findAll());
    }

    // http://localhost:9090/commerce/1
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CommerceDto findOne(@PathVariable("id") int id) {
        return mapper.modelToDto(service.findOne(id));
    }

    // other crud operations left for brevity.
}
