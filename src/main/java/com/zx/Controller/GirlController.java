package com.zx.Controller;

import com.zx.pojo.Girl;
import com.zx.repository.GirlRepository;
import com.zx.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 97038 on 2017-04-03.
 */
@RestController
@RequestMapping("/girls")
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /**
     * 获取列表
     */
    @GetMapping("")
    public List<Girl> girlList(){
        return girlRepository.findAll();
    }

    /**
     * 创建
     */
    @PostMapping("")
    public Girl addGirl(@RequestParam("cupSize") String cupSize,@RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    /**
     *查询one girl
     */
    @GetMapping("/{id}")
    public Girl getGirl(@PathVariable("id")Integer id){
        return  girlRepository.findOne(id).get();
    }

    /**
     * 修改
     */
    @PutMapping("/{id}")
    public Girl updateGirl(@PathVariable("id")Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return  girlRepository.save(girl);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public void deleteGirl(@PathVariable("id")Integer id){
        girlRepository.delete(id);
    }

    @GetMapping("/test")
    public void test(){
        girlService.insertTwo();
    }


}