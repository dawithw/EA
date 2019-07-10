package edu.mum.cs544.bank.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.cs544.bank.logging.ILogger;

@Aspect
@Component
public class JMSLogAdvice {
    
    @Autowired
    private ILogger logger;
    
    @AfterReturning("execution(* edu.mum.cs544.bank.jms.JMSSender.*(..))")
    public void logJMSMessage(JoinPoint jPoint) {
        logger.log("JMS MESSAGE SENT => " + jPoint.getArgs()[0]);
    }
}