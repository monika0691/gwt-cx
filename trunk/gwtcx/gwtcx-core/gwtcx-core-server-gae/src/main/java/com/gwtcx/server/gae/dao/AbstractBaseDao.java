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

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * BaseDao: GAE so we don't need to worry about being @ThreadSafe
 */
public abstract class AbstractBaseDao {

  private static EntityManagerFactory emf;
  private static String puName; // e.g. "transactions-optional"

  private static Logger logger = Logger.getLogger(AbstractBaseDao.class.getName());

  // lazy initialisation
  public static EntityManager createEntityManager() {

    logger.info("createEntityManager()");

    if (emf == null) {

      logger.info("createEntityManagerFactory()");
      logger.info("puName: " + puName);

      // The Persistence Unit name must match an entry in persistence.xml
      emf = Persistence.createEntityManagerFactory(puName);
    }

    return emf.createEntityManager();
  }

  public static void setPersistenceUnitName(String name) {
    puName = name;

    logger.info("set Persistence Unit name = " + puName);
  }

  // public abstract Long createObject(Object object);

  // public abstract List<Object> retrieveObjects(int maxResults, int firstResult);
}
