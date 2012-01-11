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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import net.jcip.annotations.ThreadSafe;

import com.allen_sauer.gwt.log.client.Log;

@ThreadSafe
public abstract class BaseDao {

  private static EntityManagerFactory emf;
  private static String puName; // "HSQLDB-TOMCAT7-CP-PU"

  // Thread-safe lazy initialisation
  public synchronized static EntityManager createEntityManager() {

    Log.debug("createEntityManager()");

    if (emf == null) {

      Log.debug("createEntityManagerFactory()");

      Log.debug("puName: " + puName);

      Map<String, String> props = new HashMap<String, String>();

      // The Persistence Unit name must match an entry in persistence.xml
      emf = Persistence.createEntityManagerFactory(puName, props);
    }

    return emf.createEntityManager();
  }

  public synchronized static void setPersistenceUnitName(String name) {
    puName= name;

    Log.debug("set Persistence Unit name = " + name);
  }

  public abstract Long createObject(Object object);

  public abstract List<Object> retrieveObjects(int maxResults, int firstResult);
}


/*

      // props.put("hibernate.connection.username", "sa");
      // props.put("hibernate.connection.password", "");

      // props.put("javax.persistence.jdbc.user", "sa");
      // props.put("javax.persistence.jdbc.password", "");

  private static boolean initialised = false;
  private static EntityManagerFactory emf = null;

  public static EntityManager createEntityManager() {

    Log.debug("createEntityManager()");

    if (! initialised) {

      Log.debug("createEntityManagerFactory()");

      Log.debug("puName: " + puName);

      Map<String, String> props = new HashMap<String, String>();

      // The Persistence Unit name must match an entry in persistence.xml
      emf = Persistence.createEntityManagerFactory(puName, props);

      initialised = true;
    }

    return emf.createEntityManager();
  }


*/