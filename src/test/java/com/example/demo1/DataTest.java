package com.example.demo1;

import com.example.demo1.entity.Equipment;
import com.example.demo1.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Stadpole on 2020/6/10 16:30
 */
public class DataTest {
    @Autowired
    private EquipmentRepository equipmentRepository;

    public List<Equipment> getPsrList(){
        ArrayList<Equipment>  list=new ArrayList<>();
            for (int i = 0; i < 3000; i++) {
                Equipment equipment = new Equipment();
                double generatorDouble = new Random().nextDouble();
                int min = 1;
                int max = 10;
                int intBounded = min + ((int) (new Random().nextFloat() * (max - min)));

                equipment.setEq_Id(1);
                equipment.setTm_Id(intBounded);
                equipment.setDescription("ACU");
                equipment.setEngineer(String.valueOf(generatorDouble));
                equipment.setRaw(String.valueOf(generatorDouble));
                list.add(equipment);
                equipmentRepository.save(equipment);
            }
            return list;
        }
}
