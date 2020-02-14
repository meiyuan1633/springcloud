package com.tina.cloud_provider.dao;

import com.tina.cloud_model.entity.StudentSign;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentSigDao {

    /*签到*/
    @Insert("insert into t_sign(name ,clsname,stime,type)values (#{name },#{clsname},now(),#{type})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(StudentSign studentSign);
    /*查询  某个人的签到记录*/
    @Select("select id,name,clsname,stime,type from t_sign where name =#{name }")
    List<StudentSign> selectByName(String name);
    /*查询全部*/
    @Select("select id,name,clsname,stime,type from t_sign order  by stime desc ")
    List<StudentSign>selectAll();
}
