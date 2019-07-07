package edu.mum.cs544.bank.service;

import edu.mum.cs544.bank.dao.EntityManagerHelper;
import edu.mum.cs544.bank.dao.IAccountDAO;
import edu.mum.cs544.bank.dao.JPAAccountDAO;
import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.Customer;
import edu.mum.cs544.bank.logging.ILogger;
import edu.mum.cs544.bank.logging.Logger;

import java.util.Collection;

import javax.persistence.EntityManager;


public class AccountService implements IAccountService {
    private IAccountDAO accountDAO;
    private ICurrencyConverter currencyConverter;
    private ILogger logger;

    public AccountService() {
        accountDAO = new JPAAccountDAO();
        currencyConverter = new CurrencyConverter();
        logger = new Logger();
    }

    public Account createAccount(long accountNumber, String customerName) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        em.getTransaction().commit();
        em.close();
        logger.log("createAccount with parameters accountNumber= " + accountNumber + " , customerName= " + customerName);
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        logger.log("deposit with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.close();
    }

    public Account getAccount(long accountNumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        em.getTransaction().commit();
        em.close();
        return account;
    }

    public Collection<Account> getAllAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Collection<Account> accounts = accountDAO.getAccounts();
        em.getTransaction().commit();
        em.close();
        return accounts;

    }

    public void withdraw(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        logger.log("withdraw with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public void depositEuros(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.deposit(amountDollars);
        accountDAO.updateAccount(account);
        logger.log("depositEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public void withdrawEuros(long accountNumber, double amount) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account account = accountDAO.loadAccount(accountNumber);
        double amountDollars = currencyConverter.euroToDollars(amount);
        account.withdraw(amountDollars);
        accountDAO.updateAccount(account);
        logger.log("withdrawEuros with parameters accountNumber= " + accountNumber + " , amount= " + amount);
        em.getTransaction().commit();
        em.close();
    }

    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.getTransaction().begin();
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        logger.log("transferFunds with parameters fromAccountNumber= " + fromAccountNumber + " , toAccountNumber= " + toAccountNumber + " , amount= " + amount + " , description= " + description);
        em.getTransaction().commit();
        em.close();
    }
}