package com.zx.service;

import com.zx.pojo.Girl;
import com.zx.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        Girl girlB = new Girl();
        girlB.setAge(222);
        girlA.setCupSize("te");
        girlRepository.save(girlB);
    }
}
