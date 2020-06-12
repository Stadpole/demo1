package com.example.demo1.mapper;

import com.example.demo1.entity.Equipment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Stadpole on 2020/6/10 9:21
 */
@Mapper
public interface EquipmentMapper {
    @Select("select * from equipment")
    List<Equipment> listEquipment();
    @Insert("<script> insert into equipment (eq_Id,tm_Id,description,raw,engineer,time) values  " +
            "  <foreach collection='result' item='item' separator=',' > " +
            "  (#{item.eq_Id},#{item.tm_Id},#{item.description},#{item.raw},#{item.engineer},#{item.time})\n" +
            "  </foreach> </script>")
    Boolean insertBatchCode(@Param(value = "result") List<Equipment> result);
}
