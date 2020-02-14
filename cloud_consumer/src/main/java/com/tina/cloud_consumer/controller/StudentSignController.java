package com.tina.cloud_consumer.controller;


import com.tina.cloud_consumer.service.StudentSignService;
import com.tina.cloud_model.dto.SignDto;
import com.tina.cloud_model.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentSignController {

    @Autowired
    private StudentSignService signService;
    //新增
    @PostMapping("/api/sign/save.do")
    public R save(@RequestBody SignDto dto){
        return signService.save(dto);
    }
    @GetMapping("/api/sign/queryname.do")
    public R names(@RequestParam String name){
        return signService.names(name);
    }
    @GetMapping("/api/sign/all.do")
    public R all(){
        return signService.all();
    }

}
