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

package com.gwtcx.server.gae.domain;

// import java.util.logging.Logger;

// import com.google.appengine.api.datastore.Key;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractParty
 *
 * JPA defines entities called "mapped superclasses" for the situation where you
 * don't persist an actual object of a superclass type but that all subclasses of
 * that type that are entities will also persist the values for the fields of the
 * "mapped superclass". That is a "mapped superclass" has no table to store its
 * objects in a datastore.
 *
 * See: http://www.datanucleus.org/products/accessplatform/jpa/orm/inheritance.html
 *
 */
@Entity
@MappedSuperclass
public abstract class AbstractParty {

  /*

  @Id
  @Column(name = EntityTokens.PARTY_KEY_COLUMN)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Key partyKey;

  */

  @Id
  @Column(name = EntityTokens.PARTY_ID_COLUMN)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long partyId;

  @Column(name = EntityTokens.PARTY_TYPE_COLUMN)
  @Enumerated(EnumType.STRING)
  protected String partyType;

  // private static Logger logger = Logger.getLogger(AbstractParty.class.getName());

  public Long getPartyId() {
    return partyId;
  }

  public void setPartyId(Long partyId) {
    this.partyId = partyId;
  }

  public String getPartyType() {
    return partyType;
  }

  public void setPartyType(String partyType) {
    this.partyType = partyType;
  }
}