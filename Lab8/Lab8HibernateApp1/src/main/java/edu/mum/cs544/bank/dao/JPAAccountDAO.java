package edu.mum.cs544.bank.dao;

import java.util.Collection;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;

import edu.mum.cs544.bank.domain.Account;
import edu.mum.cs544.bank.domain.AccountEntry;

public class JPAAccountDAO implements IAccountDAO {

    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }

    public void updateAccount(Account account) {
        Account dbAccount = loadAccount(account.getAccountnumber());
        dbAccount = account;
    }

    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        EntityGraph<Account> graph = em.createEntityGraph(Account.class);
        graph.addAttributeNodes("accountnumber");
        graph.addSubgraph("customer").addAttributeNodes("name");
        Subgraph<AccountEntry> entryList = graph.addSubgraph("entryList");
        entryList.addAttributeNodes("date");
        entryList.addAttributeNodes("amount");
        entryList.addAttributeNodes("description");
        entryList.addAttributeNodes("fromAccountNumber");
        entryList.addAttributeNodes("fromPersonName");
        TypedQuery<Account> query = em.createQuery( "from Account a where a.id = :accountNumber ", Account.class);
        query.setParameter("accountNumber", accountnumber);
        query.setHint("javax.persistence.fetchgraph", graph);
        return query.getSingleResult();
    }

    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();
        TypedQuery<Account> eagerQuery = em.createQuery("select distinct a from Account a " + 
                                    "left join fetch a.entryList " + 
                                    "left join fetch a.customer", Account.class);
        return eagerQuery.getResultList();
    }
}