package com.zjut.azhen.DBDesign.config;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DevAspect {
    @Pointcut("execution(public * com.zjut.azhen.DBDesign.controllers.*(..)))")
    public void brokerAspect(){}

    

}
