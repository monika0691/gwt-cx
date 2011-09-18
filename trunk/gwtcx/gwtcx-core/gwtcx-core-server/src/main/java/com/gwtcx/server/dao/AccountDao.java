/**
 * (C) Copyright 2010, 2011 upTick Pty Ltd
 *
 * Licensed under the terms of the GNU General Public License version 3
 * as published by the Free Software Foundation. You may obtain a copy of the
 * License at: http://www.gnu.org/copyleft/gpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.gwtcx.server.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.gwtcx.server.domain.Account;

public class AccountDao extends BaseDao {

  public Long createObject(Object object) {
    return createAccount((Account) object);
  }

  public List<Object> retrieveObjects(int maxResults, int firstResult) {

	List<Object> list = null;
    EntityManager em = createEntityManager();

    try {
      TypedQuery<Object> query = em.createQuery("select a from Account a", Object.class);
      query.setMaxResults(maxResults);
      query.setFirstResult(firstResult);
      list = query.getResultList();
    }
    finally {
      em.close();
    }

    return list;
  }

  public Long createAccount(Account account) {

    // For an application-managed entity manager its best practice to create a
    // new entity manager inside a method and close it before the method is finished.
	  
	// When using transactions outside an enterprise application server you need to 
    // close (commit or rollback) the transaction in the same way you do for EntityManagers.
	// In order for the resources (both EntityManager and Transaction) to be closed
	// you need to use an additional level of nesting.

	Long accountId = -1L;
    EntityManager em = createEntityManager();

    try {
      EntityTransaction tx = em.getTransaction();
      
      try {
        tx.begin();
        em.persist(account);
        accountId = account.getAccountId();
        tx.commit();
      } 
      // catch (Throwable t) {
      //   t.printStackTrace();
      // }      
      finally {
        if (tx.isActive()) tx.rollback();
      }
    } 
    finally {
      em.close();
    }    
    
    return accountId;
  }

  public Account retrieveAccount(Long accountId) {

    Account account = null;
    EntityManager em = createEntityManager();

    try {
      TypedQuery<Account> query = em.createQuery("select a from Account a where a.accountId = ?1", Account.class);
      query.setParameter(1, accountId);
      account = query.getSingleResult();
    }
    finally {
      em.close();
    }

    return account;
  }

  public List<Account> retrieveAccounts(int maxResults, int firstResult) {

    List<Account> list = null;
    EntityManager em = createEntityManager();

    try {
      TypedQuery<Account> query = em.createQuery("select a from Account a", Account.class);
      query.setMaxResults(maxResults);
      query.setFirstResult(firstResult);
      list = query.getResultList();
    }
    finally {
      em.close();
    }

    return list;
  }

  public Account updateAccount(Account account) {

	Account account2 = null;
    EntityManager em = createEntityManager();
    
    try {
      EntityTransaction tx = em.getTransaction();
      
      try {
        tx.begin();
        account2 = em.merge(account);
        tx.commit();
      } 
      // catch (Throwable t) {
      //   t.printStackTrace();
      // }      
      finally {
        if (tx.isActive()) tx.rollback();
      }
    } 
    finally {
      em.close();
    }    

    return account2;
  }

  public void deleteAccount(Account account) {

    EntityManager em = createEntityManager();

    try {
      EntityTransaction tx = em.getTransaction();
      
      try {
        tx.begin();
        em.remove(em.merge(account));
        tx.commit();
      } 
      // catch (Throwable t) {
      //   t.printStackTrace();
      // }      
      finally {
        if (tx.isActive()) tx.rollback();
      }
    } 
    finally {
      em.close();
    }        
  }
}
