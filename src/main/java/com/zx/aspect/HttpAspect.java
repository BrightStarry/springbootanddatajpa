package com.zx.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by 97038 on 2017-04-03.
 */
@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.zx.controller.GirlController.*(..))")
    public void log(){
        System.out.println("1111111");
    }
}
