package edu.mum.cs544.bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.cs544.bank.logging.ILogger;

@Aspect
@Component
public class DAOAdvice {
    
    @Autowired
    private ILogger logger;
    
    @Before("execution(* edu.mum.cs544.bank.dao.AccountDAO.*(..))")
    public void logDAOCall(JoinPoint jPoint) {
        logger.log("EXECUTE METHOD => " + jPoint.getSignature().getName());
    }
}