package com.tina.cloud_provider.controller;


import com.tina.cloud_model.dto.SignDto;
import com.tina.cloud_model.vo.R;
import com.tina.cloud_provider.service.StudentSigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentSignController {
    @Autowired
    private StudentSigService sigService;

    //新增
    @PostMapping("/provider/sign/save.do")
    public R save(@RequestBody SignDto dto){
        return sigService.sign(dto);
    }

    @GetMapping("/provider/sign/queryname.do")
    public R name(@RequestParam String name){
        return sigService.queryByName(name);
    }

    @GetMapping("/provider/sign/all.do")
    public R all(){
        return sigService.queryAll();
    }
}


