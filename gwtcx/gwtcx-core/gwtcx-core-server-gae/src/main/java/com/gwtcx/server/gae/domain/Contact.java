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

// http://stackoverflow.com/questions/12294627/generate-setters-that-return-self-in-eclipse
// http://www.marchwicki.pl/blog/2010/11/building-a-pojo-in-an-elegant-way/
// TODO: http://stackoverflow.com/questions/4342601/building-an-object/)
// http://my.safaribooksonline.com/book/programming/java/9780137150021/creating-and-destroying-objects/ch02lev1sec2

// See: http://en.wikipedia.org/wiki/Method_chaining

package com.gwtcx.server.gae.domain;

// Don't forget to add the add the following line to persistence.xml:
// <class>com.gwtcx.core.server.gae.domain.Contact</class>

// import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Contact (Individual)
 */
@Entity
public class Contact extends Party {

  // Be sure to make all of your persistent fields private and create accessors
  // (getters and setters) for them. In addition to all the good reasons for
  // using encapsulation, if a persistent object field is accessed directly from
  // another object, this may circumvent the JPA/JDO class enhancement post-processing.

  @Column(name = EntityTokens.GIVEN_NAME_COLUMN)
  private String givenName;

  @Column(name = EntityTokens.MIDDLE_NAME_COLUMN)
  private String middleName;

  @Column(name = EntityTokens.FAMILY_NAME_COLUMN)
  private String familyName;

  // private static Logger logger = Logger.getLogger(Contact.class.getName());

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

  public String getFullName() {
    StringBuilder builder = new StringBuilder();
    builder.append(givenName);

    if (! middleName.isEmpty())
      builder.append(" " + middleName);

    if (! familyName.isEmpty())
        builder.append(" " + familyName);

    return builder.toString();
  }

}
