package com.it.iot.service.impl;

import com.it.common.model.dict.Dict;
import com.it.common.model.dict.DictQuery;
import com.it.core.supper.SuperServiceImpl;
import com.it.iot.mapper.DictMapper;
import com.it.iot.service.IDictService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictServiceImpl extends SuperServiceImpl<DictMapper, Dict> implements IDictService {

    public List<Dict> list(DictQuery query) {
        return null;
    }
}
