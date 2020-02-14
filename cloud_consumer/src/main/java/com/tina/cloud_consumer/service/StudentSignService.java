package com.tina.cloud_consumer.service;

import com.tina.cloud_consumer.fallback.MyFallBackFactory;
import com.tina.cloud_model.dto.SignDto;
import com.tina.cloud_model.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "tina-provider",fallbackFactory = MyFallBackFactory.class)

public interface StudentSignService {
    //新增
    @PostMapping("/provider/sign/save.do")
    R save(@RequestBody SignDto dto);
    @GetMapping("/provider/sign/queryname.do")
    R names(@RequestParam String name);
    @GetMapping("/provider/sign/all.do")
    R all();
}
