package com.tina.cloud_provider.service.impl;

import com.tina.cloud_model.dto.SignDto;
import com.tina.cloud_model.entity.StudentSign;
import com.tina.cloud_model.vo.R;
import com.tina.cloud_provider.dao.StudentSigDao;
import com.tina.cloud_provider.service.StudentSigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSignServiceImpl implements StudentSigService {
    @Autowired
    private StudentSigDao sigDao;


    @Override
    public R sign(SignDto dto) {
         StudentSign studentSign = new StudentSign();
         /*每次需要签到*/
        studentSign.setClsname(dto.getClaname());
        studentSign.setName(dto.getName());
        studentSign.setType("上课前签到");
        if (sigDao.insert(studentSign)>0){
            return R.ok();
        }else {
            return R.fail();
        }
    }

    @Override
    public R queryByName(String name) {
        List<StudentSign>studentSigns=sigDao.selectByName(name);
        if (studentSigns!=null){
            return R.ok(studentSigns);
        }else {
            return R.fail("暂无签到数据");
        }
    }

    @Override
    public R queryAll() {
        return R.ok(sigDao.selectAll());
    }
}
