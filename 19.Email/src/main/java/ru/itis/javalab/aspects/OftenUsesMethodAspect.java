package ru.itis.javalab.aspects;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.itis.javalab.services.OftenUsedMethodService;

@Component
@Aspect
public class OftenUsesMethodAspect {

    @Autowired
    private OftenUsedMethodService methodService;

    @Around(value = "execution(* ru.itis.javalab.controllers.SignUpController.*(..))")
    public Object saveOftenUsesMethods(ProceedingJoinPoint joinPoint) throws Throwable {
        methodService.refresh(joinPoint.getSignature().getName());
        return joinPoint.proceed();
    }
}
