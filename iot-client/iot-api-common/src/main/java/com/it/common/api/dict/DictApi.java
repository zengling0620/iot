package com.it.common.api.dict;

import com.it.common.model.dict.Dict;
import com.it.common.model.dict.DictQuery;
import com.it.core.supper.ISuperService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/outer/")
public interface DictApi extends ISuperService<Dict> {

    @RequestMapping
    List<Dict> list(@RequestBody DictQuery query);

}
