package com.it.iot.controller;

import com.it.iot.service.IDictService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class DictController {

    @Resource
    private IDictService dictService;

    public void list(){
        dictService.list();
    }
}
