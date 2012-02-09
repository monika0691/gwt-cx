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

package com.gwtcx.server.gae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.gwtcx.server.gae.domain.Contact;

/**
 * ContactDao: methods to create, retrieve, update and delete (CRUD) Contacts.
 */
public class ContactDao extends AbstractBaseDao {

  public Key createContact(Contact contact) {

    // For an application-managed entity manager its best practice to create a
    // new entity manager inside a method and close it before the method is finished.
    // When using transactions outside an enterprise application server you need to
    // close (commit or rollback) the transaction in the same way you do for EntityManagers.
    // Note: In order for the resources (both EntityManager and Transaction) to be closed
    // you need to use an additional level of nesting.

    Key key;
    EntityManager em = createEntityManager();

    try {
      EntityTransaction tx = em.getTransaction();

      try {
        tx.begin();
        em.persist(contact);
        key = contact.getPartyKey();
        tx.commit();
      }
      finally {
        if (tx.isActive()) tx.rollback();
      }
    }
    finally {
      em.close();
    }

    return key;
  }

  public Contact retrieveContact(Key key) {

    Contact contact = null;
    EntityManager em = createEntityManager();

    try {
      TypedQuery<Contact> query = em.createQuery("select a from Contact a where a.partyKey = ?1", Contact.class);
      query.setParameter(1, KeyFactory.keyToString(key));
      contact = query.getSingleResult();
    }
    finally {
      em.close();
    }

    return contact;
  }

  public List<Contact> retrieveContacts(int maxResults, int firstResult) {

    List<Contact> list = null;
    EntityManager em = createEntityManager();

    try {
      TypedQuery<Contact> query = em.createQuery("select a from Contact a", Contact.class);
      query.setMaxResults(maxResults);
      query.setFirstResult(firstResult);
      list = query.getResultList();
    }
    finally {
      em.close();
    }

    return list;
  }

  public Contact updateContact(Contact contact) {

    Contact contact2 = null;
    EntityManager em = createEntityManager();

    try {
      EntityTransaction tx = em.getTransaction();

      try {
        tx.begin();
        contact2 = em.merge(contact);
        tx.commit();
      }
      finally {
        if (tx.isActive()) tx.rollback();
      }
    }
    finally {
      em.close();
    }

    return contact2;
  }

  public void deleteContact(Contact contact) {

    EntityManager em = createEntityManager();

    try {
      EntityTransaction tx = em.getTransaction();

      try {
        tx.begin();
        em.remove(em.merge(contact));
        tx.commit();
      }
      finally {
        if (tx.isActive()) tx.rollback();
      }
    }
    finally {
      em.close();
    }
  }
}