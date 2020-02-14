package com.tina.cloud_model.entity;

import lombok.Data;

import java.util.Date;
@Data
public class StudentSign {
    private Integer id;
    private String name;
    private String type;
    private String clsname;//班级
    private Date stime;//签到时间

}
