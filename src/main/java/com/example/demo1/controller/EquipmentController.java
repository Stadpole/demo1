package com.example.demo1.controller;

import com.example.demo1.common.base.PageEntity;
import com.example.demo1.common.utils.RedisUtil;
import com.example.demo1.entity.Equipment;

import com.example.demo1.mapper.EquipmentMapper;
import com.example.demo1.service.EquipmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Stadpole on 2017/9/21.
 */
@Slf4j
@RestController
@RequestMapping(value = "/equipment")
public class EquipmentController extends BaseCommonController {
    @Autowired
    private EquipmentService equipmentService;
    @Autowired(required=false)
    private EquipmentMapper equipmentMapper;
    @Resource
    private RedisUtil redisUtil;
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test() {
        equipmentService.testInfo();
        return sendSuccessMessage();
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String get() {
        List<Equipment> equipment = equipmentMapper.listEquipment();
        return send(equipment);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(@RequestBody Equipment entity) {
        if (entity.getId() != null) {
            equipmentService.save(entity);
            return sendSuccessMessage();
        } else {
            return sendFailMessage();
        }
    }



    /**实现分页查询的方法*/
    /*获取分页数据 包含分页详细信息*/
    @RequestMapping(value = "/page",method = RequestMethod.GET)
    public PageInfo getAll(@RequestParam Integer page, @RequestParam Integer size){
        PageHelper.startPage(page,size);
        //List<Equipment> equipment0 =equipmentService.findAll();
        List<Equipment> equipment = equipmentMapper.listEquipment();
        PageInfo<Equipment> pageInfo = new PageInfo(equipment);
        return pageInfo;
    }


}

