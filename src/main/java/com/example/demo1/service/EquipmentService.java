package com.example.demo1.service;

import com.example.demo1.common.base.BasePageService;
import com.example.demo1.common.base.PageEntity;
import com.example.demo1.entity.Equipment;
import com.example.demo1.entity.User;
import com.example.demo1.mapper.EquipmentMapper;
import com.example.demo1.repository.EquipmentRepository;
import com.example.demo1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class EquipmentService extends BasePageService<Equipment, String> {
    @Autowired
    private EquipmentRepository equipmentRepository;
   @Autowired(required = false)
   private EquipmentMapper equipmentMapper;
    public void save(Equipment entity) {
        equipmentRepository.save(entity);
    }

    public Equipment findById(Integer id) {
        return equipmentRepository.findById(id);
    }

    public  List<Equipment> findAll() {
        return equipmentRepository.findAll();
    }
    public void deleteById(Integer id) {
        equipmentRepository.deleteById(id);
    }
    public void testInfo(){
        ArrayList<Equipment> list=new ArrayList();
        for(int i=0;i<30000;i++) {
        Equipment equipment=new Equipment();
        double generatorDouble = new Random().nextDouble();
        int min = 1;
        int max = 10;
        int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));
            equipment.setEq_Id(1);
            equipment.setTm_Id(intBounded);
            equipment.setDescription("ACU");
            equipment.setEngineer(String.valueOf(generatorDouble));
            equipment.setRaw(String.valueOf(generatorDouble));
            equipment.setTime(new Date());
            list.add(equipment);

        }
        equipmentMapper.insertBatchCode(list);
    }
    /**根据传入的分页参数，查询指定分页内的用户列表*/
    public Page<Equipment> getAllSysUserInfoByPageable(Pageable pageable){
        return  equipmentRepository.findAll(pageable);
    }
    public void pageByHql(PageEntity<Equipment> pageEntity, Map<String, Object> paramaMap) {
        StringBuilder sql = new StringBuilder(" from equipment where 1=1 ");
       /* if (paramaMap.containsKey("name")) {
            sql.append(" and name =:name ");
        }
        if (paramaMap.containsKey("power")) {
            sql.append(" and power =:power ");
        }*/
        super.pageByHql(sql.toString(), pageEntity, paramaMap);
        translate(pageEntity.getResults());
    }

    @Override
    protected void translate(List<Equipment> list) {
        super.translate(list);
    }
}