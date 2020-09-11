package com.finance.helper.service;


import com.finance.helper.entity.Attribute;
import com.finance.helper.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    public List<Attribute> getAttributes(){
        return attributeRepository.findAll();
    }
}
