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

// Don't forget to add the add the following line to persistence.xml:
// <class>com.gwtcx.core.server.gae.domain.Contact</class>

import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Contact (Individual)
 */
@Entity
public class Contact extends AbstractParty {

  @Column(name = EntityTokens.GIVEN_NAME_COLUMN)
  protected String givenName;

  @Column(name = EntityTokens.MIDDLE_NAME_COLUMN)
  protected String middleName;

  @Column(name = EntityTokens.FAMILY_NAME_COLUMN)
  protected String familyName;

  private static Logger logger = Logger.getLogger(Contact.class.getName());

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

}
