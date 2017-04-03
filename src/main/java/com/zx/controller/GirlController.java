package com.zx.controller;

import com.zx.dto.Result;
import com.zx.pojo.Girl;
import com.zx.repository.GirlRepository;
import com.zx.service.GirlService;
import com.zx.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Result<Girl> addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){//如果有错误
            return null;
//            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        Girl girlResult = girlRepository.save(girl);
        return ResultUtil.success(girlResult);
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

    /**
     * 年龄判断
     */
    @RequestMapping("/age/{id}")
    public void getAge(@PathVariable("id")Integer id) throws Exception {
        girlService.getAge(id);
    }


}
