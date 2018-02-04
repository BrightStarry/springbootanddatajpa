package com.zx.service;

import com.zx.enums.ResultEnum;
import com.zx.exception.GirlException;
import com.zx.pojo.Girl;
import com.zx.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by 97038 on 2017-04-03.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("tes");
        girlA.setAge(111);
        girlRepository.save(girlA);
        int i = 1/0;
        Girl girlB = new Girl();
        girlB.setAge(222);
        girlA.setCupSize("te");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age  = girl.getAge();
        if(age < 10 ){
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age < 16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
