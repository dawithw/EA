package edu.mum.cs544.bank;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.mum.cs544.bank.dao.AccountDAO;
import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.jms.IJMSSender;
import edu.mum.cs544.bank.jms.JMSSender;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;
import edu.mum.cs544.bank.service.AccountService;
import edu.mum.cs544.bank.service.CurrencyConverter;
import edu.mum.cs544.bank.service.IAccountService;
import edu.mum.cs544.bank.service.ICurrencyConverter;

@Configuration
public class Config{
    
    @Bean
    public IAccountService accountService() {
        return new AccountService();
    }

    @Bean
    public IAccountDAO accountDAO() {
        return new AccountDAO();
    }
    
    @Bean
    public ICurrencyConverter currencyConverter() {
        return new CurrencyConverter(); 
    }

    @Bean
    public IJMSSender jSender() {
        return new JMSSender(); 
    }

    @Bean
    public ILogger logger() {
        return new Logger();
    }
}