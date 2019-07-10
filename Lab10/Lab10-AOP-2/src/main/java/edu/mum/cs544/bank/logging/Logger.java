package edu.mum.cs544.bank.logging;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger implements ILogger{

    
	public void log(String logstring) {
		java.util.logging.Logger.getLogger("BankLogger").info(logstring);		
    }

}
