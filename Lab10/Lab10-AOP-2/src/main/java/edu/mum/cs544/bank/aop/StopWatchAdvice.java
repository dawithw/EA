package edu.mum.cs544.bank.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import edu.mum.cs544.bank.logging.ILogger;

@Aspect
@Component
public class StopWatchAdvice {
    
    @Autowired
    private ILogger logger;
    
    @Around("execution(* edu.mum.cs544.bank.service.*.*(..))")
    public Object methodTimer(ProceedingJoinPoint pJoinPoint) {
        String methodName = pJoinPoint.getSignature().getName();
        StopWatch sw = new StopWatch();
        sw.start(methodName);
        Object retVal = null;
        try {
            retVal = pJoinPoint.proceed();
        } catch (Throwable thrown) {
            System.out.println(thrown.getCause());
            System.out.println(thrown.getMessage());
            thrown.printStackTrace();
        } finally {
            sw.stop();
            logger.log("METHOD " + methodName + " EXECUTED IN " + sw.getLastTaskTimeMillis() + "ms");
        }
        return retVal;
    }
}