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

import com.gwtcx.server.domain.User;

public class UserDao extends BaseDao {

  public Long createObject(Object object) {
    return null;
  }

  @Override
  public List<Object> retrieveObjects(int maxResults, int firstResult) {
    return null;
  }

  public String createUser(User user) {
	  
    // For an application-managed entity manager its best practice to create a
    // new entity manager inside a method and close it before the method is finished.
	  
	// When using transactions outside an enterprise application server you need to 
    // close (commit or rollback) the transaction in the same way you do for EntityManagers.
	// In order for the resources (both EntityManager and Transaction) to be closed
	// you need to use an additional level of nesting.

    String login = "";
	EntityManager em = createEntityManager();

    try {
      EntityTransaction tx = em.getTransaction();
      
      try {
        tx.begin();
        em.persist(user);
        login = user.getLogin();
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
       
    return login;
  }

  // e.g. UserDetails loadUserByUsername(String username)

  public User retrieveUser(String login) {

    EntityManager em = createEntityManager();
    User user = null;

    try {
      TypedQuery<User> query = em.createQuery("select u from User u where u.login = ?1", User.class);
      query.setParameter(1, login);
      user = query.getSingleResult();
    }
    finally {
      em.close();
    }

    return user;
  }
}
