package edu.mum.cs544;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());
    
    @After("execution(* edu.mum.cs544.EmailSender.sendEmail(..))")
    public void afterSendEmail(JoinPoint jp) {
        Object[] args = jp.getArgs();
        logger.warn("method= " + jp.getSignature().getName() + 
                    "\naddress= " + args[0] + 
                    "\nmessage= " + args[1] +
                    "\noutgoing_mail_server= " + ((EmailSender)jp.getTarget()).getOutgoingMailServer());
    }

    @Around("execution(* edu.mum.cs544.CustomerDAO.*(..))")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Time to execute save = " + totaltime + "ms");
        return retVal;
    }

}