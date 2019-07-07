package edu.mum.cs544.bank.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.mum.cs544.bank.domain.Account;

public class JPAAccountDAO implements IAccountDAO {

    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    public void updateAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        Account databaseAccount = em.find(Account.class, account.getAccountnumber());
        if (databaseAccount == null)
            em.persist(account);
        databaseAccount = account;
    }

    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> eagerQuery = em.createQuery( "from Account a " + 
                                                "left join fetch a.entryList " +
                                                "left join fetch a.customer " +
                                                "where a.id = :accountNumber ", Account.class);
        eagerQuery.setParameter("accountNumber", accountnumber);
        return eagerQuery.getSingleResult();
    }

    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> eagerQuery = em.createQuery("select distinct a from Account a " + 
                                    "left join fetch a.entryList " + 
                                    "left join fetch a.customer", Account.class);
        return eagerQuery.getResultList();
    }
}